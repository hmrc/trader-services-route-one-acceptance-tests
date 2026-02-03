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
import uk.gov.hmrc.test.ui.specsteps.ContactDetailsStepDefsSteps.thenTheUserWillBeOnTheXContactDetailsPage
import uk.gov.hmrc.test.ui.specsteps.EntryDetailsStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.LandingPageStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.MissingInformationStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.NewCYAStepDefsSteps.thenTheUserWillBeOnTheXCYAPage
import uk.gov.hmrc.test.ui.specsteps.PriorityStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.QuestionPagesStepDefsSteps._
import uk.gov.hmrc.test.ui.specsteps.UploadMultiStepDefsSteps.thenTheUserWillBeOnTheMultiFileUploadPagesForX

class JourneyJumpingSpec extends BaseSpec {

  Feature("User can navigate to pages within each journey after inputting entry details") {

    Scenario("A user tries to jump ahead from entry details in an export journey to the next page") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/request-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/request-type")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/request-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/request-type")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/route-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/route-type")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/has-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/export/has-priority-goods")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/which-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/export/which-priority-goods")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/import/automatic-licence-verification")
        whenTheUserNavigatesToTheFollowingX("/new/import/automatic-licence-verification")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/transport-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/transport-type")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/transport-information")
        whenTheUserNavigatesToTheFollowingX("/new/export/transport-information")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/transport-information-required")
        whenTheUserNavigatesToTheFollowingX("/new/export/transport-information-required")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/contact-information")
        whenTheUserNavigatesToTheFollowingX("/new/export/contact-information")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/upload-files")
        whenTheUserNavigatesToTheFollowingX("/new/upload-files")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/file-upload")
        whenTheUserNavigatesToTheFollowingX("/new/file-upload")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/file-uploaded")
        whenTheUserNavigatesToTheFollowingX("/new/file-uploaded")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/export/check-your-answers")
        whenTheUserNavigatesToTheFollowingX("/new/export/check-your-answers")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user navigates to the following /new/confirmation")
        whenTheUserNavigatesToTheFollowingX("/new/confirmation")

      Then("the user will be on the start page for trader services")
        thenTheUserWillBeOnTheStartPageForTraderServices()
    }

    Scenario("A user tries to jump ahead to the next pages after inputting <journey> entry details [journey=Import, epu=randomEPU, entryNo=importEN, journeyUrl=import]") {
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

      Then("the user will be on the Import Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Import")

      And("the user navigates to the following /new/import/route-type")
        whenTheUserNavigatesToTheFollowingX("/new/import/route-type")

      Then("the user will be on the Import Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Import")

      And("the user navigates to the following /new/import/has-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/import/has-priority-goods")  // auto-chosen (score=0.90, BaseStepDefSteps.scala)

      Then("the user will be on the Import YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Import")

      And("the user navigates to the following /new/import/which-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/import/which-priority-goods")

      Then("the user will be on the Import Priority Goods page and navigates to ALVS in import journey")
        thenTheUserWillBeOnTheXPriorityGoodsPageAndNavigatesToALVSInImportJourney("Import")

      And("the user navigates to the following /new/import/transport-type")
        whenTheUserNavigatesToTheFollowingX("/new/import/transport-type")

      Then("the user will be on the Import Transport type page")
        thenTheUserWillBeOnTheXTransportTypePage("Import")

      And("the user navigates to the following /new/import/transport-information")
        whenTheUserNavigatesToTheFollowingX("/new/import/transport-information")

      Then("the user will be on the following url /new/import/transport-information")
        thenTheUserWillBeOnTheFollowingUrlX("/new/import/transport-information")

      And("the user navigates to the following /new/import/contact-information")
        whenTheUserNavigatesToTheFollowingX("/new/import/contact-information")

      Then("the user will be on the Import Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Import")

      When("the user navigates to the following /new/upload-files")
        whenTheUserNavigatesToTheFollowingX("/new/upload-files")

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user navigates to the following /new/import/check-your-answers")
        whenTheUserNavigatesToTheFollowingX("/new/import/check-your-answers")

      Then("the user will be on the Import CYA page")
        thenTheUserWillBeOnTheXCYAPage("Import")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Import Missing information page")
        thenTheUserWillBeOnTheXMissingInformationPage("Import")

      When("the user clicks the button on the Missing information page they will return to entry details")
        whenTheUserClicksTheButtonOnTheMissingInformationPageTheyWillReturnToEntryDetails()

      When("the user navigates to the following /new/confirmation")
        whenTheUserNavigatesToTheFollowingX("/new/confirmation")

      Then("the user will be on the start page for trader services")
        thenTheUserWillBeOnTheStartPageForTraderServices()
    }

    Scenario("A user tries to jump ahead to the next pages after inputting <journey> entry details [journey=Export, epu=randomEPU, entryNo=exportEN, journeyUrl=export]") {
      Given("the user is on the start page for trader services, selects New and continues")
        givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues("New")

      Then("the user will be on the entry details page")
        thenTheUserWillBeOnTheEntryDetailsPage()

      When("the user enters entry details randomEPU and exportEN")
        whenTheUserEntersEntryDetailsXAndX("randomEPU", "exportEN")

      And("the user enters today's date for entryDate")
      andTheUserEntersTodaysDateForX("entryDate")

      And("the user clicks continue")
      andTheUserClicksContinue()

      Then("the user will be on the Export Request type page")
        thenTheUserWillBeOnTheXRequestTypePage("Export")

      And("the user navigates to the following /new/export/route-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/route-type")

      Then("the user will be on the Export Route type page")
        thenTheUserWillBeOnTheXRouteTypePage("Export")

      And("the user navigates to the following /new/export/has-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/export/has-priority-goods")

      Then("the user will be on the Export YN Priority page")
        thenTheUserWillBeOnTheXYNPriorityPage("Export")

      And("the user navigates to the following /new/export/which-priority-goods")
        whenTheUserNavigatesToTheFollowingX("/new/export/which-priority-goods")

      Then("the user will be on the Export Priority Goods page and navigates to ALVS in import journey")
      thenTheUserWillBeOnTheXPriorityGoodsPageAndNavigatesToALVSInImportJourney("Export")

      And("the user navigates to the following /new/export/transport-type")
        whenTheUserNavigatesToTheFollowingX("/new/export/transport-type")

      Then("the user will be on the Export Transport type page")
        thenTheUserWillBeOnTheXTransportTypePage("Export")

      And("the user navigates to the following /new/export/transport-information")
        whenTheUserNavigatesToTheFollowingX("/new/export/transport-information")

      Then("the user will be on the following url /new/export/transport-information")
        thenTheUserWillBeOnTheFollowingUrlX("/new/export/transport-information")

      And("the user navigates to the following /new/export/contact-information")
        whenTheUserNavigatesToTheFollowingX("/new/export/contact-information")

      Then("the user will be on the Export Contact details page")
        thenTheUserWillBeOnTheXContactDetailsPage("Export")

      When("the user navigates to the following /new/upload-files")
        whenTheUserNavigatesToTheFollowingX("/new/upload-files")

      Then("the user will be on the multi-file upload pages for New")
        thenTheUserWillBeOnTheMultiFileUploadPagesForX("New")

      And("the user navigates to the following /new/export/check-your-answers")
        whenTheUserNavigatesToTheFollowingX("/new/export/check-your-answers")

      Then("the user will be on the Export CYA page")
        thenTheUserWillBeOnTheXCYAPage("Export")

      When("the user clicks submit on the CYA page")
        andTheUserClicksSubmitOnTheCYAPage()

      Then("the user will be on the Export Missing information page")
        thenTheUserWillBeOnTheXMissingInformationPage("Export")

      When("the user clicks the button on the Missing information page they will return to entry details")
        whenTheUserClicksTheButtonOnTheMissingInformationPageTheyWillReturnToEntryDetails()

      When("the user navigates to the following /new/confirmation")
        whenTheUserNavigatesToTheFollowingX("/new/confirmation")

      Then("the user will be on the start page for trader services")
        thenTheUserWillBeOnTheStartPageForTraderServices()
    }
  }
}
