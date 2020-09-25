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
import uk.gov.hmrc.test.ui.pages.{BasePage, QuestionPages}


class QuestionPagesStepDefs extends QuestionPages with BasePage with ScalaDsl with EN {


  Given("""^the user is on the (.*) question page$""") { (EntryNo: String) =>
    EntryNo match {
      case "Import" => confirmUrl(urlImport)
        verifyHeading(headingImport)
      case "Export" => confirmUrl(urlExport)
        verifyHeading(headingExport)
    }
  }

  When("""^the user selects (.*) for Import REQUEST TYPE""") { (RequestType: String) =>
    RequestType match {
      case "New" => requestNew.click()
      case "Cancel" => requestCancel.click()
      case "Hold" => requestHold.click()
      case "ALVS" => requestALVS.click()
    }
  }

  When("""^the user selects (.*) for Export REQUEST TYPE""") { (RequestType: String) =>
    RequestType match {
      case "New" => requestNew.click()
      case "Cancel" => requestCancel.click()
      case "Hold" => requestHold.click()
      case "C1601" => requestC1601.click()
      case "C1602" => requestC1602.click()
      case "C1603" => requestC1603.click()
      case "Withdrawal" => requestWithdrawal.click()
    }
  }

  When("""^the user selects (.*) for ROUTE""") { (RequestType: String) =>
    RequestType match {
      case "Route1" => route1.click()
      case "Route1CAP" => route1CAP.click()
      case "Route2" => route2.click()
      case "Route3" => route3.click()
      case "Route6" => route6.click()
      case "Hold" => routeHold.click()
    }
  }

  When("""^the user selects (.*) for PRIORITY""") { (RequestType: String) =>
    RequestType match {
      case "None" => priorityNone.click()
      case "LiveAnimals" => priorityLiveAnimals.click()
      case "HumanRemains" => priorityHumanRemains.click()
      case "Explosives" => priorityExplosives.click()
      case "HighValueArt" => priorityArt.click()
      case "ClassAs" => priorityClassA.click()
    }
  }

  When("""^the user selects (.*) for FREIGHT""") { (RequestType: String) =>
    RequestType match {
      case "Maritime" => freightMaritime.click()
      case "Air" => freightAir.click()
      case "RoadRoRoRail" => freightRoadRoRoRail.click()

    }
  }
}