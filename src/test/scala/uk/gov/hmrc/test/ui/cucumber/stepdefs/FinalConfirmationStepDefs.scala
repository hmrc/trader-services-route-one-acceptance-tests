/*
 * Copyright 2023 HM Revenue & Customs
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

class FinalConfirmationStepDefs
    extends FinalConfirmationPage
    with BasePage
    with LandingPage
    with AmendPages
    with ScalaDsl
    with EN {

  Given("""^the user will be on the (.*) confirmation page""") { (journey: String) =>
    journey match {
      case "New" =>
        confirmUrl(urlConfirmation)

      case "Amend" =>
        confirmUrl(urlAmendConfirm)
    }

    assertIsVisible(saveHtmlIcon)
  }

  Then("""^outputs the case reference number""") { () => // TODO check way around this
    caseRefNo.getText
  }

  When(
    """^the user clicks the button to submit another case on the confirmation page they will go back to the start"""
  ) { () =>
    clickSendAnother()
    confirmUrl(traderServicesUrl)
  }

  When("""^the user clicks the link to add documents they will be redirected to amend journey""") { () =>
    clickLinkToAmend()
    confirmUrl(urlCaseRef)
  }

  Then("""^the user should see (.*) SLA""") { (sla: String) =>
    sla match {
      // Air - both, Roro - both, Maritime - Export
      case "2 Hour" => checkSecondaryContent(sla2hrFormatted + " today.", sla2hrAddMin + " today", slaPara)

      case "Maritime-Import" =>
        if (between8amAnd3pm) checkSecondaryContent(sla3hrFormatted + " today.", sla3hrAddMin + " today", slaPara)
        if (between3pmAndMidnight) assertElementTextContains("08:00 tomorrow.", slaPara)
        if (betweenMidnightAnd8am) assertElementTextContains("08:00 today.", slaPara)

      // Route Hold (No SLA)
      case "Hold"            => assertElementTextContains(holdSLA, slaPara)
    }
  }
}
