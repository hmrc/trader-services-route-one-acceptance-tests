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
import uk.gov.hmrc.test.ui.pages.{BasePage, PriorityPages}


class PriorityStepDefs extends PriorityPages with BasePage with ScalaDsl with EN {

  Given("""^the user is one the Priority Page""") { () =>
    confirmUrl(urlYesNoPriority)
    verifyHeading(headingYesNoPriority)

  }

//    When("""^the user is one the Priority Page and selects (.*)""") { (RequestType: String) =>
//      confirmUrl(urlPriority)
//      verifyHeading(headingPriority)
//
//    RequestType match {
//      case "ClassA" => clickByCSS("#goodsPriority")
//      case "Explosives" => clickByCSS("#goodsPriority-2")
//      case "HighValueArt" => clickByCSS("#goodsPriority-3")
//      case "HumanRemains" => clickByCSS("#goodsPriority-4")
//      case "LiveAnimals" => clickByCSS("#goodsPriority-5")
//      case "None" =>
//    }
//    //    clickContinue()
//  }
}

