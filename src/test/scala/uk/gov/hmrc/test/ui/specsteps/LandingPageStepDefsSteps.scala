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

package uk.gov.hmrc.test.ui.specsteps

import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.specpage.LandingPage

object LandingPageStepDefsSteps extends LandingPage {

  // ^the user will be on the start page for trader services$
  def thenTheUserWillBeOnTheStartPageForTraderServices(): Unit = {
    confirmUrl(traderServicesUrl)
  }

  // ^the user is on the start page for trader services, selects (.*) and continues$
  def givenTheUserIsOnTheStartPageForTraderServicesSelectsXAndContinues(journey: String): Unit = {
    navigateTo(traderServicesUrl)
        confirmUrl(traderServicesUrl)

        journey match {
          case "New"   => Driver.instance.findElement(By.cssSelector("#newOrExistingCase")).click()
          case "Amend" => Driver.instance.findElement(By.cssSelector("#newOrExistingCase-2")).click()
        }
        clickContinue()
  }

  // ^the last selected option for journey type should be pre filled with (.*)$
  def thenTheLastSelectedOptionForJourneyTypeShouldBePreFilledWithX(journey: String): Unit = {
    journey match {
          case "New"     => optionSelected("#newOrExistingCase")
          case "Amend"   => optionSelected("#newOrExistingCase-2")
          case "Nothing" =>
            optionNotSelected("#newOrExistingCase")
            optionNotSelected("#newOrExistingCase-2")
        }
  }

}
