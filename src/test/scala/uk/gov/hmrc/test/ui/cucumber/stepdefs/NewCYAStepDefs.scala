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
import uk.gov.hmrc.test.ui.pages.{BasePage, ContactDetailsPage, NewCYAPage}

class NewCYAStepDefs extends NewCYAPage with BasePage with ContactDetailsPage with ScalaDsl with EN {

  Then("""^the user will be on the (.*) CYA page - mandatory$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyH2EntryDetails()
    verifyH2Questions()
  }

  Then("""^the user will be on the (.*) CYA page$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyH2EntryDetails()
    verifyH2Questions()
  }

  Then("""^the user should see the EPU & Entry No Rows on the CYA page$""") { () =>
    verifyEpuRow()
    verifyEpuAnswer()
    verifyEntryNoRow()
    verifyEntryNoAnswer()
  }

  Then("""^the user should see the Entry Date row & the date on the CYA page$""") { () =>
    verifyEntryDateAnswer()
  }

  Then("""^the user should see the (.*) Request type row on the CYA page$""") { (journey: String) =>
    assertElementTextContains(journey.toLowerCase, firstQRow)
    verifyFirstQAnswer()
  }

  Then("""^the user should see the Route row on the CYA page$""") { () =>
    verifySecondQAnswer()
  }

  Then("""^the user should see the Priority YN row on the CYA page$""") { () =>
    verifyThirdQAnswer()
  }

  When("""^the user answered (.*) then they should see the correct responses for the Import journey$""") {
    yesNo: String =>
      yesNo match {
        case "YesToPriority" =>
          verifyFourthQAnswer()
          verifyFifthQAnswer()
          verifySixthQAnswer()

        case "NoToPriority" =>
          verifyFourthQAnswer()
          verifyFifthQAnswer()
      }
  }

  When("""^the user answered (.*) then they should see the correct responses for the Export journey$""") {
    yesNo: String =>
      yesNo match {
        case "YesToPriority" =>
          verifyFourthQAnswer()
          verifyFifthQAnswer()

        case "NoToPriority" =>
          verifyFourthQAnswer()
      }
  }

  Then("""^the user should see the Transport name row on the CYA page$""") { () =>
    verifyH2Vessel()
    verifySeventhRowFirstAnswer()
  }

  Then("""^the user should see the Transport date (.*) row on the CYA page$""") { (journey: String) =>
    assertElementTextContains(journey.toLowerCase, seventhRowSecondQ)
    verifySeventhRowSecondAnswer()
  }

  Then("""^the user should see the Transport time (.*) row on the CYA page$""") { (journey: String) =>
    assertElementTextContains(journey.toLowerCase, seventhRowThirdQ)
    verifySeventhRowThirdAnswer()
  }

  Then("""^the user should see the (.*) Contact details row on the CYA page$""") { (contactDetails: String) =>
    verifyH2Contact()
    contactDetails match {

      case "Full" =>
        verifyEighthRowFirstQ()
        verifyEighthRowFirstAnswer()
        verifyEighthRowSecondAnswer()
        verifyEighthRowThirdAnswer()

      case "Mandatory" =>
        verifyEighthRowFirstQ()
        verifyContactDetailAnswerEmailOnly()
    }
  }

  When("""^the user clicks the change link for (.*)$""") { (changeLink: String) =>
    changeLink match {

      case "Entry"            => clickHref("a[href*='entry-details']")
      case "Request"          => clickHref("a[href*='request-type']")
      case "Route"            => clickHref("a[href*='route']")
      case "PriorityYN"       => clickHref("a[href*='priority-goods']")
      case "PriorityGoods"    => clickHref("a[href*='which-priority-goods']")
      case "ALVS"             => clickHref("a[href*='automatic-licence-verification']")
      case "Transport"        => clickHref("a[href*='transport-type']")
      case "TransportDetails" => clickHref("a[href*='transport-information']")
      case "ContactDetails"   => clickHref("a[href*='contact-information']")
      case "Documents"        => clickHref("a[href*='upload-files']")
    }
  }
}
