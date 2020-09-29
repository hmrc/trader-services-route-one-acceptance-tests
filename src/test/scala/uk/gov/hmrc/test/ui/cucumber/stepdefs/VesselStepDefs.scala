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


  Given("""^the user is on the vessel page$""") { () =>
    confirmUrl(urlVessel)
    verifyHeading(headingVessel)
  }

  Then("""^the user enters a vessel name$""") { () =>
    vesselName.sendKeys("")
  }
  //Validation on name? If none can be static entry


  Then("""^the user enters a date for the vessel "(.*)" "(.*)" "(.*)"$""") {
    (vesselDay: String, vesselMonth: String, vesselYear: String) =>
      writeById("", vesselDay)
      writeById("", vesselMonth)
      writeById("", vesselYear)
  }

  Then("""^the user enters a time for the vessel "(.*)" "(.*)"$""") {
    (vesselHrs: String, vesselMins: String) =>
      writeById("", vesselHrs)
      writeById("", vesselMins)
  }

//  When("""^the user enters the following vessel details $""") {() =>
//    vesselName.sendKeys("")
//    vesselDateDay.sendKeys("")
//    vesselDateMonth.sendKeys("")
//    vesselDateYear.sendKeys("")
//    vesselTimeHrs.sendKeys("")
//    vesselTimeMins.sendKeys("")
//  }
}