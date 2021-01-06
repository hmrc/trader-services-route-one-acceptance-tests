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

import java.util.UUID

import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.test.ui.pages.ContactDetailsPage


class ContactDetailsStepDefs extends ContactDetailsPage with ScalaDsl with EN {


  When ("""^the user navigates to the (.*) contact details page""") { (Journey:String) =>
    Journey match {
      case "Import" => navigateTo(urlImportContact)
      case "Export" => navigateTo(urlExportContact)
    }
  }


  Then("""^the user is on the (.*) Contact Details Page$""") { (Journey: String) =>
    Journey match {
      case "Import" => confirmUrl(urlImportContact)
      case "Export" => confirmUrl(urlExportContact)
    }
    verifyHeading(headingContactInfo)
  }


  Then("""^the user enters a name "(.*)"$""") {
    (name: String) =>
      writeById(fullName, name)
  }

  Then("""^the user enters an email address "(.*)"$""") {
    (emailAddress: String) =>

      emailAddress match {
        case "testEmail" => writeById(email, generateTestEmailAddress)
        case _ => writeById (email, emailAddress)
      }
  }

  Then("""^the user enters a phone number "(.*)"$""") {
    (phone: String) =>
      writeById(phoneNo, phone)
  }


Then("""^the details entered for name, email and phone number should be pre-filled with "(.*)", "(.*)" & "(.*)"$""") {
  (name:String, emailAddress:String, phone:String) =>
  verifyInput(fullName, name)
  verifyInput(email, emailAddress)
  verifyInput(phoneNo, phone)
}

  var lastUsedTestEmail: String = ""
  def generateTestEmailAddress: String = {
    lastUsedTestEmail = s"test${UUID.randomUUID().toString}@test.com"
    lastUsedTestEmail
  }
}