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
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.TransportStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._

class JourneysImportSpec extends BaseSpec {

  Feature("Customs check - Import journey") {

    Scenario("A user wants to complete a New Import journey and review their answers [journey=Import, epu=123, entryNo=123456A, requestType=New, route=Hold, priority=Human remains, ALVS=Yes, transport=Air, transportName=S.S.E Alpha, name=Abc, email=ab@abc.com, file=testPdf.pdf]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 123 and 123456A")
        whenTheUserEntersEntryDetailsXAndX("123", "123456A")

      And("the user enters today's date for entryDate")
      andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      When("the user is on the Request type page, selects New and continues")
        whenTheUserIsOnTheRequestTypePageSelectsXAndContinues("New")

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      Then("the user is on the Route type page, selects Hold and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Hold")

      When("the user is on the YesNo Priority page, selects Yes and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("Yes")

      Then("the user is on the Priority Goods page, selects Human remains and continues")
        whenTheUserIsOnThePriorityGoodsPageSelectsXAndContinues("Human remains")

      When("the user is on the ALVS page, selects Yes and continues")
        whenTheUserIsOnTheALVSPageSelectsXAndContinues("Yes")

      When("the user is on the Transport type page, selects Air and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Air")

      Then("the user will be on the Import Transport details page")
        thenTheUserWillBeOnTheXTransportDetailsPage("Import")

      And("the user enters S.S.E Alpha for transport name")
        thenTheUserEntersXForTransportName("S.S.E Alpha")
      And("the user enters today's date for transportDateArrival")
        andTheUserEntersTodaysDateForX("transportDateArrival")
      And("the user enters a time of Arrival for their transportation \"01\" \"37\"")
        thenTheUserEntersATimeOfXForTheirTransportationXX("Arrival", "01", "37")
      And("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      And("the user enters a name Abc")
        whenTheUserEntersANameX("Abc")

      And("the user enters an email address ab@abc.com")
      andTheUserEntersAnEmailAddressX("abc@test.com")

      And("the user enters a phone number 071(234-567)89")
        andTheUserEntersAPhoneNumberX("071(234-567)89")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user will only see inset text for Request type N/A")
        andTheUserWillOnlySeeInsetTextForRequestTypeX("N/A")
      And("the user clicks the button to upload file 1 and selects testPdf.pdf")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testPdf.pdf")
      When("the user clicks continue when files have finished uploading")
        andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      Then("the user should see the EPU & Entry No Rows on the CYA page")
        thenTheUserShouldSeeTheEPUAndEntryNoRowsOnTheCYAPage()

      And("the user should see the Entry Date row & the date on the CYA page")
        thenTheUserShouldSeeTheEntryDateRowAndTheDateOnTheCYAPage()
      And("the user should see the Import Request type row on the CYA page")
        thenTheUserShouldSeeTheXRequestTypeRowOnTheCYAPage("Import")
      And("the user should see the Route row on the CYA page")
        thenTheUserShouldSeeTheRouteRowOnTheCYAPage()
      And("the user should see the Priority YN row on the CYA page")
        thenTheUserShouldSeeThePriorityYNRowOnTheCYAPage()
      And("the user answered YesToPriority then they should see the correct responses for the Import journey")
        whenTheUserAnsweredXThenTheyShouldSeeTheCorrectResponsesForTheImportJourney("YesToPriority")
      And("the user should see the Transport name row on the CYA page")
        thenTheUserShouldSeeTheTransportNameRowOnTheCYAPage()
      And("the user should see the Transport date Arrival row on the CYA page")
        thenTheUserShouldSeeTheTransportDateXRowOnTheCYAPage("Arrival")
      And("the user should see the Transport time Arrival row on the CYA page")
        thenTheUserShouldSeeTheTransportTimeXRowOnTheCYAPage("Arrival")
      And("the user should see the Full Contact details row on the CYA page")
        thenTheUserShouldSeeTheXContactDetailsRowOnTheCYAPage("Full")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")

      And("the user should see Hold SLA")
        thenTheUserShouldSeeXSLA("Hold")

      When("the user clicks the button to submit another case on the confirmation page they will go back to the start")
        whenTheUserClicksTheButtonToSubmitAnotherCaseOnTheConfirmationPageTheyWillGoBackToTheStart()

      And("the last selected option for journey type should be pre filled with Nothing")
        thenTheLastSelectedOptionForJourneyTypeShouldBePreFilledWithX("Nothing")

      When("the user clicks the cy toggle it should translate the page")
        andTheUserClicksTheXToggleItShouldTranslateThePage("cy")

      When("the user clicks the en toggle it should translate the page")
        andTheUserClicksTheXToggleItShouldTranslateThePage("en")
    }

    Scenario("A user wants to complete a Cancellation Import journey (reason input) [journey=Import, epu=023, entryNo=023456A, requestType=Cancellation, route=Route 1, ALVS=Yes, transport=Air, email=ab@abc.com, file=testPdf.pdf]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 023 and 023456A")
        whenTheUserEntersEntryDetailsXAndX("023", "023456A")

      And("the user enters today's date for entryDate")
      andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      When("the user is on the Request type page, selects Cancellation and continues")
        whenTheUserIsOnTheRequestTypePageSelectsXAndContinues("Cancellation")

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      When("the user is on the Route type page, selects Route 1 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 1")

      Then("the user will be on the Import Reason page")
        thenTheUserWillBeOnTheXReasonPage("Import")

      When("the user enters valid characters in the reason field and continues")
        whenTheUserEntersXCharactersInTheReasonFieldAndContinues("valid")

      Then("the user will be on the Import YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Import")

      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      When("the user is on the ALVS page, selects Yes and continues")
        whenTheUserIsOnTheALVSPageSelectsXAndContinues("Yes")

      When("the user is on the Transport type page, selects Air and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Air")

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      And("the user enters an email address ab@abc.com")
        andTheUserEntersAnEmailAddressX("ab@abc.com")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user will only see inset text for Request type N/A")
        andTheUserWillOnlySeeInsetTextForRequestTypeX("N/A")

      And("the user clicks the button to upload file \"1\" and selects \"testPdf.pdf\"")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testPdf.pdf")

      When("the user clicks continue when files have finished uploading")
        andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")

    }
  }
}
