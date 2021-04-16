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
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.{BasePage, LandingPage}


class LandingPageStepDefs extends LandingPage with BasePage with ScalaDsl with EN {

  Given("""^the user is on the temp start page and enters the journey they will be on the landing page$""") { () =>
    navigateTo(traderServicesStart)
    confirmUrl(traderServicesStart)
    verifyHeading(startHeading)
    startButton.click()
  }

  Then("""^the user will be on the temporary start page$""") { () =>
    confirmUrl(traderServicesStart)
  }

  When("""^the user navigates to the landing page for trader services$""") { () =>
    navigateTo(traderServicesUrl)
  }

  Then("""^the user will be on the start page for trader services$""") { () =>
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }


  Given("""^the user is on the start page for trader services, selects (.*) and continues$""") { (journey: String) =>
    navigateTo(traderServicesUrl)
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)

    journey match {
      case "New" => driver.findElement(By.cssSelector("#newOrExistingCase")).click()
      case "Amend" => driver.findElement(By.cssSelector("#newOrExistingCase-2")).click()
    }
    clickContinue()
  }

  Then("""^the last selected option for journey type should be pre filled with (.*)$""") { (request: String) =>

    request match {
      case "New" => optionSelected("#newOrExistingCase")
      case "Amend" => optionSelected("#newOrExistingCase-2")
      case "Nothing" =>
        optionNotSelected("#newOrExistingCase")
        optionNotSelected("#newOrExistingCase-2")
    }
  }
}

