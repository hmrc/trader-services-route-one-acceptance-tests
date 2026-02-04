/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps

import uk.gov.hmrc.test.ui.specpage.UploadMultiPages

object UploadMultiStepDefsSteps extends UploadMultiPages  {

  // ^the user will be on the multi-file upload pages for (.*)
  def thenTheUserWillBeOnTheMultiFileUploadPagesForX(journey: String): Unit = {
    journey match {
          case "New"   => confirmUrl(urlUploadMulti)
          case "Amend" => confirmUrl(urlUploadMultiAmend)
        }
  }

  // ^the user clicks the button to add another document
  def thenTheUserClicksTheButtonToAddAnotherDocument(): Unit = {
    uploadAnother()
  }

  // ^the user clicks the button to upload file "(.*)" and selects "(.*)"
  def thenTheUserClicksTheButtonToUploadFileXAndSelectsX(fileOrder: String, file: String): Unit = {
    uploadFile(file, s"$fileOrder")
  }

  // ^the user clicks continue when files have finished uploading
  def andTheUserClicksContinueWhenFilesHaveFinishedUploading(): Unit = {
    clickUploadContinueMFU()

        if (isElementVisible(".file-upload__spinner")) {
          notFindElementByCss(".file-upload__spinner")
          clickUploadContinueMFU()
        } else {
          assert(!isElementVisible(".file-upload__spinner"))
        }
  }

  // ^the user will only see inset text for Request type (.*)
  def andTheUserWillOnlySeeInsetTextForRequestTypeX(exportRq: String): Unit = {
    exportRq match {
          case formRef @ "C1601" => assertElementTextContains(formRef, insetText)
          case formRef @ "C1602" => assertElementTextContains(formRef, insetText)
          case formRef @ "C1603" => assertElementTextContains(formRef, insetText)
          case "N/A"             => assertElementIsNotVisibleById("govuk-inset-text")
        }
  }

  // ^the user clicks MFU continue
  def andTheUserClicksMFUContinue(): Unit = {
    clickUploadContinueMFU()
  }

}
