/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.File

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.cucumber.Utils.WaveReport

trait WavePage extends BasePage with LandingPage {


  val title = ""

  var waveReportFlag = "N"
  var waveFailFlag = "N"
  var totalErrors = 0

  def clickWave(withErrors: Boolean): Unit = {
    val robot = new Robot()
    robot.keyPress(KeyEvent.VK_CONTROL)
    robot.keyPress(KeyEvent.VK_SHIFT)
    robot.keyPress(KeyEvent.VK_7)
    robot.delay(100)
    robot.keyRelease(KeyEvent.VK_CONTROL)
    robot.keyRelease(KeyEvent.VK_SHIFT)
    robot.keyRelease(KeyEvent.VK_7)
    val pageUrl: String = driver.getCurrentUrl
    val pageTitle = driver.getTitle.concat(if(withErrors) {
      " - Shown With Error Messages"
    } else {
      " - Shown Without Error Messages"
    })
    val dir = new File("target/wave-reports")
    dir.mkdir()

    val errorElements = driver.findElements(By.xpath("//main//img[starts-with(@alt, 'ERRORS:')]"))
    val errorsCount = errorElements.size()
    totalErrors += errorsCount
    //    println(s"Errors in current page (${pageUrl}) = ${errorsCount}")

    val alertElements = driver.findElements(By.xpath("//main//img[starts-with(@alt, 'ALERTS:')]"))
    val alertCount = alertElements.size()
    //    println(s"Alerts in current page (${pageUrl}) = ${alertCount}")

    var testStatus = "Passed"
    if(errorsCount > 0) {
      testStatus = "Failed"
      waveFailFlag = "Y"
    }
    WaveReport.buildWaveHTMLReport(testStatus, pageTitle, alertCount, errorsCount, waveReportFlag, pageUrl)
    waveReportFlag = "Y"

    robot.keyPress(KeyEvent.VK_CONTROL)
    robot.keyPress(KeyEvent.VK_SHIFT)
    robot.keyPress(KeyEvent.VK_7)
    robot.delay(100)
    robot.keyRelease(KeyEvent.VK_CONTROL)
    robot.keyRelease(KeyEvent.VK_SHIFT)
    robot.keyRelease(KeyEvent.VK_7)
  }

  def saveReport(): Unit = {
    val source = new File("src/test/Images/wavelogo.png")
    val dest = new File("target/wave-reports/wavelogo.png")
    try {
      //      FileUtils.getFileUtils.copyFile(source, dest)
    }
    catch {
      case _: Throwable => ()
    }
    WaveReport.createAccessibilityReport()
    if(totalErrors > 0) {
      assert(false, "this site has accessibility errors and/or alerts")
    }
  }
}




