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

    assertElementTextContains("Your customs check submission receipt", receipt)
    //    assertElementTextContains(nowFormatted, findElementByCss(".govuk-panel"))
    isElementVisible(printPdfIcon).shouldBe(true)
    isElementVisible(saveHtmlIcon).shouldBe(true)
  }

  Then("""^the user will see text to (.*)""") { (journey: String) =>
    journey match {
      case "cancel" => assertElementText(cancelPara, fifthElement)
      case "withdraw" => assertElementText(withdrawPara, fifthElement)
      case "give-feedback" => assertElementText(feedback, fifthElement)
    }
  }

  Then("""^output the case reference number""") { () =>
    val caseRefOutput = caseRefNo.getText
    print(caseRefOutput)
  }

  When("""^the user clicks the button to submit another case on the confirmation page they will go back to the start""") { () =>
    clickSendAnother()
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  When("""^the user clicks the link to add documents they will be redirected to amend journey""") { () =>
    clickLinkToAmend()
    confirmUrl(urlCaseRef)
    verifyHeading(caseRefHeading)
  }


  Then("""^the user should see (.*) SLA""") { (sla: String) =>

    sla match {
      //Air - both, Roro - both, Maritime - Export
      case "2 Hour" =>
        assertElementTextContainsEither(
          "Your document checks should be completed by " + sl2hrFormatted + " today.",
          "Your document checks should be completed by " + sl2hrAddMin + " today.",
          slaPara)

      case "Maritime-Import" =>
        if (between8amAnd3pm) assertElementTextContainsEither(
          "Your document checks should be completed by " + sla3hrFormatted + " today.",
          "Your document checks should be completed by " + sla3hrMin + " today.",
          slaPara)
        if (between3pmAndMidnight) assertElementTextContains("Your document checks should be completed by 08:00 tomorrow.", slaPara)
        if (betweenMidnightAnd8am) assertElementTextContains("Your document checks should be completed by 08:00 today.", slaPara)

      //Route Hold (No SLA)
      case "Hold" => assertElementTextContains(holdSLA, slaPara)
    }
  }
}