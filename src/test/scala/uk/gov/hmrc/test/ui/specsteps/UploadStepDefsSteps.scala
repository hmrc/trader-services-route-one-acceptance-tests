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

import uk.gov.hmrc.test.ui.specpage.{BasePage, UploadPages}

object UploadStepDefsSteps extends BasePage with UploadPages {

  // ^the user navigates to the single file (.*) upload page
  def thenTheUserNavigatesToTheSingleFileXUploadPage(page: String): Unit = {
    page match {
          case "New"   =>
            navigateTo(urlUpload)
            confirmUrl(urlUpload)
          case "Amend" =>
            navigateTo(urlUploadAmend)
            confirmUrl(urlUploadAmend)
        }
  }

  // ^the user will be on the (.*) upload page
  def thenTheUserWillBeOnTheXUploadPage(page: String): Unit = {
    page match {
          case "First"        => confirmUrl(urlUpload)
          case "Another"      => confirmUrl(urlUpload)
          case "Amend"        => confirmUrl(urlUploadAmend)
          case "AnotherAmend" => confirmUrl(urlUploadAmend)
        }
  }

  // ^the user clicks the button to upload and selects the "([^"]*)" file
  def thenTheUserClicksTheButtonToUploadAndSelectsTheXFile(file: String): Unit = {
    uploadFileSFU(file)
        clickByCSS(".file-upload__submit")
  }

  // ^the user should be on the (.*) file upload confirmation page
  def thenTheUserShouldBeOnTheXFileUploadConfirmationPage(journey: String): Unit = {
    journey match {
          case "new"   => confirmUrlUpload(urlUploaded)
          case "amend" => confirmUrlUpload(urlUploadedAmend)
        }
  }

  // ^the user should be on the (.*) file verification page
  def thenTheUserShouldBeOnTheXFileVerificationPage(journey: String): Unit = {
    journey match {
          case "new" => confirmUrlUpload(urlUploadVer)
          case "amend" => confirmUrlUpload(urlUploadVerAmend)
        }
  }

  // ^the user should see their first uploaded doc on upload review page$
  def thenTheUserShouldSeeTheirFirstUploadedDocOnUploadReviewPage(): Unit = {
    assertIsVisible("div.govuk-summary-list__row:nth-child(1) > dt:nth-child(1)")
        assertIsVisible("div.govuk-summary-list__row:nth-child(1) > dd:nth-child(2)")
  }

  // ^the user clicks the button to remove a document$
  def whenTheUserClicksTheButtonToRemoveADocument(): Unit = {
    clickHref("a[href*='remove']")
  }

  // ^the user selects (.*) to uploading another file
  def thenTheUserSelectsXToUploadingAnotherFile(yesNo: String): Unit = {
    yesNo match {
          case "Yes" => clickByCSS("#uploadAnotherFile")
          case "No"  => clickByCSS("#uploadAnotherFile-2")
          case _     =>
        }
        clickUploadContinueSFU()
  }

  // ^the user clicks SFU upload
  def andTheUserClicksSFUUpload(): Unit = {
    clickByCSS(".file-upload__submit")
  }

}
