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
import uk.gov.hmrc.test.ui.pages.{ALVSPage, BasePage}


class AlvsStepDef extends ALVSPage with BasePage with ScalaDsl with EN {


  When ("""^the user navigates to the ALVS page""") { () =>
    navigateTo(urlALVS)
  }

  Then("""^the user is on the ALVS Page$""") { () =>
    confirmUrl(urlALVS)
    verifyHeading(headingALVS)
  }

  When("""^the user is on the ALVS Page and selects (.*)$""") { (YesNo: String) =>
    confirmUrl(urlALVS)
    verifyHeading(headingALVS)

    YesNo match {
      case "Yes" => clickByCSS("#hasALVS")
      case "No" => clickByCSS("#hasALVS-2")
      case "NoOption" =>
    }

    clickContinue()
  }

  Then("""^the last selected option for ALVS should be pre filled with (.*)$""") { (ALVS:String) =>

    ALVS match {
      case "Yes" => optionSelected("#hasALVS")
      case "No" => optionSelected("#hasALVS-2")
    }
  }
}