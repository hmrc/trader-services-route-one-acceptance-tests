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
import uk.gov.hmrc.test.ui.pages.{BasePage, ContactDetailsPage, NewCYAPage}


class NewCYAStepDefs extends NewCYAPage with BasePage with ContactDetailsPage with ScalaDsl with EN {

  Given("""^the user is on the (.*) CYA page$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyHeading(headingMainCYA)
    verifyH2EntryDetails(h2Entry)
    verifyH2Questions(h2Questions)
    verifyH2Vessel(h2Vessel)
    verifyH2Contact(h2ContactDetails)
  }

  //todo
  //
  //  EPU match {
  //    case "randomEPU" =>   assertElementText(randomEPU, epuAnswer)
  //    case _ =>   assertElementText(EPU, epuAnswer)
  //  }

  Then("""^the user should see the EPU & Entry No Rows & the correct responses (.*) & (.*) on the CYA page$""") {
    (EPU: String, EntryNo: String) =>

      assertElementText(summaryEPU, epuRow)
      assertElementText(EPU, epuAnswer)

      assertElementText(EPU, epuAnswer)

      assertElementText(summaryEntryNo, entryNoRow)
      assertElementText(EntryNo, entryNoAnswer)
  }

  Then("""^the user should see the Entry Date row & the date (.*) on the CYA page$""") { (Date: String) =>
    assertElementText(summaryEntryDate, entryDateRow)

    Date match {
      case "Today" => assertElementText(todayDateCYA, entryDateAnswer)
      case _ => assertElementText(Date, entryDateAnswer)
    }
  }

  Then("""^the user should see the (.*) Request Type row & the correct response (.*) on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Import" => assertElementText(summaryImportRequest, firstQRow)
        case "Export" => assertElementText(summaryExportRequest, firstQRow)
      }
      assertElementText(answer, firstQAnswer)
  }

  Then("""^the user should see the Route row & the correct response (.*) on the CYA page$""") { (answer: String) =>
    assertElementText(summaryRoute, secondQRow)
    assertElementText(answer, secondQAnswer)
  }

  Then("""^the user should see the Priority YN row & the correct response (.*) on the CYA page$""") { (answer: String) =>
    assertElementText(summaryPriorityYN, thirdQRow)
    assertElementText(answer, thirdQAnswer)
  }


  When("""^the user answered (.*) then they should see the correct responses for the Import journey "(.*)", "(.*)" & "(.*)"$""") {
    (yesNo: String, priorityGoods: String, alvs: String, transport: String) =>

      yesNo match {
        case "YesToPriority" =>
          assertElementText(summaryPriorityGoods, fourthQRow)
          assertElementText(priorityGoods, fourthQAnswer)

          assertElementText(summaryALVS, fifthQRow)
          assertElementText(alvs, fifthQAnswer)

          assertElementText(summaryTransport, sixthQRow)
          assertElementText(transport, sixthQAnswer)


        case "NoToPriority" =>
          assertElementText(summaryALVS, fourthQRow)
          assertElementText(alvs, fourthQAnswer)

          assertElementText(summaryTransport, fifthQRow)
          assertElementText(transport, fifthQAnswer)
      }
  }

  When("""^the user answered (.*) then they should see the correct responses for the Export journey "(.*)" & "(.*)"$""") {
    (yesNo: String, priorityGoods: String, transport: String) =>

      yesNo match {
        case "YesToPriority" =>
          assertElementText(summaryPriorityGoods, fourthQRow)
          assertElementText(priorityGoods, fourthQAnswer)

          assertElementText(summaryTransport, fifthQRow)
          assertElementText(transport, fifthQAnswer)

        case "NoToPriority" =>
          assertElementText(summaryTransport, fourthQRow)
          assertElementText(transport, fourthQAnswer)
      }
  }

  Then("""^the user should see the Vessel Name row & the correct response "(.*)" on the CYA page$""") {
    (answer: String) =>
      assertElementText(summarytransportName, transportNameRow)
      assertElementText(answer, transportNameAnswer)
  }

  Then("""^the user should see the Vessel Date (.*) row & the correct response "(.*)" on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Arrival" => assertElementText(summaryVesselArrivalDate, vesselDateRow)
        case "Departure" => assertElementText(summaryVesselDepartureDate, vesselDateRow)
      }
      answer match {
        case "Today" => assertElementText(todayDateCYA, vesselDateAnswer)
        case _ => assertElementText(answer, vesselDateAnswer)
      }
  }

  Then("""^the user should see the Vessel Time (.*) row & the correct response "(.*)" on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Arrival" =>
          assertElementText(summaryVesselArrivalTime, vesselTimeRow)
          assertElementText(answer, vesselTimeAnswer)

        case "Departure" =>
          assertElementText(summaryVesselDepartureTime, vesselTimeRow)
          assertElementText(answer, vesselTimeAnswer)
      }
  }


  Then("""^the user should see the (.*) Contact details row & the correct responses "(.*)", "(.*)" & "(.*)" on the CYA page$""") {
    (contactDetails: String, answerName: String, answerEmail: String, answerPhone: String) =>

      contactDetails match {

        case "Full" =>
          assertElementText(h2ContactDetails, contactDetailRow)
          assertElementText(answerName, contactDetailAnswerName)
          assertElementText(answerEmail, contactDetailAnswerEmail)
          assertElementText(answerPhone, contactDetailAnswerPhone)

        case "Mandatory" =>
          assertElementText(h2ContactDetails, contactDetailRow)
          assertElementText(answerEmail, contactDetailAnswerEmailOnly)
      }
  }


  When("""^the user clicks the change link for (.*)$""") { (changeLink: String) =>
    changeLink match {

      case "Entry" => clickHref("a[href*='entry-details']")
      case "Request" => clickHref("a[href*='request-type']")
      case "Route" => clickHref("a[href*='route']")
      case "PriorityYN" => clickHref("a[href*='priority-goods']")
      case "PriorityGoods" => clickHref("a[href*='which-priority-goods']")
      case "ALVS" => clickHref("a[href*='automatic-licence-verification']")
      case "Transport" => clickHref("a[href*='transport-type']")
      case "Vessel" => clickHref("a[href*='transport-information']")
      case "ContactDetails" => clickHref("a[href*='contact-information']")
      case "Documents" => clickHref("a[href*='upload-files']")
    }
  }
}