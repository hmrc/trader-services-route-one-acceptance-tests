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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.specsteps.BaseStepDefSteps._
import uk.gov.hmrc.test.ui.specsteps.ContactDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.EntryDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.FinalConfirmationStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps.givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.TransportStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._

class JourneysExportSpec extends BaseSpec {

  Feature("Customs check - Export journey") {

    Scenario("A user wants to complete a New Export journey and review their answers [journey=Export, epu=123, entryNo=A23456A, requestType=New, route=Hold, transport=Maritime, email=abc@test.com, transportName=PlanEx, file=testOdp.odp]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 123 and A23456A")
        whenTheUserEntersEntryDetailsXAndX("123", "A23456A")

      And("the user enters today's date for entryDate")
      andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the Export Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Export")

      When("the user is on the Request type page, selects New and continues")
        whenTheUserIsOnTheRequestTypePageSelectsXAndContinues("New")

      Then("the user will be on the Export Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Export")

      Then("the user is on the Route type page, selects Hold and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Hold")

      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      When("the user is on the Transport type page, selects Maritime and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Maritime")

      Then("the user will be on the Export Transport details page")
        thenTheUserWillBeOnTheXTransportDetailsPage("Export")

      And("the user enters PlanEx for transport name")
        thenTheUserEntersXForTransportName("PlanEx")
      And("the user enters today's date for transportDateDeparture")
        andTheUserEntersTodaysDateForX("transportDateDeparture")
      And("the user enters a time of Departure for their transportation \"13\" \"37\"")
        thenTheUserEntersATimeOfXForTheirTransportationXX("Departure", "13", "37")
      And("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Export Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Export")

      And("the user enters an email address abc@test.com")
        andTheUserEntersAnEmailAddressX("abc@test.com")

      And("the user enters a phone number 00447123456789")
        andTheUserEntersAPhoneNumberX("00447123456789")

      And("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user will only see inset text for Request type N/A")
        andTheUserWillOnlySeeInsetTextForRequestTypeX("N/A")
      And("the user clicks the button to upload file 1 and selects testOdp.odp")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testOdp.odp")
      When("the user clicks continue when files have finished uploading")
        andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Export CYA page")
        thenTheUserWillBeOnTheXCYAPage("Export")

      And("the user should see the EPU & Entry No Rows on the CYA page")
        thenTheUserShouldSeeTheEPUAndEntryNoRowsOnTheCYAPage()

      And("the user should see the Entry Date row & the date on the CYA page")
        thenTheUserShouldSeeTheEntryDateRowAndTheDateOnTheCYAPage()
      And("the user should see the Export Request type row on the CYA page")
        thenTheUserShouldSeeTheXRequestTypeRowOnTheCYAPage("Export")
      And("the user should see the Route row on the CYA page")
        thenTheUserShouldSeeTheRouteRowOnTheCYAPage()
      And("the user should see the Priority YN row on the CYA page")
        thenTheUserShouldSeeThePriorityYNRowOnTheCYAPage()
      And("the user answered NoToPriority then they should see the correct responses for the Export journey")
        whenTheUserAnsweredXThenTheyShouldSeeTheCorrectResponsesForTheExportJourney("NoToPriority")
      And("the user should see the Transport name row on the CYA page")
        thenTheUserShouldSeeTheTransportNameRowOnTheCYAPage()
      And("the user should see the Transport date Departure row on the CYA page")
        thenTheUserShouldSeeTheTransportDateXRowOnTheCYAPage("Departure")
      And("the user should see the Transport time Departure row on the CYA page")
        thenTheUserShouldSeeTheTransportTimeXRowOnTheCYAPage("Departure")
      And("the user should see the Mandatory Contact details row on the CYA page")
        thenTheUserShouldSeeTheXContactDetailsRowOnTheCYAPage("Mandatory")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")

      And("the user should see Hold SLA")
        thenTheUserShouldSeeXSLA("Hold")

    }

    Scenario("A user wants to complete a New Export journey (route 3 reason) [journey=Export, epu=129, entryNo=A23456A, requestType=New, route=Route 3, transport=Maritime, email=abc@test.com, file=testOdp.odp]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 129 and A23456A")
        whenTheUserEntersEntryDetailsXAndX("129", "A23456A")

      And("the user enters today's date for entryDate")
      andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the Export Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Export")

      When("the user is on the Request type page, selects New and continues")
        whenTheUserIsOnTheRequestTypePageSelectsXAndContinues("New")

      Then("the user will be on the Export Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Export")

      Then("the user is on the Route type page, selects Route 3 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 3")

      Then("the user will be on the Export Reason page")
        thenTheUserWillBeOnTheXReasonPage("Export")

      When("the user enters valid characters in the reason field and continues")
        whenTheUserEntersXCharactersInTheReasonFieldAndContinues("valid")

      Then("the user will be on the Export YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Export")

      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      When("the user is on the Transport type page, selects Maritime and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Maritime")

      Then("the user will be on the Export Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Export")

      And("the user enters an email address ab@test.com")
        andTheUserEntersAnEmailAddressX("ab@test.com")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user will only see inset text for Request type N/A")
        andTheUserWillOnlySeeInsetTextForRequestTypeX("N/A")

      And("the user clicks the button to upload file \"1\" and selects \"testOdp.odp\"")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testOdp.odp")

      When("the user clicks continue when files have finished uploading")
      andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Export CYA page")
        thenTheUserWillBeOnTheXCYAPage("Export")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")
    }
  }
}
