/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.{BasePage, EntryDetailsPage}

class EntryDetailsStepDefs extends EntryDetailsPage with BasePage with ScalaDsl with EN {

  Then("""^the user will be on the entry details page$""") { () =>
    confirmUrl(urlEntryDetails)
  }

  When("""^the user enters entry details "(.*)" and "(.*)"$""") { (epu: String, entryNumber: String) =>
    epu match {
      case "randomEPU" => writeById(EPU, randomEPU)
      case _           => writeById(EPU, epu)
    }

    entryNumber match {
      case "importEN" => writeById(entryNo, importEN)
      case "exportEN" => writeById(entryNo, exportEN)
      case _          => writeById(entryNo, entryNumber)
    }
  }

  And("""^the user enters a date "(.*)" "(.*)" "(.*)"$""") { (dateDay: String, dateMonth: String, dateYear: String) =>
    writeById(entryDay, dateDay)
    writeById(entryMonth, dateMonth)
    writeById(entryYear, dateYear)
  }

  Then("""^the details entered for EPU & EntryNo should be pre filled with (.*) & (.*)$""") {
    (epu: String, entryNumber: String) =>
      verifyInput(EPU, epu)
      verifyInput(entryNo, entryNumber)
  }

  Then("""^the details entered for entry Date should be pre filled with (.*), (.*) & (.*)$""") {
    (dateDay: String, dateMonth: String, dateYear: String) =>
      verifyInput(entryDay, dateDay)
      verifyInput(entryMonth, dateMonth)
      verifyInput(entryYear, dateYear)
  }
}
