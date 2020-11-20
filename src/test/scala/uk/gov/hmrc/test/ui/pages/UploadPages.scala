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

import org.openqa.selenium.{By, WebElement}

trait UploadPages extends BasePage {

  val urlUpload: String = traderServicesBaseUrl + "/file-upload"
  val urlUploadAmend: String = traderServicesBaseUrl + "/amend/file-upload"

  val headingUpload = "Upload your first document"
  val headingUploadAnother = "Upload another document"

  val urlUploadVer: String = traderServicesBaseUrl + "/file-verification"

  val headingUploadConfirm1 = "You have uploaded 1 document"
  val headingUploadConfirm2 = "You have uploaded 2 documents"
  val headingUploadConfirm3 = "You have uploaded 3 documents"

  val urlUploaded: String = traderServicesBaseUrl + "/file-uploaded"
  val urlUploadedAmend: String = traderServicesBaseUrl + "/amend/file-uploaded"

  val usrDir = System.getProperty("user.dir") + "/src/test/resources/uploadFiles/"
  var filePath = ""

  val chooseFileId = "upload-file"

  def uploadFile(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId)

  def uploadFilesToBrowser(fileSeq: String, elementID: String): Unit = {
    fileSeq match {
      case "first" => filePath = usrDir + "test.jpg"
      case "next" => filePath = usrDir + "testNCH1.pdf"
      case "last" => filePath = usrDir + "govuk.xls"
    }
    driver.findElement(By.id(elementID)).sendKeys(filePath)
  }

  def noConditionalReveal:WebElement = findElementById("conditional-uploadAnotherFile-2")
}


//Step for file verification page/css processing ring
//val fluentWaitUpload: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
//.withTimeout(Duration.ofSeconds(60))
//.pollingEvery(Duration.ofMillis(250))
