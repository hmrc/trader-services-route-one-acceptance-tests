/*
 * Copyright 2022 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadMultiPages}

class UploadMultiStepDefs extends BasePage with UploadMultiPages with ScalaDsl with EN {

  Then("""^the user will be on the multi-file upload pages for (.*)""") { (journey: String) =>
    journey match {
      case "New"   => confirmUrl(urlUploadMulti)
      case "Amend" => confirmUrl(urlUploadMultiAmend)
    }
  }

  Then("""^the user clicks the button to add another document""") { () =>
    uploadAnother()
  }

  Then("""^the user clicks the button to upload file "(.*)" and selects "(.*)"""") {
    (fileOrder: String, file: String) =>
      Thread.sleep(250L)
      uploadFile(file, s"$fileOrder")
  }

  And("""^the user clicks continue when files have finished uploading""") { () =>
    clickUploadContinueMFU()

    if (isElementVisible(".file-upload__spinner")) {
      notFindElementByCss(".file-upload__spinner")
      clickUploadContinueMFU()
    } else {
      assert(!isElementVisible(".file-upload__spinner"))
    }
  }

  And("""^the user will only see inset text for Request type (.*)""") { (exportRq: String) =>
    exportRq match {
      case formRef @ "C1601" => assertElementTextContains(formRef, insetText)
      case formRef @ "C1602" => assertElementTextContains(formRef, insetText)
      case formRef @ "C1603" => assertElementTextContains(formRef, insetText)
      case "N/A"             => assertElementIsNotVisibleById("govuk-inset-text")
    }
  }

  And("""^the user clicks MFU continue""") { () =>
    clickUploadContinueMFU()
  }
}
