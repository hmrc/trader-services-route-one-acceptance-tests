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
import uk.gov.hmrc.test.ui.specsteps.FinalConfirmationStepDefsSteps.givenTheUserWillBeOnTheXConfirmationPage
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps.givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.TransportStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._

class ChangeLinksNewSpec extends BaseSpec {

  override def beforeEach(): Unit = {
    super.beforeEach()

    Given("the user is on the start page for trader services, selects New and continues")
      givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")
    Then("the user will be on the entry details page")
      thenTheUserWillBeOnTheEntryDetailsPage()
    And("the user enters entry details \"001\" and \"000000Z\"")
      whenTheUserEntersEntryDetailsXAndX("001", "000000Z")
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
    When("the user is on the Route type page, selects Hold and continues")
      whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Hold")
    Then("the user will be on the Import YN Priority page")
      thenTheUserWillBeOnTheXYNPriorityPage("Import")
    When("the user is on the YesNo Priority page, selects Yes and continues")
      whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("Yes")
    Then("the user will be on the Import Priority Goods page")
      thenTheUserWillBeOnTheXPriorityGoodsPage("Import")
    When("the user is on the Priority Goods page, selects Live animals and continues")
      whenTheUserIsOnThePriorityGoodsPageSelectsXAndContinues("Live animals")
    Then("the user will be on the ALVS page")
      thenTheUserWillBeOnTheALVSPage()
    When("the user is on the ALVS page, selects Yes and continues")
      whenTheUserIsOnTheALVSPageSelectsXAndContinues("Yes")
    When("the user is on the Transport type page, selects Air and continues")
      whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Air")
    Then("the user will be on the Import Transport details page")
      thenTheUserWillBeOnTheXTransportDetailsPage("Import")

    And("the user enters \"PlanEx\" for transport name")
      thenTheUserEntersXForTransportName("PlanEx")
    And("the user enters today's date for transportDateArrival")
      andTheUserEntersTodaysDateForX("transportDateArrival")
    And("the user enters a time of Arrival for their transportation \"13\" \"37\"")
      thenTheUserEntersATimeOfXForTheirTransportationXX("Arrival", "13", "37")
    And("the user clicks continue")
      andTheUserClicksContinue()

    Then("the user will be on the Import Contact details page")
      thenTheUserWillBeOnTheXContactDetailsPage("Import")
    And("the user enters an email address abc@test.com")
      andTheUserEntersAnEmailAddressX("abc@test.com")
    And("the user clicks continue")
      andTheUserClicksContinue()
    Then("the user will be on the multi-file upload pages for New")
      thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")
    And("the user clicks the button to upload file \"1\" and selects \"testPdf.pdf\"")
      thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testPdf.pdf")
    And("the user clicks continue when files have finished uploading")
      andTheUserClicksContinueWhenFilesHaveFinishedUploading()
    Then("the user will be on the Import CYA page - mandatory")
      thenTheUserWillBeOnTheXCYAPage("Import")
  }


  Feature("Change Links for a New journey") {

    Scenario("User checks the change links (and changes answer for priority goods) [journey=Import]") {
      When("the user clicks the change link for Documents")
        whenTheUserClicksTheChangeLinkForX("Documents")

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      When("the user clicks MFU continue")
        andTheUserClicksMFUContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for ContactDetails")
        whenTheUserClicksTheChangeLinkForX("ContactDetails")

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for TransportDetails")
        whenTheUserClicksTheChangeLinkForX("TransportDetails")

      Then("the user will be on the Import Transport details page")
        thenTheUserWillBeOnTheXTransportDetailsPage("Import")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for Transport")
        whenTheUserClicksTheChangeLinkForX("Transport")

      Then("the user will be on the Import Transport details page")
        thenTheUserWillBeOnTheXTransportTypePage("Import")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for ALVS")
        whenTheUserClicksTheChangeLinkForX("ALVS")

      Then("the user will be on the ALVS page")
        thenTheUserWillBeOnTheALVSPage()

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for PriorityYN")
        whenTheUserClicksTheChangeLinkForX("PriorityYN")

      Then("the user will be on the Import YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Import")


      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for Route")
        whenTheUserClicksTheChangeLinkForX("Route")

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for Request")
        whenTheUserClicksTheChangeLinkForX("Request")

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      Then("the user clicks the change link for Entry")
        whenTheUserClicksTheChangeLinkForX("Entry")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")

    }

    Scenario("User checks the change links [journey=Import]") {
      When("the user clicks the change link for Documents")
        whenTheUserClicksTheChangeLinkForX("Documents")

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user navigates to the following /new/import/check-your-answers")
        whenTheUserNavigatesToTheFollowingX("/new/import/check-your-answers")

      When("the user clicks the change link for ContactDetails")
        whenTheUserClicksTheChangeLinkForX("ContactDetails")

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for TransportDetails")
        whenTheUserClicksTheChangeLinkForX("TransportDetails")

      Then("the user will be on the Import Transport details page")
        thenTheUserWillBeOnTheXTransportDetailsPage("Import")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks the change link for Transport")
        whenTheUserClicksTheChangeLinkForX("Transport")

      Then("the user will be on the Import Transport page")
      thenTheUserWillBeOnTheXTransportTypePage("Import")

      When("the user clicks back")
      andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
      thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for ALVS")
        whenTheUserClicksTheChangeLinkForX("ALVS")

      Then("the user will be on the ALVS page")
        thenTheUserWillBeOnTheALVSPage()

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
      thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for PriorityYN")
        whenTheUserClicksTheChangeLinkForX("PriorityYN")

      Then("the user will be on the Import YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Import")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")


      When("the user clicks the change link for Route")
        whenTheUserClicksTheChangeLinkForX("Route")

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks the change link for Request")
        whenTheUserClicksTheChangeLinkForX("Request")

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      Then("the user clicks the change link for Entry")
        whenTheUserClicksTheChangeLinkForX("Entry")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")
    }
  }
}
