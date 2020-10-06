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

  Given("""^the user is on the YesNo Priority Page and selects (.*)""") { (YesNo: String) =>
    confirmUrl(urlYesNoPriority)
    verifyHeading(headingYesNoPriority)

    YesNo match {
      case "Yes" => clickByCSS("#hasPriorityGoods")
      case "No" => clickByCSS("#hasPriorityGoods-2")
      case "None" =>
    }

    clickContinue()
  }


    When("""^the user is on the Priority Options Page and selects (.*)""") { (RequestType: String) =>
      confirmUrl(urlPriority)
      verifyHeading(headingPriority)

    RequestType match {
      case "ClassA" => clickByCSS("#priorityGoods")
      case "Explosives" => clickByCSS("#priorityGoods-2")
      case "Art" => clickByCSS("#priorityGoods-3")
      case "HumanRemains" => clickByCSS("#priorityGoods-4")
      case "LiveAnimals" => clickByCSS("#priorityGoods-5")
      case "NoOption" =>
    }
        clickContinue()
  }
}

