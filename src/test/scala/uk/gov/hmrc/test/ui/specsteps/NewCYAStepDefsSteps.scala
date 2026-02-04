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

import uk.gov.hmrc.test.ui.specpage.NewCYAPage

object NewCYAStepDefsSteps extends NewCYAPage{

  // ^the user will be on the (.*) CYA page - mandatory$
  def thenTheUserWillBeOnTheXCYAPageMandatory(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlImportCYA)
          case "Export" => confirmUrl(urlExportCYA)
        }
        verifyH2EntryDetails()
        verifyH2Questions()
  }

  // ^the user will be on the (.*) CYA page$
  def thenTheUserWillBeOnTheXCYAPage(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlImportCYA)
          case "Export" => confirmUrl(urlExportCYA)
        }
        verifyH2EntryDetails()
        verifyH2Questions()
  }

  // ^the user should see the EPU & Entry No Rows on the CYA page$
  def thenTheUserShouldSeeTheEPUAndEntryNoRowsOnTheCYAPage(): Unit = {
    verifyEpuRow()
        verifyEpuAnswer()
        verifyEntryNoRow()
        verifyEntryNoAnswer()
  }

  // ^the user should see the Entry Date row & the date on the CYA page$
  def thenTheUserShouldSeeTheEntryDateRowAndTheDateOnTheCYAPage(): Unit = {
    verifyEntryDateAnswer()
  }

  // ^the user should see the (.*) Request type row on the CYA page$
  def thenTheUserShouldSeeTheXRequestTypeRowOnTheCYAPage(journey: String): Unit = {
    assertElementTextContains(journey.toLowerCase, firstQRow)
        verifyFirstQAnswer()
  }

  // ^the user should see the Route row on the CYA page$
  def thenTheUserShouldSeeTheRouteRowOnTheCYAPage(): Unit = {
    verifySecondQAnswer()
  }

  // ^the user should see the Priority YN row on the CYA page$
  def thenTheUserShouldSeeThePriorityYNRowOnTheCYAPage(): Unit = {
    verifyThirdQAnswer()
  }

  // ^the user answered (.*) then they should see the correct responses for the Import journey$
  def whenTheUserAnsweredXThenTheyShouldSeeTheCorrectResponsesForTheImportJourney(yesNo: String): Unit = {
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

  // ^the user answered (.*) then they should see the correct responses for the Export journey$
  def whenTheUserAnsweredXThenTheyShouldSeeTheCorrectResponsesForTheExportJourney(yesNo: String): Unit = {
      yesNo match {
        case "YesToPriority" =>
          verifyFourthQAnswer()
          verifyFifthQAnswer()

        case "NoToPriority" =>
          verifyFourthQAnswer()
      }
  }

  // ^the user should see the Transport name row on the CYA page$
  def thenTheUserShouldSeeTheTransportNameRowOnTheCYAPage(): Unit = {
    verifyH2Vessel()
        verifySeventhRowFirstAnswer()
  }

  // ^the user should see the Transport date (.*) row on the CYA page$
  def thenTheUserShouldSeeTheTransportDateXRowOnTheCYAPage(journey: String): Unit = {
    assertElementTextContains(journey.toLowerCase, seventhRowSecondQ)
        verifySeventhRowSecondAnswer()
  }

  // ^the user should see the Transport time (.*) row on the CYA page$
  def thenTheUserShouldSeeTheTransportTimeXRowOnTheCYAPage(journey: String): Unit = {
    assertElementTextContains(journey.toLowerCase, seventhRowThirdQ)
        verifySeventhRowThirdAnswer()
  }

  // ^the user should see the (.*) Contact details row on the CYA page$
  def thenTheUserShouldSeeTheXContactDetailsRowOnTheCYAPage(contactDetails: String): Unit = {
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

  // ^the user clicks the change link for (.*)$
  def whenTheUserClicksTheChangeLinkForX(changeLink: String): Unit = {
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
