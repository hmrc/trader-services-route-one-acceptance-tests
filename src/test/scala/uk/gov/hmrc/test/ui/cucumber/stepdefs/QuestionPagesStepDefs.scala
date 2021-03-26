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
import uk.gov.hmrc.test.ui.pages.{BasePage, QuestionPages}

class QuestionPagesStepDefs extends QuestionPages with BasePage with ScalaDsl with EN {

  //Navigate to [page]
  //Is on [page]
  //Navigate to [page] & select [option]
  //Check filled/clear

  //Request Type

  When("""^the user navigates to the (.*) Request Type page""") { (journey: String) =>
    journey match {
      case "Import" => navigateTo(urlImportRequest)
      case "Export" => navigateTo(urlExportRequest)
    }
  }

  Then("""^the user is on the (.*) Request Type page""") { (journey: String) =>
    journey match {
      case "Import" =>
        confirmUrl(urlImportRequest)
        verifyHeading(headingImportRequest)
      case "Export" =>
        confirmUrl(urlExportRequest)
        verifyHeading(headingExportRequest)
    }
  }
  When("""^the user is on the Import Request Type page and selects (.*)""") { (requestType: String) =>
    confirmUrl(urlImportRequest)
    verifyHeading(headingImportRequest)

    requestType match {
      case "New" => clickByCSS("#requestType")
      case "Cancellation" => clickByCSS("#requestType-2")
      case "NoOption" =>
    }
    clickContinue()
  }

  When("""^the user is on the Export Request Type page and selects (.*)""") { (requestType: String) =>
    confirmUrl(urlExportRequest)
    verifyHeading(headingExportRequest)

    requestType match {
      case "New" => clickByCSS("#requestType")
      case "Cancellation" => clickByCSS("#requestType-2")
      case "Withdrawal" => clickByCSS("#requestType-3")
      case "C1601" => clickByCSS("#requestType-4")
      case "C1602" => clickByCSS("#requestType-5")
      case "C1603" => clickByCSS("#requestType-6")
      case "NoOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for Import Request should be pre filled with (.*)$""") { (request: String) =>

    request match {
      case "New" => optionSelected("#requestType")
      case "Cancellation" => optionSelected("#requestType-2")
      case _ => optionNotSelected("#requestType")
        optionNotSelected("#requestType-2")
    }
  }

  Then("""^the last selected option for Export Request should be pre filled with (.*)$""") { (request: String) =>

    request match {
      case "New" => optionSelected("#requestType")
      case "Cancellation" => optionSelected("#requestType-2")
      case "C1601" => optionSelected("#requestType-3")
      case "C1602" => optionSelected("#requestType-4")
      case "C1603" => optionSelected("#requestType-5")
      case "Withdrawal" => optionSelected("#requestType-6")

      case _ => optionNotSelected("#requestType")
        optionNotSelected("#requestType-2")
        optionNotSelected("#requestType-3")
        optionNotSelected("#requestType-4")
        optionNotSelected("#requestType-5")
        optionNotSelected("#requestType-6")
    }
  }


  //Route
  When("""^the user navigates to the (.*) route type page""") { (journey: String) =>
    journey match {
      case "Import" => navigateTo(urlRouteImport)
      case "Export" => navigateTo(urlRouteExport)
    }
  }

  Then("""^the user is on the (.*) Route Type page""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlRouteImport)
      case "Export" => confirmUrl(urlRouteExport)
    }
    verifyHeading(headingRoute)
  }

  When("""^the user is on the (.*) Route Type page and selects (.*)""") { (journey: String, requestType: String) =>

    journey match {
      case "Import" => confirmUrl(urlRouteImport)
      case "Export" => confirmUrl(urlRouteExport)
    }

    verifyHeading(headingRoute)

    requestType match {
      case "Route 1" => clickByCSS("#routeType")
      case "Route 1 CAP" => clickByCSS("#routeType-2")
      case "Route 2" => clickByCSS("#routeType-3")
      case "Route 3" => clickByCSS("#routeType-4")
      case "Route 6" => clickByCSS("#routeType-5")
      case "Hold" => clickByCSS("#routeType-6")
      case "NoOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for Route should be pre filled with (.*)$""") { (route: String) =>

    route match {
      case "Route 1" => optionSelected("#routeType")
      case "Route 1 CAP" => optionSelected("#routeType-2")
      case "Route 2" => optionSelected("#routeType-3")
      case "Route 3" => optionSelected("#routeType-4")
      case "Route 6" => optionSelected("#routeType-5")
      case "Hold" => optionSelected("#routeType-6")

    }
  }

  //Transport
  When("""^the user navigates to the (.*) transport page""") { (journey: String) =>
    journey match {
      case "Import" => navigateTo(urlTransportImport)
      case "Export" => navigateTo(urlTransportExport)
    }
  }

  Then("""^the user is on the (.*) transport type page""") { (journey: String) =>
    journey match {
      case "Import" =>
        confirmUrl(urlTransportImport)

      case "Export" =>
        confirmUrl(urlTransportExport)
    }
    verifyHeading(headingTransport)
  }

  When("""^the user is on the (.*) transport type page and selects (.*)""") { (journey: String, requestType: String) =>
    journey match {
      case "Import" => confirmUrl(urlTransportImport)
      case "Export" => confirmUrl(urlTransportExport)
    }
    verifyHeading(headingTransport)

    requestType match {
      case "Air" => clickByCSS("#freightType")
      case "Maritime" => clickByCSS("#freightType-2")
      case "RoadRoRoRail" => clickByCSS("#freightType-3")
      case "NoOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for transport type should be pre filled with (.*)$""") { (transport: String) =>

    transport match {
      case "Air" => optionSelected("#freightType")
      case "Maritime" => optionSelected("#freightType-2")
      case "RoadRoRoRail" => optionSelected("#freightType-3")
    }
  }

  //ALVS - Import Only
  When("""^the user navigates to the ALVS page""") { () =>
    navigateTo(urlALVS)
  }

  Then("""^the user is on the ALVS page$""") { () =>
    confirmUrl(urlALVS)
    verifyHeading(headingALVS)
  }

  When("""^the user is on the ALVS page and selects (.*)$""") { (yesNo: String) =>
    confirmUrl(urlALVS)
    verifyHeading(headingALVS)

    yesNo match {
      case "Yes" => clickByCSS("#hasALVS")
      case "No" => clickByCSS("#hasALVS-2")
      case "NoOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for ALVS should be pre filled with (.*)$""") { (alvs: String) =>

    alvs match {
      case "Yes" => optionSelected("#hasALVS")
      case "No" => optionSelected("#hasALVS-2")
    }
  }
}