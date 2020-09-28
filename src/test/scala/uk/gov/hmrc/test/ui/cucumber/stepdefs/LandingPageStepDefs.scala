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

  Given("""^the user is on the landing page for trader services$""") { () =>
    navigateTo(traderServicesUrl)
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  When("""^the user clicks the link to enter the route1 journey$""") {() =>
   findRouteOneLink.click()
  }
}
