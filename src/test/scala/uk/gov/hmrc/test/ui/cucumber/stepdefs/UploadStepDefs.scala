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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadPages}

class UploadStepDefs extends BasePage with UploadPages with ScalaDsl with EN {

  Then("""^the user navigates to the single file (.*) upload page""") { (page: String) =>
    page match {
      case "New"   =>
        navigateTo(urlUpload)
        confirmUrl(urlUpload)
      case "Amend" =>
        navigateTo(urlUploadAmend)
        confirmUrl(urlUploadAmend)
    }
  }

  Then("""^the user will be on the (.*) upload page""") { (page: String) =>
    page match {
      case "First"        => confirmUrl(urlUpload)
      case "Another"      => confirmUrl(urlUpload)
      case "Amend"        => confirmUrl(urlUploadAmend)
      case "AnotherAmend" => confirmUrl(urlUploadAmend)
    }
  }

  Then("""^the user clicks the button to upload and selects the "([^"]*)" file""") { (file: String) =>
    uploadFileSFU(file)
    clickByCSS(".file-upload__submit")
  }

  Then("""^the user should be on the (.*) file upload confirmation page""") { (journey: String) =>
    journey match {
      case "new"   => confirmUrlUpload(urlUploaded)
      case "amend" => confirmUrlUpload(urlUploadedAmend)
    }
  }

  Then("""^the user should see their first uploaded doc on upload review page$""") { () =>
    assertIsVisible("div.govuk-summary-list__row:nth-child(1) > dt:nth-child(1)")
    assertIsVisible("div.govuk-summary-list__row:nth-child(1) > dd:nth-child(2)")
  }

  When("""^the user clicks the button to remove a document$""") { () =>
    clickHref("a[href*='remove']")
  }

  Then("""^the user selects (.*) to uploading another file""") { (yesNo: String) =>
    yesNo match {
      case "Yes" => clickByCSS("#uploadAnotherFile")
      case "No"  => clickByCSS("#uploadAnotherFile-2")
      case _     =>
    }
    clickUploadContinueSFU()
  }

  And("""^the user clicks SFU upload""") { () =>
    clickByCSS(".file-upload__submit")
  }
}
