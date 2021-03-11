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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadPages}


class UploadStepDefs extends BasePage with UploadPages with ScalaDsl with EN {


  Then("""^the user navigates to the single file (.*) upload page"""){ (page:String) =>

    page match {
      case "New" => navigateTo(urlUpload)
                    confirmUrl(urlUpload)
      case "Amend" => navigateTo(urlUploadAmend)
                      confirmUrl(urlUploadAmend)
    }
    verifyHeading(headingUpload)
  }

  Then("""^the user is on the (.*) upload page"""){ (page:String) =>

    page match {
      case "First" => confirmUrl(urlUpload)
                      verifyHeading(headingUpload)
      case "Another" => confirmUrl(urlUpload)
                        verifyHeading(headingUploadAnother)
      case "Amend" => confirmUrl(urlUploadAmend)
                      verifyHeading(headingUpload)
      case "AnotherAmend" => confirmUrl(urlUploadAmend)
                             verifyHeading(headingUploadAnother)
    }
  }

  Then("""^the user clicks the button to upload and selects the "([^"]*)" file"""){ (file:String) =>
    Thread.sleep(500L)
    uploadFileSFU(file)
    clickByCSS(".file-upload__submit")
  }

  Then("""^the user should be on the (.*) file upload confirmation page after uploading (.*) document/s"""){
    (journey:String, docAmount:String) =>

      journey match {
        case "new" => confirmUrlUpload(urlUploaded)
        case "amend" => confirmUrlUpload(urlUploadedAmend)
      }
      docAmount match {
      case "1" => verifyHeading (headingUploadConfirm1)
      case "2" => verifyHeading (headingUploadConfirm2)
      case "3" => verifyHeading (headingUploadConfirm3)
      }
  }

  Then("""^the user should see their first uploaded doc (.*) on upload review page$""") { (Answer: String) =>
    findElementByCss("div.govuk-summary-list__row:nth-child(1) > dt:nth-child(1)").isDisplayed
    findElementByCss("div.govuk-summary-list__row:nth-child(1) > dd:nth-child(2)").getText shouldBe Answer
  }

  When("""^the user clicks the button to remove a document$""") { () =>
  clickHref("a[href*='remove']")
  }

  Then("""^the user should see the message saying they have uploaded the max amount of docs""") { () =>
    assertElementText("You’ve uploaded the maximum number of files and cannot add any more.",
    findElementByCss("p.govuk-body"))
  }

  Then("""^the user selects (.*) to uploading another file""") { (yesNo: String) =>
    yesNo match {
      case "Yes" => clickByCSS("#uploadAnotherFile")
      case "No" => clickByCSS("#uploadAnotherFile-2")
      case "NoOption" =>
    }
    clickUploadContinueSFU()
  }
}