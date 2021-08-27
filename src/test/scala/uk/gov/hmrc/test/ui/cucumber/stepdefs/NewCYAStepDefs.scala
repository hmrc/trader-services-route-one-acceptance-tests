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

  Then("""^the user will be on the (.*) CYA page - mandatory$""") { (journey: String) =>

    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyHeading(headingMainCYA)
    verifyH2EntryDetails(h2Entry)
    verifyH2Questions(h2Questions)

//    Thread.sleep(25000)
  }

  Then("""^the user will be on the (.*) CYA page$""") { (journey: String) =>

    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyHeading(headingMainCYA)
    verifyH2EntryDetails(h2Entry)
    verifyH2Questions(h2Questions)

//    Thread.sleep(9000)
  }

  Then("""^the user should see the EPU & Entry No Rows & the correct responses (.*) & (.*) on the CYA page$""") {
    (EPU: String, EntryNo: String) =>

      assertElementText(summaryEPU, epuRow)
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

  Then("""^the user should see the (.*) Request type row & the correct response (.*) on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Import" => assertElementText(summaryImportRequest, firstQRow)
        case "Export" => assertElementText(summaryExportRequest, firstQRow)
      }
      assertElementText(answer, firstQAnswer)
  }

  Then("""^the user should see the Route row & the correct response (.*) on the CYA page$""") { (answer: String) =>
    assertElementText(summaryRoute, secondQRow)
    assertElementTextContains(answer, secondQAnswer)
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

  Then("""^the user should see the Transport name row & the correct response "(.*)" on the CYA page$""") {
    (answer: String) =>
      verifyH2Vessel(h2Vessel)
      assertElementText(summaryTransportName, seventhRowFirstQ)
      assertElementText(answer, seventhRowFirstAnswer)
  }

  Then("""^the user should see the Transport date (.*) row & the correct response "(.*)" on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Arrival" => assertElementText(summaryVesselArrivalDate, seventhRowSecondQ)
        case "Departure" => assertElementText(summaryVesselDepartureDate, seventhRowSecondQ)
      }
      answer match {
        case "Today" => assertElementText(todayDateCYA, seventhRowSecondAnswer)
        case _ => assertElementText(answer, seventhRowSecondAnswer)
      }
  }

  Then("""^the user should see the Transport time (.*) row & the correct response "(.*)" on the CYA page$""") {
    (journey: String, answer: String) =>

      journey match {
        case "Arrival" =>
          assertElementText(summaryVesselArrivalTime, seventhRowThirdQ)
          assertElementText(answer, seventhRowThirdAnswer)

        case "Departure" =>
          assertElementText(summaryVesselDepartureTime, seventhRowThirdQ)
          assertElementText(answer, seventhRowThirdAnswer)
      }
  }


  Then("""^the user should see the (.*) Contact details row & the correct responses "(.*)", "(.*)" & "(.*)" on the CYA page$""") {
    (contactDetails: String, answerName: String, answerEmail: String, answerPhone: String) =>
      verifyH2Contact(h2ContactDetails)
      contactDetails match {

        case "Full" =>
          assertElementText(h2ContactDetails, eighthRowFirstQ)
          assertElementText(answerName, eighthRowFirstAnswer)
          assertElementText(answerEmail, eighthRowSecondAnswer)
          assertElementText(answerPhone, eighthRowThirdAnswer)

        case "Mandatory" =>
          assertElementText(h2ContactDetails, eighthRowFirstQ)
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
      case "TransportDetails" => clickHref("a[href*='transport-information']")
      case "ContactDetails" => clickHref("a[href*='contact-information']")
      case "Documents" => clickHref("a[href*='upload-files']")
    }
  }
}