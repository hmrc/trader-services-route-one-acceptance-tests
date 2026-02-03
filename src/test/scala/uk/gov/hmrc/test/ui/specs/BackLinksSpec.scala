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

import uk.gov.hmrc.test.ui.specsteps.AmendStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.BaseStepDefSteps._
import uk.gov.hmrc.test.ui.specsteps.ContactDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.EntryDetailsStepDefsSteps.{thenTheUserWillBeOnTheEntryDetailsPage, whenTheUserEntersEntryDetailsXAndX}
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps.thenTheUserWillBeOnTheMultiFileUploadPagesForX
class BackLinksSpec extends BaseSpec {

  Feature("Back Links") {

    Scenario("Import: A user goes back through the journey and their answers should be saved [journey=Import, epu=001, entryNo=000000Z, requestType=New, route=Route 1, priority=Live animals, transport=Air, email=abc@test.com]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 001 and 000000Z")
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

      When("the user is on the Route type page, selects Route 1 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 1")

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

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      And("the user enters an email address abc@test.com")
      andTheUserEntersAnEmailAddressX("abc@test.com")

      When("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      And("the details entered for name, email and phone number should be pre-filled with \"\", abc@test.com & \"\"")
        thenTheDetailsEnteredForNameEmailAndPhoneNumberShouldBePreFilledWithX_Y_And_Z("", "abc@test.com", "")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import Transport type page")
        thenTheUserWillBeOnTheXTransportTypePage("Import")

      And("the last selected option for Transport type should be pre filled with Air")
        thenTheLastSelectedOptionForTransportTypeShouldBePreFilledWithX("Air")  // auto-chosen (score=1.00, QuestionPagesStepDefsSteps.scala)

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the ALVS page")
        thenTheUserWillBeOnTheALVSPage()

      And("the last selected option for ALVS should be pre filled with Yes")
        thenTheLastSelectedOptionForALVSShouldBePreFilledWithX("Yes")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import Priority Goods page")
        thenTheUserWillBeOnTheXPriorityGoodsPage("Import")

      And("the last selected option for Priority goods should be pre filled with Live animals")
        thenTheLastSelectedOptionForPriorityGoodsShouldBePreFilledWithX("Live animals")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Import")

      And("the last selected option for YN Priority should be pre filled with Yes")
        thenTheLastSelectedOptionForYNPriorityShouldBePreFilledWithX("Yes")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      And("the last selected option for Route should be pre filled with Route 1")
        thenTheLastSelectedOptionForRouteShouldBePreFilledWithX("Route 1")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      And("the last selected option for Import Request should be pre filled with New")
        thenTheLastSelectedOptionForXRequestShouldBePreFilledWithX("Import", "New")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 001 and 000000Z")
      whenTheUserEntersEntryDetailsXAndX("001", "000000Z")

      And("the details entered for entryDate should be pre filled with today's date")
      thenTheDetailsEnteredForXShouldBePreFilledWithTodaysDate("entryDate")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the start page for trader services")
        thenTheUserWillBeOnTheStartPageForTraderServices()

      And("the last selected option for journey type should be pre filled with New")
        thenTheLastSelectedOptionForJourneyTypeShouldBePreFilledWithX("New")

      When("the user clicks the service-name link they will be redirected to the appropriate page")
        whenTheUserClicksTheXLinkTheyWillBeRedirectedToTheAppropriatePage("service-name")

    }

    Scenario(": Amend back links [journey=Amend, caseRef=PC12010081330XGBNZJO04, amendType=writeAndUpload, message=Hello Caseworker]") {
      Given("the user is on the start page for trader services, selects Amend and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("Amend")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user enters valid characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("valid")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user is on the Amendment type page, selects writeAndUpload and continues")
        whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues("writeAndUpload")

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      When("the user enters Hello Caseworker characters in the write response field and continues")
        thenTheUserEntersXCharactersInTheWriteResponseFieldAndContinues("Hello Caseworker")

      Then("the user will be on the multi-file upload pages for Amend")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("Amend")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      And("the details in the text box should be pre-filled with Hello Caseworker")
        thenTheDetailsInTheTextBoxShouldBePreFilledWithX("Hello Caseworker")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      And("the last selected option for type of amendment should be writeAndUpload")
        thenTheLastSelectedOptionForTypeOfAmendmentShouldBeX("writeAndUpload")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      And("the details in the case ref field should be pre-filled with PC12010081330XGBNZJO04")
        thenTheDetailsInTheCaseRefFieldShouldBePreFilledWithX("PC12010081330XGBNZJO04")

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the start page for trader services")
        thenTheUserWillBeOnTheStartPageForTraderServices()

      And("the last selected option for journey type should be pre filled with Amend")
        thenTheLastSelectedOptionForJourneyTypeShouldBePreFilledWithX("Amend")

      Then("the user clicks the service-name link they will be redirected to the appropriate page")
        whenTheUserClicksTheXLinkTheyWillBeRedirectedToTheAppropriatePage("service-name")

      And("the last selected option for journey type should be pre filled with Nothing")
        thenTheLastSelectedOptionForJourneyTypeShouldBePreFilledWithX("Nothing")
    }
  }
}
