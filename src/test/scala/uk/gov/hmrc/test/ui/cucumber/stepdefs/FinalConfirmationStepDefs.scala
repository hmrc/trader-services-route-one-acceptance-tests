/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import play.twirl.api.TemplateMagic.anyToDefault
import uk.gov.hmrc.test.ui.pages.{AmendPages, BasePage, FinalConfirmationPage, LandingPage}

class FinalConfirmationStepDefs extends FinalConfirmationPage with BasePage
  with LandingPage with AmendPages with ScalaDsl with EN {


  Given("""^the user is on the (.*) confirmation page""") { (journey: String) =>

    journey match {
      case "New" =>
        confirmUrl(urlConfirmation)
        verifyHeading(headingConfirmation)

      case "Amend" =>
        confirmUrl(urlAmendConfirm)
        verifyHeading(headingAmendConfirm)
    }

    assertElementText(userCaseRef, caseRefNo)
    assertElementText("Save your case reference number", subheading1)
  }

  Then("""^the user should see guidance links on the page""") { () =>
  }

  //  def caseRefOutput = caseRefNo.getText.copy()

  Then("""^the user copies the case reference number""") { () =>
    val caseRefOutput = caseRefNo.getText.copy()
    print(caseRefOutput)
  }

  Then("""^the user pastes the case reference number and continues""") { () =>
    writeById(caseRefNo, "")
    clickContinueCaseRef()
  }

  When("""^the user clicks the send docs link on the (.*) confirmation page they will go back to the start""") { (journey: String) =>

    journey match {
      case "NewHold" => clickFinalContinueNewNoSLA()
      case "NewSLA" => clickFinalContinueNewSLA()
      case "Amend" => clickFinalContinueAmend()
    }
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  When("""^the user clicks the link to add documents they will be redirected to amend journey""") { () =>
    clickLinkToAmend
    confirmUrl(urlCaseRef)
    verifyHeading(caseRefHeading)
  }

  Then("""^the user should see (.*) SLA""") { (sla: String) =>

    sla match {
        //Air - both, Roro - both, Maritime - Export
    case "2 Hour" => assertElementTextContains("Your document checks should be completed by " + localTimePlus2 + " today.", slaPara)

      //Maritime - Import
    case "3 Hour" => assertElementTextContains("Your document checks should be completed by " + localTimePlus3 + " today.", slaPara)

      //Maritime - Import After 1500 but before midnight
    case "PreMidnight" => assertElementTextContains("Your document checks should be completed by 08:00 tomorrow.", slaPara)

    //Maritime - Import After 1500 (after midnight but before 0500)
    case "PostMidnight" => assertElementTextContains("Your document checks should be completed by 08:00 today.", slaPara)

      //Route Hold (No SLA)
    case "No" =>  assertElementTextContains(holdSLA, slaParaHold)
  }
}
}

