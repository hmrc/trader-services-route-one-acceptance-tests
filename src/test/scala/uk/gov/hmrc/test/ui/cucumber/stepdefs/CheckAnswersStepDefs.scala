/*
 * Copyright 2020 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.{BasePage, CheckAnswersPage, ContactDetailsPage}


class CheckAnswersStepDefs extends CheckAnswersPage with BasePage with ContactDetailsPage with ScalaDsl with EN {

  Given("""^the user is on the (.*) CYA page$""") { (Journey: String) =>
    Journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyHeading(headingMainCYA)
    verifyH2Declaration(h2Dec)
    verifyH2Questions(h2Questions)
    verifyH2Vessel(h2Vessel)
    verifyH2Contact(h2ContactDetails)
  }

  Then("""^the user should see the EPU & Entry No Rows & the correct responses (.*) & (.*) on the CYA page$""") { (EPU: String, EntryNo:String) =>
    assertElementText(summaryEPU, epuRow)
    assertElementText(EPU, epuAnswer)

    assertElementText(summaryEntryNo, entryNoRow)
    assertElementText(EntryNo, entryNoAnswer)
  }

  Then("""^the user should see the Entry Date row & the date (.*) on the CYA page$""") { (Date: String) =>
    assertElementText(summaryEntryDate, findElementByCss("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dt:nth-child(1)"))

    Date match {
      case "Today" => assertElementText(todayDateCYA, entryDateAnswer)
      case _ => assertElementText(Date, entryDateAnswer)
    }
  }

  Then("""^the user should see the (.*) Request Type row & the correct response (.*) on the CYA page$""") { (Journey:String, Answer: String) =>

    Journey match {
      case "Import" => assertElementText(summaryImportRequest, firstQRow)
      case "Export" => assertElementText(summaryExportRequest, firstQRow)
    }
    assertElementText(Answer, firstQAnswer)
  }

  Then("""^the user should see the Route row & the correct response (.*) on the CYA page$""") { (Answer: String) =>
    assertElementText(summaryRoute, secondQRow)
    assertElementText(Answer, secondQAnswer)
  }

  Then("""^the user should see the Priority YN row & the correct response (.*) on the CYA page$""") { (Answer: String) =>
    assertElementText(summaryPriorityYN, thirdQRow)
    assertElementText(Answer, thirdQAnswer)
  }


  When("""^the user answered (.*) then they should see the correct responses for the Import journey "(.*)", "(.*)" & "(.*)"$""") {
    (YesNo:String, PriorityGoods:String, ALVS: String, Transport:String ) =>

    YesNo match {
      case "YesToPriority" => assertElementText (summaryPriorityGoods, fourthQRow)
                              assertElementText (PriorityGoods, fourthQAnswer)

                              assertElementText (summaryALVS, fifthQRow)
                              assertElementText (ALVS, fifthQAnswer)

                              assertElementText (summaryTransport, sixthQRow)
                              assertElementText (Transport, sixthQAnswer)


      case "NoToPriority" =>  assertElementText (summaryALVS, fourthQRow)
                              assertElementText (ALVS, fourthQAnswer)

                              assertElementText (summaryTransport, fifthQRow)
                              assertElementText (Transport, fifthQAnswer)
    }
  }

  When("""^the user answered (.*) then they should see the correct responses for the Export journey "(.*)" & "(.*)"$""") {
    (YesNo:String, PriorityGoods:String, Transport:String ) =>

      YesNo match {
        case "YesToPriority" => assertElementText (summaryPriorityGoods, fourthQRow)
                                assertElementText (PriorityGoods, fourthQAnswer)

                                assertElementText (summaryTransport, fifthQRow)
                                assertElementText (Transport, fifthQAnswer)

        case "NoToPriority" => assertElementText (summaryTransport, fourthQRow)
                               assertElementText (Transport, fourthQAnswer)
      }
  }


  Then("""^the user should see the Vessel Name row & the correct response "(.*)" on the CYA page$""") { (Answer: String) =>
    assertElementText(summaryVesselName, vesselNameRow)
    assertElementText(Answer, vesselNameAnswer)
  }
  Then("""^the user should see the Vessel Date row & the correct response "(.*)" on the CYA page$""") { (Answer: String) =>
    assertElementText(summaryVesselDate, vesselDateRow)
    Answer match {
      case "Today" => assertElementText(todayDateCYA, vesselDateAnswer)
      case _ =>     assertElementText(Answer, vesselDateAnswer)
    }
  }
  Then("""^the user should see the Vessel Time row & the correct response "(.*)" on the CYA page$""") { (Answer: String) =>
    assertElementText(summaryVesselTime, vesselTimeRow)
    assertElementText(Answer, vesselTimeAnswer)
  }


  Then("""^the user should see the (.*) Contact details row & the correct responses "(.*)", "(.*)" & "(.*)" on the CYA page$""") {
    (ContactDetails: String, AnswerName: String, AnswerEmail: String, AnswerPhone: String) =>

      ContactDetails match {

        case "Full" =>
      assertElementText (h2ContactDetails, contactDetailRow)
      assertElementText (AnswerName, contactDetailAnswerName)
      assertElementText (AnswerEmail, contactDetailAnswerEmail)
      assertElementText (AnswerPhone, contactDetailAnswerPhone)

        case "Mandatory" =>
          assertElementText (h2ContactDetails, contactDetailRow)
          assertElementText (AnswerName, contactDetailAnswerName)
      }
  }


  When("""^the user clicks the change link for (.*)$""") { (changeLink: String) =>
    changeLink match {

      case "Declaration" => clickHref("a[href*='declaration-details']")
      case "Request" => clickHref("a[href*='request-type']")
      case "Route" => clickHref("a[href*='route']")
      case "PriorityYN" => clickHref("a[href*='priority-goods']")
      case "PriorityGoods" => clickHref("a[href*='which-priority-goods']")
      case "ALVS" => clickHref("a[href*='automatic-licence-verification']")
      case "Transport" => clickHref("a[href*='transport-type']")
      case "Vessel" => clickHref("a[href*='vessel-info']")
      case "ContactDetails" => clickHref("a[href*='contact-info']")
    }
  }
  }