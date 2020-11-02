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
import uk.gov.hmrc.test.ui.pages.{BasePage, DeclarationNumPage}


class DeclarationNumStepDefs extends DeclarationNumPage with BasePage with ScalaDsl with EN {

  Given("""^the user navigates to the declaration details page$""") { () =>
    navigateTo(urlDecDetails)
  }

  Given("""^the user is on the declaration details page$""") { () =>
    confirmUrl(urlDecDetails)
    verifyHeading(headingDecDetails)
  }

  Then("""^the user enters declaration details "(.*)" and "(.*)"$""") {
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


  Then("""^the details entered for EPU & EntryNo should be pre filled with (.*) & (.*)$""") {
    (epu:String, entryNo:String) =>
      verifyInput("epu", epu)
      verifyInput("entryNumber", entryNo)
  }

  Then("""^the details entered for Declaration Date should be pre filled with (.*), (.*) & (.*)$""") {
    (dateDay:String, dateMonth:String, dateYear:String) =>
      verifyInput("entryDate.day", dateDay)
      verifyInput("entryDate.month", dateMonth)
      verifyInput("entryDate.year", dateYear)
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") {
    (dateField: String) =>

      dateField match {

case "Declaration Date" =>
      verifyInput ("entryDate.day", todayDate.getDayOfMonth.toString)
      verifyInput ("entryDate.month", todayDate.getMonthValue.toString)
      verifyInput ("entryDate.year", todayDate.getYear.toString)

case "Date of Arrival" =>
      verifyInput ("dateOfArrival.day", todayDate.getDayOfMonth.toString)
      verifyInput ("dateOfArrival.month", todayDate.getMonthValue.toString)
      verifyInput ("dateOfArrival.year", todayDate.getYear.toString)
      }
      }
  }
