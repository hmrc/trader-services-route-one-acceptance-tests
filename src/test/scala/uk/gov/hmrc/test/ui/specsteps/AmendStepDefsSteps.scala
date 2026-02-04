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

import uk.gov.hmrc.test.ui.specpage.{AmendPages, FinalConfirmationPage}

object AmendStepDefsSteps extends AmendPages with FinalConfirmationPage {

  // ^the user will be on the Case Reference number page$
  def thenTheUserWillBeOnTheCaseReferenceNumberPage(): Unit = {
    confirmUrl(urlCaseRef)
  }

  // ^the user enters "(.*)" characters for case reference number and continues
  def thenTheUserEntersXCharactersForCaseReferenceNumberAndContinues(caseNo: String): Unit = {
    caseRefInput.clear()

        caseNo match {
          case "tooFew"  => sendNCharactersById(caseRefInput, 21)
          case "tooMany" => sendNCharactersById(caseRefInput, 23)
          case "valid"   => caseRefInput.sendKeys(userCaseRef)
          case "no"      => caseRefInput.sendKeys("")
          case _         => caseRefInput.sendKeys(caseNo)
        }
        clickContinueCaseRef()
  }

  // ^the user will be on the Amendment type page$
  def thenTheUserWillBeOnTheAmendmentTypePage(): Unit = {
    confirmUrl(urlHowToSend)
  }

  // ^the user is on the Amendment type page, selects (.*) and continues
  def whenTheUserIsOnTheAmendmentTypePageSelectsXAndContinues(amendmentType: String): Unit = {
    amendmentType match {
          case "writeOnly"      => clickByCSS("#typeOfAmendment")
          case "uploadOnly"     => clickByCSS("#typeOfAmendment-2")
          case "writeAndUpload" => clickByCSS("#typeOfAmendment-3")
          case _                =>
        }
        clickContinue()
  }

  // ^the last selected option for type of amendment should be (.*)$
  def thenTheLastSelectedOptionForTypeOfAmendmentShouldBeX(request: String): Unit = {
    request match {
          case "writeOnly"      => optionSelected("#typeOfAmendment")
          case "uploadOnly"     => optionSelected("#typeOfAmendment-2")
          case "writeAndUpload" => optionSelected("#typeOfAmendment-3")
        }
  }

  // ^the user will be on the write response page
  def thenTheUserWillBeOnTheWriteResponsePage(): Unit = {
    confirmUrl(urlWriteResponse)
  }

  // ^the details in the case ref field should be pre-filled with "(.*)"$
  def thenTheDetailsInTheCaseRefFieldShouldBePreFilledWithX(caseRef: String): Unit = {
    verifyInput(caseRefInput, caseRef)
  }

  // ^the details in the text box should be pre-filled with "(.*)"$
  def thenTheDetailsInTheTextBoxShouldBePreFilledWithX(text: String): Unit = {
    verifyInput(textInputAmend, text)
  }

  // ^the user is on upload documents page
  def thenTheUserIsOnUploadDocumentsPage(): Unit = {
    confirmUrl(urlHowToSend)
  }

  // ^the user enters "(.*)" characters in the write response field and continues
  def thenTheUserEntersXCharactersInTheWriteResponseFieldAndContinues(response: String): Unit = {
    response match {
          case "too many" => writeById(textInputAmend, randomString(1001))
          case "valid"    => writeById(textInputAmend, randomString(1000))
          case "no"       => writeById(textInputAmend, randomString(0))
          case _          => writeById(textInputAmend, response)
        }
        clickContinue()
  }

}
