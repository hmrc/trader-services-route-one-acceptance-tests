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

package uk.gov.hmrc.test.ui.cucumber.runner

import java.io.File

import cucumber.api.Scenario
import cucumber.api.java.{After, Before}
import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith
import org.junit.{AfterClass, BeforeClass}
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriverException}
import uk.gov.hmrc.extentreport.ExtentProperties.webDriver
import uk.gov.hmrc.extentreport.{ExtentProperties, Reporter}
import uk.gov.hmrc.test.ui.conf.Configuration
import uk.gov.hmrc.test.ui.conf.Configuration.driverInstance
import uk.gov.hmrc.test.ui.pages.BasePage

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.test.ui.cucumber.stepdefs"),
  plugin = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json",
    "junit:target/test-reports/TEST-cucumber-junit-report.xml"),
  tags = "@TraderService"

)
class Runner
object Runner extends Runner with BasePage {

  @Before
  def initialize(): Unit = {
    webDriver.manage().deleteAllCookies()
    webDriver.navigate.refresh()
    webDriver.manage().deleteAllCookies()
  }

  @BeforeClass
  def setupUser(): Unit = {
    navigateTo(Configuration.settings.SIGN_IN_PAGE)
    login()
    createUser()
    clickByCSS("#update")
  }
  @BeforeClass
  def setup(): Unit = {
    val dirName = "target/test-reports/html-report"
    val extentProperties = ExtentProperties.INSTANCE
    val dir = new File(dirName)
    val successful = dir.mkdir()
    ExtentProperties.create(driverInstance, dirName + "/index.html")
  }

  @AfterClass
  def destroyUser(): Unit = {
    navigateTo("http://localhost:9099/agents-external-stubs/")
    clickByCSS("#destroyPlanet")
    driver.switchTo().alert().accept()
  }

  @AfterClass
  def writeExtentReport(): Unit =
    Reporter.loadXMLConfig("src/test/resources/extent-config.xml")

  @After
  def tearDown(result: Scenario) {
    if (result.isFailed) {
      webDriver match {
        case screenshot1: TakesScreenshot =>
          try {
            val screenshot = screenshot1.getScreenshotAs(OutputType.BYTES)
            result.embed(screenshot, "image/png")
          } catch {
            case somePlatformsDontSupportScreenshots: WebDriverException => System.err.println(somePlatformsDontSupportScreenshots.getMessage)
          }
        case _ =>
      }
    }
  }
}
//"uk.gov.hmrc.extentreport.ExtentCucumberFormatter:target/test-reports/html-report/index.html"
//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
//"junit:target/test-reports/TEST-cucumber-junit-report.xml"
