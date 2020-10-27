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

import java.time.Duration

import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.{By, WebDriver}

trait UploadPages extends BasePage {

  val urlUpload: String = traderServicesBaseUrl + "/pre-clearance/file-upload"
  val headingUpload = "Upload your first document"
  val headingUploadAnother = "Upload another document"

  val urlUploadConfirm: String = traderServicesBaseUrl + "/pre-clearance/file-verification"
  val headingUploadConfirm = "You have uploaded 1 document"

  //1, 2, 3 documents etc....

  val usrDir = System.getProperty("user.dir") + "/src/test/resources/uploadFiles/"
  var filePath = ""

  val chooseFileId = "upload-file"

  val fluentWaitUpload: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(60))
    .pollingEvery(Duration.ofMillis(250))


  def uploadFile(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId)

  def uploadAnother(): Unit = clickByCSS("p.govuk-body:nth-child(3) > a:nth-child(1)")

  def uploadFilesToBrowser(fileSeq: String, elementID: String): Unit = {
    fileSeq match {
      case "first" => filePath = usrDir + "test.jpg"
      case "second"  => filePath = usrDir + "testNCH1.pdf"
      case "last"  => filePath = usrDir + "testNCH1.pdf"
    }

//    if(driver.targetBrowser.startsWith("remote")) {
//      driver.webDriver.asInstanceOf[RemoteWebDriver].setFileDetector(new LocalFileDetector)
//    }
    driver.findElement(By.id(elementID)).sendKeys(filePath)
  }

}
