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
import uk.gov.hmrc.test.ui.pages.{BasePage, ConsignmentNumPage}


class ConsignmentNumStepDefs extends ConsignmentNumPage with BasePage with ScalaDsl with EN {

  Given("""^the user navigates to the declaration details page$""") { () =>
    navigateTo(url)
  }

  Given("""^the user is on the consignment number page$""") { () =>
    confirmUrl(url)
    verifyHeading(heading)
  }

  Then("""^the user enters consignment details "(.*)" and "(.*)"$""") {
    (epu: String, entryNumber: String) =>
      writeById("epu", epu)
      writeById("entryNumber", entryNumber)
  }

  Then("""^the user enters a date "(.*)" "(.*)" "(.*)"$""") {
    (dateDay: String, dateMonth: String, dateYear: String) =>
      writeById("entryDate.day", dateDay)
      writeById("entryDate.month", dateMonth)
      writeById("entryDate.year", dateYear)
  }
}

//  When("""^the user enters the following details on the declaration page$""") { dataTable: DataTable =>
//
//    for (data: java.util.Map[String, String] <- dataTable.asMaps(classOf[String], classOf[String])) {
//      val field = data.get("Field") match {
//        case "epu" => "epu"
//        case "entryNumber" => "entryNumber"
//        case "Day" => "entryDate.day"
//        case "Month" => "entryDate.month"
//        case "Year" => "entryDate.year"
//      }
//      val value = data.get("Value")
//      driver.findElement(By.id(field)).sendKeys(value)
//    }
//  }

