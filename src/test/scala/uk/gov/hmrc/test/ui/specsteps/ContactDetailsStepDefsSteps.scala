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

import uk.gov.hmrc.test.ui.specpage.ContactDetailsPage

object ContactDetailsStepDefsSteps extends ContactDetailsPage {

  // ^the user will be on the (.*) Contact details page$
  def thenTheUserWillBeOnTheXContactDetailsPage(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlImportContact)
          case "Export" => confirmUrl(urlExportContact)
        }
  }

  // ^the user enters a name "(.*)"$
  def whenTheUserEntersANameX(name: String): Unit = {
    writeById(fullName, name)
  }

  // ^the user enters an email address "(.*)"$
  def andTheUserEntersAnEmailAddressX(emailAddress: String): Unit = {
    emailAddress match {
          case "testEmail" => writeById(email, generateTestEmailAddress)
          case _           => writeById(email, emailAddress)
        }
  }

  // ^the user enters a phone number "(.*)"$
  def andTheUserEntersAPhoneNumberX(phone: String): Unit = {
    writeById(phoneNo, phone)
  }

  // ^the details entered for name, email and phone number should be pre-filled with "(.*)", "(.*)" & "(.*)"$
  def thenTheDetailsEnteredForNameEmailAndPhoneNumberShouldBePreFilledWithX_Y_And_Z(name: String, emailAddress: String, phone: String): Unit = {
    verifyInput(fullName, name)
          verifyInput(email, emailAddress)
          verifyInput(phoneNo, phone)
  }

}
