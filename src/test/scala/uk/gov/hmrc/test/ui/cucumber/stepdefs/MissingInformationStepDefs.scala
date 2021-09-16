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
import uk.gov.hmrc.test.ui.pages.{EntryDetailsPage, LandingPage, MissingInformationPage}


class MissingInformationStepDefs extends MissingInformationPage with EntryDetailsPage with ScalaDsl with EN {

  Then("""^the user will be on the (.*) Missing information page$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportMissingInfo)
      case "Export" => confirmUrl(urlExportMissingInfo)
    }
    verifyHeading(headingMissingInfo)
  }

  When("""^the user clicks the button on the Missing information page they will return to entry details""") { () =>
    clickToCompleteInfo()
    confirmUrl(urlEntryDetails)
    verifyHeading(headingEntryDetails)
  }

}