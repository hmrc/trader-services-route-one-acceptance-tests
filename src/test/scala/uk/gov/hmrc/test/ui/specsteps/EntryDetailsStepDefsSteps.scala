/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps

import uk.gov.hmrc.test.ui.specpage.EntryDetailsPage

object EntryDetailsStepDefsSteps extends EntryDetailsPage {

  // ^the user will be on the entry details page$
  def thenTheUserWillBeOnTheEntryDetailsPage(): Unit = {
    confirmUrl(urlEntryDetails)
  }

  // ^the user enters entry details "(.*)" and "(.*)"$
  def whenTheUserEntersEntryDetailsXAndX(epu: String, entryNumber: String): Unit = {
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

  // ^the user enters a date "(.*)" "(.*)" "(.*)"$
  def andTheUserEntersADateXXX(dateDay: String, dateMonth: String, dateYear: String): Unit = {
    writeById(entryDay, dateDay)
        writeById(entryMonth, dateMonth)
        writeById(entryYear, dateYear)
  }

  // ^the details entered for EPU & EntryNo should be pre filled with (.*) & (.*)$
  def thenTheDetailsEnteredForEPU_EntryNoShouldBePreFilledWithX_And_X(epu: String, entryNumber: String): Unit = {
    verifyInput(EPU, epu)
          verifyInput(entryNo, entryNumber)
  }

  // ^the details entered for entry Date should be pre filled with (.*), (.*) & (.*)$
  def thenTheDetailsEnteredForEntryDateShouldBePreFilledWithX_X_And_X(dateDay: String, dateMonth: String, dateYear: String): Unit = {
    verifyInput(entryDay, dateDay)
          verifyInput(entryMonth, dateMonth)
          verifyInput(entryYear, dateYear)
  }

}
