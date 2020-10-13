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
import uk.gov.hmrc.test.ui.pages.{BasePage, VesselQuestionsPage}


class VesselStepDefs extends VesselQuestionsPage with BasePage with ScalaDsl with EN {


  Given("""^the user is on the (.*) Vessel Page$""") { (Journey: String) =>

    Journey match {
      case "Import" => confirmUrl(urlImportVessel)
      case "Export" => confirmUrl(urlExportVessel)
      case "Export-Mandatory" => confirmUrl(urlMandatoryVessel)

    }
    verifyHeading(headingVessel)
  }

  Then("""^the user enters (.*) for vessel name$""") { (vesselName:String) =>
    writeById("vesselName", vesselName)
  }

  Then("""^the user enters a date for the vessel "(.*)" "(.*)" "(.*)"$""") {
    (vesselDay: String, vesselMonth: String, vesselYear: String) =>
      writeById("dateOfArrival.day", vesselDay)
      writeById("dateOfArrival.month", vesselMonth)
      writeById("dateOfArrival.year", vesselYear)
  }

  Then("""^the user enters a time for the vessel "(.*)" "(.*)"$""") {
    (vesselHrs: String, vesselMins: String) =>
      writeById("timeOfArrival.hour", vesselHrs)
      writeById("timeOfArrival.minutes", vesselMins)
  }

  Then("""^the user enters selects period (.*) for the vessel$""") {(period: String) =>
      period match {
        case "AM" => clickByCSS("#timeOfArrival.period-am")
        case "PM" => clickByCSS("#timeOfArrival.period-pm")
      }
  }

}


//DATA TABLE
//When("""^the HMRC user enters all below mandatory customer details on the customer search page$""") { dataTable: DataTable => //Generic case for any feature test 96, 98, 99
//
//  for (data: java.util.Map[String, String] <- dataTable.asMaps(classOf[String], classOf[String])) {
//  val field = data.get("Field") match {
//  case "NINO" => "nino"
//  case "First name" => "givenName"
//  case "Family name" => "familyName"
//  case "Day" => "dateOfBirth.day"
//  case "Month" => "dateOfBirth.month"
//  case "Year" => "dateOfBirth.year"
//}
//  val value = data.get("Value")
//  webDriver.findElement(By.id(field)).sendKeys(value)
//}
//}