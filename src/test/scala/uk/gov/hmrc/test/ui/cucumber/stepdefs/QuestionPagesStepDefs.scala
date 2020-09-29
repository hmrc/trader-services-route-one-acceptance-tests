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
import uk.gov.hmrc.test.ui.pages.{BasePage, QuestionPages}


class QuestionPagesStepDefs extends QuestionPages with BasePage with ScalaDsl with EN {


  Given("""^the user is on the "(.*)" question page$""") { (EntryNo: String) =>
    EntryNo match {
      case "Import" => confirmUrl(urlImport)
        verifyHeading(headingImport)
      case "Export" => confirmUrl(urlExport)
        verifyHeading(headingExport)
    }
  }


  When("""^the user is on the Import Request Type page and selects (.*)""") { (RequestType: String) =>
//    confirmUrl(urlImportRequest)
//    verifyHeading(headingImportRequest)

    RequestType match {
      case "New" => findElementById("requestType").click()
      case "Cancel" => findElementById("requestType-2").click()
      case "Hold" => findElementById("requestType-3").click()
      case "None" =>
    }
//    clickContinue()
  }

  When("""^the user is on the Export Request Type page and selects (.*)""") { (RequestType: String) =>
//  confirmUrl(urlExportRequest)
//  verifyHeading(headingExportRequest)

    RequestType match {
      case "New" => clickByCSS("#requestType")
      case "Cancel" => clickByCSS("#requestType-2")
      case "Hold" => clickByCSS("#requestType-3")
      case "C1601" => clickByCSS("#requestType-4")
      case "C1602" => clickByCSS("#requestType-5")
      case "C1603" => clickByCSS("#requestType-6")
      case "Withdrawal" => clickByCSS("#requestType-7")
      case "None" =>
    }
        clickContinue()
  }


  When("""^the user is on the Route Type Page and selects (.*)""") { (RequestType: String) =>
//        confirmUrl(urlRoute)
//        verifyHeading(headingRoute)

    RequestType match {
      case "Route1" => clickByCSS("#routeType")
      case "Route1CAP" => clickByCSS("#routeType-2")
      case "Route2" => clickByCSS("#routeType-3")
      case "Route3" => clickByCSS("#routeType-4")
      case "Route6" => clickByCSS("#routeType-5")
      case "Hold" => clickByCSS("#routeType-6")
      case "None" =>
    }
    //    clickContinue()
  }

  When("""^the user is one the Priority Page and selects (.*)""") { (RequestType: String) =>
//    confirmUrl(urlPriority)
//    verifyHeading(headingPriority)

    RequestType match {
      case "None" => clickByCSS("#goodsPriority")
      case "LiveAnimals" => clickByCSS("#goodsPriority-2")
      case "HumanRemains" => clickByCSS("#goodsPriority-3")
      case "Explosives" => clickByCSS("#goodsPriority-4")
      case "HighValueArt" => clickByCSS("#goodsPriority-5")
      case "ClassAs" => clickByCSS("#goodsPriority-6")
      case "None" =>
    }
    //    clickContinue()
  }

  When("""^the user is on the Freight Page and selects (.*)""") { (RequestType: String) =>
//    confirmUrl(urlFreight)
//    verifyHeading(headingFreight)

    RequestType match {
      case "Maritime" => clickByCSS("#freightType")
      case "Air" => clickByCSS("#freightType-2")
      case "RoadRoRoRail" => clickByCSS("#freightType-3")
      case "None" =>

    }
    //    clickContinue()
  }
}
