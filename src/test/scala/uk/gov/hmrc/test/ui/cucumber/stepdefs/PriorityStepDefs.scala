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
import uk.gov.hmrc.test.ui.pages.{BasePage, PriorityPages}


class PriorityStepDefs extends PriorityPages with BasePage with ScalaDsl with EN {

  When("""^the user navigates to the (.*) YN Priority page""") { (journey: String) =>
    journey match {
      case "Import" => navigateTo(urlImportYNPriority)
      case "Export" => navigateTo(urlExportYNPriority)
    }
  }

  Then("""^the user is on the (.*) YN Priority page""") { (journey: String) =>
    journey match {
      case "Import" =>
        confirmUrl(urlImportYNPriority)
        verifyHeading(headingImportYNPrio)
      case "Export" =>
        confirmUrl(urlExportYNPriority)
        verifyHeading(headingExportYNPrio)
    }
  }

  When("""^the user is on the (.*) YesNo Priority page, selects (.*) and continues""") { (journey: String, YesNo: String) =>

    journey match {
      case "Import" =>
        confirmUrl(urlImportYNPriority)
        verifyHeading(headingImportYNPrio)
      case "Export" =>
        confirmUrl(urlExportYNPriority)
        verifyHeading(headingExportYNPrio)
    }

    YesNo match {
      case "Yes" => clickByCSS("#hasPriorityGoods")
      case "No" => clickByCSS("#hasPriorityGoods-2")
      case "None" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for YN Priority should be pre filled with (.*)$""") { (YNpriority: String) =>

    YNpriority match {
      case "Yes" => optionSelected("#hasPriorityGoods")
      case "No" => optionSelected("#hasPriorityGoods-2")
    }
  }


  When("""^the user navigates to the (.*) Priority goods page""") { (journey: String) =>
    journey match {
      case "Import" => navigateTo(urlImportPriority)
      case "Export" => navigateTo(urlExportPriority)
    }
  }

  Then("""^the user is on the (.*) Priority Goods page""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportPriority)
      case "Export" => confirmUrl(urlExportPriority)
    }
    verifyHeading(headingPriority)
  }

  When("""^the user is on the (.*) Priority Goods page, selects (.*) and continues""") { (journey: String, requestType: String) =>

    journey match {
      case "Import" => confirmUrl(urlImportPriority)
      case "Export" => confirmUrl(urlExportPriority)
    }

    verifyHeading(headingPriority)

    requestType match {
      case "Explosives or fireworks" => clickByCSS("#priorityGoods")
      case "Human remains" => clickByCSS("#priorityGoods-2")
      case "Live animals" => clickByCSS("#priorityGoods-3")
      case "NoOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for Priority goods should be pre filled with (.*)$""") { (priority: String) =>

    priority match {
      case "Explosives or fireworks" => optionSelected("#priorityGoods")
      case "Human remains" => optionSelected("#priorityGoods-2")
      case "Live animals" => optionSelected("#priorityGoods-3")
    }
  }
}

