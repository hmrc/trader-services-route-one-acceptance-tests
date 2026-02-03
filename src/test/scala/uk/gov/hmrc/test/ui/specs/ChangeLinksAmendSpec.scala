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
import uk.gov.hmrc.test.ui.specsteps.BaseStepDefSteps._
import uk.gov.hmrc.test.ui.specsteps.FinalConfirmationStepDefsSteps.givenTheUserWillBeOnTheXConfirmationPage
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps.givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._
class ChangeLinksAmendSpec extends BaseSpec {

  override def beforeEach(): Unit = {
    super.beforeEach()

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
    And("the user clicks the button to upload file \"1\" and selects \"testPptx.pptx\"")
      thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testPptx.pptx")
    And("the user clicks continue when files have finished uploading")
      andTheUserClicksContinueWhenFilesHaveFinishedUploading()
    Then("the user will be on the Amend writeAndUpload review page and should see their responses")
      givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")
  }

  Feature("Back Links & Change Links - Amend") {

    Scenario("Amend: Change links (continue) [journey=Amend, amendType=writeAndUpload]") {
      When("the user clicks the change link on the amend review page for CaseRef")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("CaseRef")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user enters valid characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("valid")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Amendment")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Amendment")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Message")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Message")

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for Amend")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("Amend")

      When("the user clicks MFU continue")
        andTheUserClicksMFUContinue()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Documents")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Documents")

      Then("the user will be on the multi-file upload pages for Amend")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("Amend")

      When("the user clicks MFU continue")
        andTheUserClicksMFUContinue()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Amend confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("Amend")

    }

    Scenario("Amend: Change links (back) [journey=Amend, amendType=writeAndUpload]") {
      When("the user clicks the change link on the amend review page for CaseRef")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("CaseRef")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Amendment")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Amendment")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Message")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Message")

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      When("the user clicks back")
        andTheUserClicksBack()

      Then("the user will be on the Amend writeAndUpload review page and should see their responses")
        givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses("writeAndUpload")

      When("the user clicks the change link on the amend review page for Documents")
        whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX("Documents")

      Then("the user will be on the multi-file upload pages for Amend")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("Amend")

      When("the user navigates to the following /add/check-your-answers")
        whenTheUserNavigatesToTheFollowingX("/add/check-your-answers")

      And("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Amend confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("Amend")

    }
  }
}
