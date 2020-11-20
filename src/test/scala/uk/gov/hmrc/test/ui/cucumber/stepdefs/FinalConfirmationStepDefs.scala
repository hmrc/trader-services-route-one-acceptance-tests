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
import uk.gov.hmrc.test.ui.pages.{AmendPage, BasePage, DeclarationNumPage, FinalConfirmationPage, LandingPage}

class FinalConfirmationStepDefs extends FinalConfirmationPage with BasePage
  with LandingPage with AmendPage with ScalaDsl with EN {


  Given("""^the user is on the final confirmation page""") { () =>
    confirmUrl(urlConfirmation)
    verifyHeading(headingConfirmation)
    assertElementText("Save your case reference number", subheading1)
    assertElementText("You will have to provide your case reference number if:", content1)
  }

  Then("""^the user should see guidance links on the page""") {() =>
  }

  Then("""^the user should see a case reference number"""){() =>
    assertElementText("330XGBNZJO04", caseRefNo)
  }

  When("""^the user clicks to submit documents they will be back on the start page"""){() =>
    clickContinue()
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  When("""^the user will be on the duplicate case error page"""){() =>
    confirmUrl(urlDuplicate)
    verifyHeading(headingDuplicate)
  }

  When("""^the user clicks the link to add documents they will be redirected to amend journey"""){() =>
    clickLinkToAmend
    confirmUrl(urlCaseRef)
    verifyHeading(caseRefHeading)
  }
}