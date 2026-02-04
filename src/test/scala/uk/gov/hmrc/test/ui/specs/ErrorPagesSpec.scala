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

import uk.gov.hmrc.test.ui.specsteps.AmendCYAStepDefsSteps.thenTheUserWillBeOnTheAmendReviewPage
import uk.gov.hmrc.test.ui.specsteps.AmendStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.BaseStepDefSteps._
import uk.gov.hmrc.test.ui.specsteps.ContactDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.EntryDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.ErrorStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.FinalConfirmationStepDefsSteps.givenTheUserWillBeOnTheXConfirmationPage
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps.thenTheUserWillBeOnTheXCYAPage
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps._
class ErrorPagesSpec extends BaseSpec {

  Feature("Error pages") {

    Scenario("A user enters a failed request (Stub EPU: 666) [journey=Export, epu=666, entryNo=X23456A, requestType=New, route=Route 1, transport=Air, email=a@a.com, file=testOdt.odt]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 666 and X23456A")
      whenTheUserEntersEntryDetailsXAndX("666", "X23456A")

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

      When("the user is on the Route type page, selects Route 1 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 1")

      Then("the user will be on the Export YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Export")

      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      Then("the user will be on the Export Transport type page")
        thenTheUserWillBeOnTheXTransportTypePage("Export")

      When("the user is on the Transport type page, selects Air and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Air")

      Then("the user will be on the Export Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Export")

      And("the user enters an email address a@a.com")
        andTheUserEntersAnEmailAddressX("a@a.com")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user clicks the button to upload file \"1\" and selects \"testOdt.odt\"")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testOdt.odt")

      And("the user clicks continue when files have finished uploading")
        andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Export CYA page")
        thenTheUserWillBeOnTheXCYAPage("Export")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the error page for internal server error")
        thenTheUserWillBeOnTheErrorPageForInternalServerError()
    }

    Scenario("A user enters a duplicate case (Stub EPU: 667) [journey=Export, epu=667, entryNo=A23456A, requestType=New, route=Route 2, transport=Air, email=a@a.com, file=testOds.ods]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details 667 and A23456A")
        whenTheUserEntersEntryDetailsXAndX("667", "A23456A")

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

      When("the user is on the Route type page, selects Route 2 and continues")
        whenTheUserIsOnTheRouteTypePageSelectsXAndContinues("Route 2")

      Then("the user will be on the Export YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Export")

      When("the user is on the YesNo Priority page, selects No and continues")
        whenTheUserIsOnTheYesNoPriorityPageSelectsXAndContinues("No")

      Then("the user will be on the Export Transport type page")
        thenTheUserWillBeOnTheXTransportTypePage("Export")

      When("the user is on the Transport type page, selects Air and continues")
        whenTheUserIsOnTheTransportTypePageSelectsXAndContinues("Air")

      Then("the user will be on the Export Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Export")

      And("the user enters an email address a@a.com")
        andTheUserEntersAnEmailAddressX("a@a.com")

      When("the user clicks continue")
        andTheUserClicksContinue()

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user clicks the button to upload file \"1\" and selects \"testOds.ods\"")
        thenTheUserClicksTheButtonToUploadFileXAndSelectsX("1", "testOds.ods")

      When("the user clicks continue when files have finished uploading")
        andTheUserClicksContinueWhenFilesHaveFinishedUploading()

      Then("the user will be on the Export CYA page")
        thenTheUserWillBeOnTheXCYAPage("Export")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the duplicate case error page and see their case reference number")
        whenTheUserWillBeOnTheDuplicateCaseErrorPageAndSeeTheirCaseReferenceNumber()
    }

    Scenario("A user enters an invalid case reference number [journey=Amend, caseNo=PC12010081330XGBNZJ666, amendType=writeOnly, message=Test Text]") {
      Given("the user is on the start page for trader services, selects Amend and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("Amend")

      Then("the user will be on the Case Reference number page")
        thenTheUserWillBeOnTheCaseReferenceNumberPage()

      When("the user enters PC12010081330XGBNZJ666 characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("PC12010081330XGBNZJ666")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user is on the Amendment type page, selects writeOnly and continues")
        whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues("writeOnly")

      Then("the user will be on the write response page")
        thenTheUserWillBeOnTheWriteResponsePage()

      When("the user enters Test Text characters in the write response field and continues")
        thenTheUserEntersXCharactersInTheWriteResponseFieldAndContinues("Test Text")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the error page for an amend journey internal server error")
        thenTheUserWillBeOnTheErrorPageForAnAmendJourneyInternalServerError()

      When("the user clicks the link to re enter a case ref number they will be on the case ref page")
        whenTheUserClicksTheLinkToReEnterACaseRefNumberTheyWillBeOnTheCaseRefPage()

      When("the user enters valid characters for case reference number and continues")
        thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues("valid")

      Then("the user will be on the Amendment type page")
        thenTheUserWillBeOnTheAmendmentTypePage()

      When("the user is on the Amendment type page, selects writeOnly and continues")
        whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues("writeOnly")

      Then("the user will be on the Amend review page")
        thenTheUserWillBeOnTheAmendReviewPage()

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Amend confirmation page")
        givenTheUserWillBeOnTheXConfirmationPage("Amend")
    }
  }
}
