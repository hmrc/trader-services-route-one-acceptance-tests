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

  Given("""^the user is on the consignment number page$""") { () =>
    confirmUrl(url)
    verifyHeading(heading)
  }

  Then("""^the user enters consignment details (.*) and (.*)$""") {
    (epu: String, entryNo:String) =>
      writeById("epu", epu)
      writeById("entryNo", entryNo)
  }

  Then("""^the user enters a date (.*) (.*) (.*)$""") {
    (dateDay:String, dateMonth:String, dateYear:String) =>
      writeById("dateDay", dateDay)
      writeById("dateMonth", dateMonth)
      writeById("dateYear", dateYear)
  }

}

//When ("""^the user enters the following valid consignment details""") {() =>
//  epu.sendKeys("123")
//  entryNumber.sendKeys("123456Z")
//  dayDate.sendKeys("01")
//  dayMonth.sendKeys("09")
//  dayYear.sendKeys("2020")
//
//}
