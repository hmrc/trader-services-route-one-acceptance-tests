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

import uk.gov.hmrc.test.ui.specsteps.AmendCYAStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.AmendStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.BaseStepDefSteps.andTheUserClicksSubmitOnTheCYAPage
import uk.gov.hmrc.test.ui.specsteps.FinalConfirmationStepDefsSteps.givenTheUserWillBeOnTheXConfirmationPage
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._

class JourneysAmendSpec extends BaseSpec {

  Feature("Amend journeys") {

    Scenario("A user wants to add a message to their case (write response only) [journey=Amend, caseNo=valid, amendType=writeOnly, message=Test Text]") {
      Given("the user is on the start page for trader services, selects Amend and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("Amend")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user enters valid characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("valid")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user is on the Amendment type page, selects writeOnly and continues")
        whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues("writeOnly")

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      When("the user enters Test Text characters in the write response field and continues")
        thenTheUserEntersXCharactersInTheWriteResponseFieldAndContinues("Test Text")

      Then("the user will be on the Amend writeOnly review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeOnly")

      And("the user should see the message they entered")
        thenTheUserShouldSeeTheMessageTheyEntered()

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Amend confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("Amend")

    }

    Scenario("A user wants to add another document to a case (upload only) [journey=Amend, caseNo=valid, amendType=uploadOnly, file=testXls.xls]") {
      Given("the user is on the start page for trader services, selects Amend and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("Amend")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user enters valid characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("valid")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user is on the Amendment type page, selects uploadOnly and continues")
        whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues("uploadOnly")

      Then("the user will be on the multi-file upload pages for Amend")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("Amend")


      And("the user clicks the button to upload file \"1\" and selects \"testXls.xls\"")
      thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testXls.xls")

      When("the user clicks continue when files have finished uploading")
      andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Amend uploadOnly review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("uploadOnly")

      And("the user should see the files they uploaded")
        thenTheUserShouldSeeTheFilesTheyUploaded()

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Amend confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("Amend")

    }
  }
}
