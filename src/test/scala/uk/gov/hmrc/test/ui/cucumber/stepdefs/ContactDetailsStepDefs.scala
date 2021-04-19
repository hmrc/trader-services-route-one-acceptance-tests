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
import uk.gov.hmrc.test.ui.pages.ContactDetailsPage


class ContactDetailsStepDefs extends ContactDetailsPage with ScalaDsl with EN {

  Then("""^the user will be on the (.*) Contact details page$""") { (journey: String) =>
    journey match {
      case "Import" => confirmUrl(urlImportContact)
      case "Export" => confirmUrl(urlExportContact)
    }
    verifyHeading(headingContactInfo)
  }

  When("""^the user enters a name "(.*)"$""") {
    (name: String) =>
      writeById(fullName, name)
  }

  And("""^the user enters an email address "(.*)"$""") {
    (emailAddress: String) =>

      emailAddress match {
        case "testEmail" => writeById(email, generateTestEmailAddress)
        case _ => writeById(email, emailAddress)
      }
  }

  And("""^the user enters a phone number "(.*)"$""") {
    (phone: String) =>
      writeById(phoneNo, phone)
  }

  Then("""^the details entered for name, email and phone number should be pre-filled with "(.*)", "(.*)" & "(.*)"$""") {
    (name: String, emailAddress: String, phone: String) =>
      verifyInput(fullName, name)
      verifyInput(email, emailAddress)
      verifyInput(phoneNo, phone)
  }
}