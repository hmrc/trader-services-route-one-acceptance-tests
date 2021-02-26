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
import uk.gov.hmrc.test.ui.pages.{BasePage, VesselQuestionsPage}


class VesselStepDefs extends VesselQuestionsPage with BasePage with ScalaDsl with EN {


  When("""^the user navigates to the (.*) vessel page""") { (Journey: String) =>
    Journey match {
      case "Import-Optional" => navigateTo(urlImportVessel)
      case "Import-Mandatory" => navigateTo(urlImpMandatoryVessel)
      case "Export-Optional" => navigateTo(urlExportVessel)
      case "Export-Mandatory" => navigateTo(urlExpMandatoryVessel)
    }
  }

  Then("""^the user is on the (.*) Vessel Page$""") { (Journey: String) =>

    Journey match {
      case "Import-Optional" => confirmUrl(urlImportVessel)
      case "Import-Mandatory" => confirmUrl(urlImpMandatoryVessel)
      case "Export-Optional" => confirmUrl(urlExportVessel)
      case "Export-Mandatory" => confirmUrl(urlExpMandatoryVessel)

    }
    verifyHeading(headingVessel)
  }

  Then("""^the user enters "(.*)" for vessel name$""") { (vesselName: String) =>
    writeById(vesselQName, vesselName)
  }

  Then("""^the user enters a Date of (.*) for the vessel "(.*)" "(.*)" "(.*)"$""") {
    (journey: String, vesselDay: String, vesselMonth: String, vesselYear: String) =>

      journey match {
        case "Arrival" =>
          writeById(vesselQArrivalDay, vesselDay)
          writeById(vesselQArrivalMonth, vesselMonth)
          writeById(vesselQArrivalYear, vesselYear)

        case "Departure" =>
          writeById(vesselQDepartureDay, vesselDay)
          writeById(vesselQDepartureMonth, vesselMonth)
          writeById(vesselQDepartureYear, vesselYear)
      }
  }

  Then("""^the user enters a Time of (.*) for the vessel "(.*)" "(.*)"$""") {
    (journey: String, vesselHrs: String, vesselMins: String) =>

      journey match {
        case "Arrival" =>
          writeById(vesselQArrivalHours, vesselHrs)
          writeById(vesselQArrivalMinutes, vesselMins)

        case "Departure" =>
          writeById(vesselQDepartureHours, vesselHrs)
          writeById(vesselQDepartureMinutes, vesselMins)
      }
  }

  Then("""^the details entered for Vessel Name should be pre filled with "(.*)"$""") {
    (vesselName: String) =>
      verifyInput(vesselQName, vesselName)
  }

  Then("""^the details entered for Date of (.*) should be pre filled with (.*), (.*) & (.*)$""") {
    (journey: String, vesselDay: String, vesselMonth: String, vesselYear: String) =>
      journey match {

        case "Arrival" =>
          verifyInput (vesselQArrivalDay, vesselDay)
          verifyInput(vesselQArrivalMonth, vesselMonth)
          verifyInput(vesselQArrivalYear, vesselYear)

        case "Departure" =>
          verifyInput (vesselQDepartureDay, vesselDay)
          verifyInput(vesselQDepartureMonth, vesselMonth)
          verifyInput(vesselQDepartureYear, vesselYear)
  }
}


  Then("""^the details entered for Time of (.*) should be pre filled with "(.*)" & "(.*)"$""") {
    (journey: String, vesselHrs: String, vesselMins: String) =>

      journey match {
        case "Arrival" =>
          verifyInput (vesselQArrivalHours, vesselHrs)
          verifyInput (vesselQArrivalMinutes, vesselMins)

        case "Departure" =>
          verifyInput (vesselQDepartureHours, vesselHrs)
          verifyInput (vesselQDepartureMinutes, vesselMins)

      }
  }
}
