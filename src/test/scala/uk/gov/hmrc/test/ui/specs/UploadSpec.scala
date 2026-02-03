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
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps.thenTheUserWillBeOnTheXCYAPage
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps.whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadStepDefsSteps._

class UploadSpec extends BaseSpec {

  Feature("A user wants to upload documents (Single file)") {

    Scenario("A user wants upload some documents [epu=randomEPU, entryNo=importEN, requestType=New, route=Route 1, transport=RoadRoRoRail, email=a@test.com]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details randomEPU and importEN")
        whenTheUserEntersEntryDetailsXAndX("randomEPU", "importEN")

      And("the user enters today's date for entryDate")
        andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user is on the Request type page, selects New and continues")
        whenTheUserIsOnTheRequestTypePageSelectsXAndContinues("New")

      Then("the user is on the Route type page, selects Route 1 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 1")

      Then("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      Then("the user is on the ALVS page, selects Yes and continues")
        whenTheUserIsOnTheALVSPageSelectsXAndContinues("Yes")

      When("the user is on the Transport type page, selects RoadRoRoRail and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("RoadRoRoRail")

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      Then("the user enters an email address a@test.com")
        andTheUserEntersAnEmailAddressX("a@test.com")

      And("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user navigates to the single file New upload page")
        thenTheUserNavigatesToTheSingleFileXUploadPage("New")

      When("the user clicks the button to upload and selects the pdf file")
      thenTheUserClicksTheButtonToUploadAndSelectsTheXFile("pdf")

      Then("the user should be on the new file upload confirmation page")
        thenTheUserShouldBeOnTheXFileUploadConfirmationPage("new")

      Then("the user should see their first uploaded doc on upload review page")
        thenTheUserShouldSeeTheirFirstUploadedDocOnUploadReviewPage()

      Then("the user selects Yes to uploading another file")
        thenTheUserSelectsXToUploadingAnotherFile("Yes")

      Then("the user will be on the Another upload page")
        thenTheUserWillBeOnTheXUploadPage("Another")

      When("the user clicks the button to upload and selects the png file")
      thenTheUserClicksTheButtonToUploadAndSelectsTheXFile("png")

      Then("the user should be on the new file upload confirmation page")
        thenTheUserShouldBeOnTheXFileUploadConfirmationPage("new")

      Then("the user selects Yes to uploading another file")
        thenTheUserSelectsXToUploadingAnotherFile("Yes")

      Then("the user will be on the Another upload page")
        thenTheUserWillBeOnTheXUploadPage("Another")

      When("the user clicks the button to upload and selects the jpeg file")
      thenTheUserClicksTheButtonToUploadAndSelectsTheXFile("jpeg")

      Then("the user should be on the new file upload confirmation page")
        thenTheUserShouldBeOnTheXFileUploadConfirmationPage("new")

      Then("the user clicks the button to remove a document")
        whenTheUserClicksTheButtonToRemoveADocument()

      Then("the user should be on the new file upload confirmation page")
        thenTheUserShouldBeOnTheXFileUploadConfirmationPage("new")

      Then("the user selects Yes to uploading another file")
        thenTheUserSelectsXToUploadingAnotherFile("Yes")

      Then("the user will be on the Another upload page")
        thenTheUserWillBeOnTheXUploadPage("Another")

      When("the user clicks the button to upload and selects the doc file")
      thenTheUserClicksTheButtonToUploadAndSelectsTheXFile("doc")

      Then("the user should be on the new file upload confirmation page")
        thenTheUserShouldBeOnTheXFileUploadConfirmationPage("new")

      Then("the user selects No to uploading another file")
        thenTheUserSelectsXToUploadingAnotherFile("No")

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      And("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the New confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("New")

    }
  }
}
