/*
 * Copyright 2021 HM Revenue & Customs
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

  val urlUploadMulti: String = traderServicesBaseUrl + "/new/upload-files"
  val urlUploadMultiAmend: String = traderServicesBaseUrl + amendUrl + "/upload-files"

  val urlUpload: String = traderServicesBaseUrl + "/new/file-upload"
  val urlUploadAmend: String = traderServicesBaseUrl + amendUrl + "/file-upload"

  val headingUpload = "Upload your documents"

  val usrDir = System.getProperty("user.dir") + "/src/test/resources/uploadFiles/"
  var filePath = ""

  val chooseFileId1 = "file-1"
  val chooseFileId2 = "file-2"
  val chooseFileId3 = "file-3"
  val chooseFileId4 = "file-4"
  val chooseFileId5 = "file-5"
  val chooseFileId6 = "file-6"
  val chooseFileId7 = "file-7"
  val chooseFileId8 = "file-8"
  val chooseFileId9 = "file-9"
  val chooseFileId10 = "file-10"

  def uploadFile1(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId1)
  def uploadFile2(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId2)
  def uploadFile3(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId3)
  def uploadFile4(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId4)
  def uploadFile5(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId5)
  def uploadFile6(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId6)
  def uploadFile7(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId7)
  def uploadFile8(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId8)
  def uploadFile9(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId9)
  def uploadFile10(fileSeq: String): Unit = uploadFilesToBrowser(fileSeq, chooseFileId10)

  def uploadAnother(): Unit = findElementByCss(".multi-file-upload__add-another").click()

  def swirlyRing: WebElement = findElementByCss(".file-upload__spinner")

  def insetText:WebElement = findElementByCss(".govuk-inset-text")

  def uploadFilesToBrowser(fileSeq: String, elementID: String): Unit = {
    fileSeq match {
      case "jpg" => filePath = usrDir + "testJpg.jpg"
      case "jpeg" => filePath = usrDir + "testJpeg.jpeg"

      case "TIF" => filePath = usrDir + "testTif.TIF"
      case "tiff" => filePath = usrDir + "testTiff.tiff"

      case "png" => filePath = usrDir + "testPng.png"

      case "pdf" => filePath = usrDir + "testPdf.pdf"
      case "C1601" => filePath = usrDir + "C1601.pdf"
      case "C1602" => filePath = usrDir + "C1602.pdf"

      case "doc" => filePath = usrDir + "testDoc.doc"
      case "docx" => filePath = usrDir + "testDocx.docx"
      case "odt" => filePath = usrDir + "testOdt.odt"

      case "xls" => filePath = usrDir + "testXls.xls"
      case "xlsx" => filePath = usrDir + "testXlsx.xlsx"
      case "ods" => filePath = usrDir + "testOds.ods"

      case "ppt" => filePath = usrDir + "testPpt.ppt"
      case "pptx" => filePath = usrDir + "testPptx.pptx"
      case "odp" => filePath = usrDir + "testOdp.odp"

      case "txt" => filePath = usrDir + "testTxt.txt"
      case "msg" => filePath = usrDir + "testMsg.msg"
    }
    driver.findElement(By.id(elementID)).sendKeys(filePath)
  }
}