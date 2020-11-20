/*
 * Copyright 2020 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.{BasePage, LandingPage}


class LandingPageStepDefs extends LandingPage with BasePage with ScalaDsl with EN {

  Given("""^the user navigates to the landing page for trader services$""") { () =>
    navigateTo(traderServicesUrl)
  }

  Then("""^the user is on the start page for trader services$""") { () =>
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  Given("""^the user is on the start page for trader services and selects (.*)$""") { (journey:String) =>
    navigateTo(traderServicesUrl)
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)

    journey match {
    case "New" => selectNew
    case "Amend" => selectAmend
  }
    clickContinue()
  }

  Then("""^the last selected option for journey type should be pre filled with (.*)$""") { (request:String) =>

    request match {
      case "New" => optionSelected("#newOrExistingCase")
      case "Amend" => optionSelected("#newOrExistingCase-2")
      case _ => optionNotSelected("#newOrExistingCase")
                optionNotSelected("#newOrExistingCase-2")
    }
  }
}

