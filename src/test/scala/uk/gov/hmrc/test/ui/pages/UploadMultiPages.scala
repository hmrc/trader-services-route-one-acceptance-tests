/*
 * Copyright 2023 HM Revenue & Customs
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

trait UploadMultiPages extends BasePage {

  val urlUploadMulti: String      = traderServicesBaseUrl + "/new/upload-files"
  val urlUploadMultiAmend: String = traderServicesBaseUrl + amendUrl + "/upload-files"

  val usrDir   = System.getProperty("user.dir") + "/src/test/resources/uploadFiles/"
  var filePath = ""

  def chooseFileId(order: String): String = "file-" + s"$order"

  def uploadFile(fileSeq: String, order: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId(s"$order"))

  def uploadAnother(): Unit = findElementByCss(".multi-file-upload__add-another").click()

  def insetText: WebElement = findElementByCss(".govuk-inset-text")

  def uploadFilesToBrowser(fileSeq: String, elementID: String): Unit = {
    fileSeq match {
      case "testJpg.jpg"   => filePath = usrDir + "testJpg.jpg"
      case "testJpeg.jpeg" => filePath = usrDir + "testJpeg.jpeg"

      case "testTif.TIF"   => filePath = usrDir + "testTif.TIF"
      case "testTiff.tiff" => filePath = usrDir + "testTiff.tiff"

      case "testPng.png" => filePath = usrDir + "testPng.png"

      case "testPdf.pdf" => filePath = usrDir + "testPdf.pdf"

      case "testDoc.doc"   => filePath = usrDir + "testDoc.doc"
      case "testDocx.docx" => filePath = usrDir + "testDocx.docx"
      case "testOdt.odt"   => filePath = usrDir + "testOdt.odt"

      case "testXls.xls"   => filePath = usrDir + "testXls.xls"
      case "testXlsx.xlsx" => filePath = usrDir + "testXlsx.xlsx"
      case "testOds.ods"   => filePath = usrDir + "testOds.ods"

      case "testPpt.ppt"   => filePath = usrDir + "testPpt.ppt"
      case "testPptx.pptx" => filePath = usrDir + "testPptx.pptx"
      case "testOdp.odp"   => filePath = usrDir + "testOdp.odp"

      case "testTxt.txt" => filePath = usrDir + "testTxt.txt"
      case "testMsg.msg" => filePath = usrDir + "testMsg.msg"

      // The number is the amount of seconds to simulate file transfer time - can be altered
      case "delay.txt" => filePath = usrDir + "delay55.txt"
    }
    driver.findElement(By.id(elementID)).sendKeys(filePath)
  }
}
