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

  //Has-priority-goods (Y/N)

  When ("""^the user navigates to the (.*) YN priority type page""") {(Journey:String) =>
    Journey match {
      case "Import" => navigateTo(urlImportYNPriority)
      case "Export" => navigateTo(urlExportYNPriority)
    }
  }

  Then("""^the user is on the (.*) YN Priority Page""") { (Journey: String) =>
    Journey match {
      case "Import" => confirmUrl(urlImportYNPriority)
      case "Export" => confirmUrl(urlExportYNPriority)
    }
    verifyHeading(headingYesNoPriority)
  }

  When("""^the user is on the (.*) YesNo Priority Page and selects (.*)""") { (Journey: String, YesNo: String) =>

    Journey match {
      case "Import" => confirmUrl (urlImportYNPriority)
      case "Export" => confirmUrl(urlExportYNPriority)
    }

    verifyHeading (headingYesNoPriority)

    YesNo match {
      case "Yes" => clickByCSS("#hasPriorityGoods")
      case "No" => clickByCSS("#hasPriorityGoods-2")
      case "None" =>
    }
    clickContinue()
  }


  //Which-priority-goods

  When ("""^the user navigates to the (.*) priority goods page""") {(Journey:String) =>
    Journey match {
      case "Import" => navigateTo(urlImportPriority)
      case "Export" => navigateTo(urlExportPriority)
    }
  }

  Then("""^the user is on the (.*) Priority Goods Page""") { (Journey: String) =>
    Journey match {
      case "Import" => confirmUrl(urlImportPriority)
      case "Export" => confirmUrl(urlExportPriority)
    }
    verifyHeading(headingPriority)
  }

  When("""^the user is on the (.*) Priority Options Page and selects (.*)""") { (Journey: String, RequestType: String) =>

      Journey match {
        case "Import" => confirmUrl (urlImportPriority)
        case "Export" => confirmUrl(urlExportPriority)
      }

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

