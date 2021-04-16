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
import uk.gov.hmrc.test.ui.pages.{BasePage, TransportQuestionsPage}


class TransportStepDefs extends TransportQuestionsPage with BasePage with ScalaDsl with EN {

  When("""^the user navigates to the (.*) transport details page""") { (journey: String) =>
    journey match {
      case "Import-Optional" => navigateTo(urlImportTransport)
      case "Import-Mandatory" => navigateTo(urlImpMandatoryTransport)
      case "Export-Optional" => navigateTo(urlExportTransport)
      case "Export-Mandatory" => navigateTo(urlExpMandatoryTransport)
    }
  }

  Then("""^the user will be on the (.*) transport details page$""") { (journey: String) =>

    journey match {
      case "Import-Optional" => confirmUrl(urlImportTransport)
      case "Import-Mandatory" => confirmUrl(urlImpMandatoryTransport)
      case "Export-Optional" => confirmUrl(urlExportTransport)
      case "Export-Mandatory" => confirmUrl(urlExpMandatoryTransport)

    }
    verifyHeading(headingTransportDetails)
  }

  Then("""^the user enters "(.*)" for transport name$""") { (transportName: String) =>
    writeById(transportQName, transportName)
  }

  Then("""^the user enters a date of (.*) for their transportation "(.*)" "(.*)" "(.*)"$""") {
    (journey: String, transportDay: String, transportMonth: String, transportYear: String) =>

      journey match {
        case "Arrival" =>
          writeById(transportQArrivalDay, transportDay)
          writeById(transportQArrivalMonth, transportMonth)
          writeById(transportQArrivalYear, transportYear)

        case "Departure" =>
          writeById(transportQDepartureDay, transportDay)
          writeById(transportQDepartureMonth, transportMonth)
          writeById(transportQDepartureYear, transportYear)
      }
  }

  Then("""^the user enters a time of (.*) for their transportation "(.*)" "(.*)"$""") {
    (journey: String, transportHrs: String, transportMins: String) =>

      journey match {
        case "Arrival" =>
          writeById(transportQArrivalHours, transportHrs)
          writeById(transportQArrivalMinutes, transportMins)

        case "Departure" =>
          writeById(transportQDepartureHours, transportHrs)
          writeById(transportQDepartureMinutes, transportMins)
      }
  }

  Then("""^the details entered for transport name should be pre filled with "(.*)"$""") {
    (transportName: String) =>
      verifyInput(transportQName, transportName)
  }

  Then("""^the details entered for Date of (.*) should be pre filled with (.*), (.*) & (.*)$""") {
    (journey: String, transportDay: String, transportMonth: String, transportYear: String) =>
      journey match {

        case "Arrival" =>
          verifyInput(transportQArrivalDay, transportDay)
          verifyInput(transportQArrivalMonth, transportMonth)
          verifyInput(transportQArrivalYear, transportYear)

        case "Departure" =>
          verifyInput(transportQDepartureDay, transportDay)
          verifyInput(transportQDepartureMonth, transportMonth)
          verifyInput(transportQDepartureYear, transportYear)
      }
  }


  Then("""^the details entered for Time of (.*) should be pre filled with "(.*)" & "(.*)"$""") {
    (journey: String, transportHrs: String, transportMins: String) =>

      journey match {
        case "Arrival" =>
          verifyInput(transportQArrivalHours, transportHrs)
          verifyInput(transportQArrivalMinutes, transportMins)

        case "Departure" =>
          verifyInput(transportQDepartureHours, transportHrs)
          verifyInput(transportQDepartureMinutes, transportMins)

      }
  }
}
