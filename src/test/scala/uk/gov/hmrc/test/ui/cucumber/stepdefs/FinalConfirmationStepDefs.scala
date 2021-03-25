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

import java.time.LocalTime

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
        isElementVisible("a.action-buttons__button").shouldBe(true)
        isElementVisible(" li.action-buttons__item:nth-child(2) > a:nth-child(1)").shouldBe(true)

      case "Amend" =>
        confirmUrl(urlAmendConfirm)
        verifyHeading(headingAmendConfirm)
    }

    assertElementTextContains("Your customs check submission receipt", receipt)
    isElementVisible(".print-page").shouldBe(true)
  }

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
      case "New" => clickFinalContinueNew()
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

  val threePm = LocalTime.parse("15:00:00.00")
  val midnight = LocalTime.parse("00:00:00.00")
  val eightAm = LocalTime.parse("08:00:00.00")

  val between3pmAndMidnight = nowTime.isAfter(threePm) && nowTime.isBefore(midnight)
  val betweenMidnightAnd8am  = nowTime.isAfter(midnight) && nowTime.isBefore(eightAm)
  val between8amAnd3pm = nowTime.isAfter(eightAm) && nowTime.isBefore(threePm)

  Then("""^the user should see (.*) SLA""") { (sla: String) =>

    sla match {
        //Air - both, Roro - both, Maritime - Export
    case "2 Hour" => assertElementTextContains("Your document checks should be completed by " + sl2hrFormatted + " today.", slaPara)

      //Maritime - Import
    case "Maritime-Import"=>
      if(between8amAnd3pm)assertElementTextContains("Your document checks should be completed by " + sla3hrFormatted + " today.", slaPara)
      if(between3pmAndMidnight)assertElementTextContains("Your document checks should be completed by 08:00 tomorrow.", slaPara)
      if(betweenMidnightAnd8am)assertElementTextContains("Your document checks should be completed by 08:00 today.", slaPara)

      //Route Hold (No SLA)
    case "Hold" =>  assertElementTextContains(holdSLA, slaPara)
  }
}
}

