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
import uk.gov.hmrc.test.ui.pages.{BasePage, DeclarationNumPage, FinalConfirmationPage}

class FinalConfirmationStepDefs extends FinalConfirmationPage with BasePage with DeclarationNumPage with ScalaDsl with EN {


  Given("""^the user is on the final confirmation page""") { () =>
    confirmUrl(urlConfirmation)
    verifyHeading(headingConfirmation)
//    assertElementText("Save your case reference number", findElementByCss(""))
//    assertElementText("You might need it if you contact us with any queries", findElementByCss(""))
//
//    assertElementText("Next steps", findElementByCss(""))
//    assertElementText("You will hear from us soon via CHIEF or your declaration software.", findElementByCss(""))
  }

  Then("""^the user should see guidance links on the page""") {() =>
  }

  Then("""^the user should see a case reference number"""){() =>
    assertElementText("TBC", findElementByCss(".govuk-panel__body > strong:nth-child(2)"))
  }
  //TBC...

  When("""^the user clicks to submit documents for a new case they will be back on dec details page"""){() =>
    clickContinue()
    confirmUrl(urlDecDetails)
    verifyHeading(headingDecDetails)
  }
}