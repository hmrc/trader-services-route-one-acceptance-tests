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
import uk.gov.hmrc.test.ui.pages.{BasePage, ContactDetailsPage, NewCYAPage}

class NewCYAStepDefs extends NewCYAPage with BasePage with ContactDetailsPage with ScalaDsl with EN {

  Then("""^the user will be on the (.*) CYA page - mandatory$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
  }

  Then("""^the user will be on the (.*) CYA page$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
  }

  When("""^the user clicks the change link for (.*)$""") { (changeLink: String) =>
    changeLink match {

      case "Entry"            => clickHref("a[href*='entry-details']")
      case "Request"          => clickHref("a[href*='request-type']")
      case "Route"            => clickHref("a[href*='route']")
      case "PriorityYN"       => clickHref("a[href*='priority-goods']")
      case "PriorityGoods"    => clickHref("a[href*='which-priority-goods']")
      case "ALVS"             => clickHref("a[href*='automatic-licence-verification']")
      case "Transport"        => clickHref("a[href*='transport-type']")
      case "TransportDetails" => clickHref("a[href*='transport-information']")
      case "ContactDetails"   => clickHref("a[href*='contact-information']")
      case "Documents"        =>
        if (javascriptDisable) {
          clickHref("a[href*='file-upload']")
        } else {
          clickHref("a[href*='upload-files']")
        }
    }
  }
}
