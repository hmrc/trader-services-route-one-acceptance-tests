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
import uk.gov.hmrc.test.ui.pages.{AmendPage, BasePage, FinalConfirmationPage}

class AmendStepDefs extends AmendPage with FinalConfirmationPage with BasePage with ScalaDsl with EN {


  Then("""^the user is on the case ref number page$""") { () =>
    confirmUrl(urlCaseRef)
    verifyHeading(caseRefHeading)
  }
  Then("""^the user enters (.*) characters for case reference number$""") { (caseNo: String) =>
    caseRefInput.clear()

    caseNo match {
      case "tooFew" => sendNCharactersById(caseRefInput, 21)
      case "tooMany" => sendNCharactersById(caseRefInput, 23)
      case "valid" => caseRefInput.sendKeys(userCaseRef)
      case "no" => caseRefInput.sendKeys("")
    }
    clickContinueAmend()
  }

  Then("""^the user is on the how to respond page$""") { () =>
    confirmUrl(urlHowToSend)
    verifyHeading(howToSendHeading)
  }

  Then("""^the user is on the how to respond page and selects (.*)""") { (caseNo: String) =>
    confirmUrl(urlHowToSend)
    verifyHeading(howToSendHeading)

    caseNo match {
      case "writeOnly" => clickByCSS("#typeOfAmendment")
      case "uploadOnly" => clickByCSS("#typeOfAmendment-2")
      case "write&Upload" => clickByCSS("#typeOfAmendment-3")
      case "noOption" =>
    }
    clickContinue()
  }

  Then("""^the last selected option for type of amendment should be (.*)$""") { (request: String) =>

    request match {
      case "writeOnly" => optionSelected("#typeOfAmendment")
      case "uploadOnly" => optionSelected("#typeOfAmendment-2")
      case "write&Upload" => optionSelected("#typeOfAmendment-3")
    }
  }

  Then("""^the user is on the write response page""") { () =>
    confirmUrl(urlWriteResponse)
    verifyHeading(writeResponseHeading)
  }

  Then("""^the details in the case ref field should be pre-filled with "(.*)"$""") {
    (caseRef:String) =>
      verifyInput(caseRefInput, caseRef)
  }

  Then("""^the details in the text box should be pre-filled with "(.*)"$""") {
    (text:String) =>
      verifyInput(textInput, text)
  }

  Then("""^the user is on upload documents page""") { () =>
    confirmUrl(urlHowToSend)
    verifyHeading(howToSendHeading)
  }

  Then("""^the user enters a response with (.*) characters""") { (characters: String) =>
    characters match {
      case "tooMany" => sendNCharactersById(textInput, 1001)
      case "valid" => sendNCharactersById(textInput, 1000)
      case "no" => sendNCharactersById(textInput, 0)
    }
    clickContinue()
  }

  Then("""^the user enters a response "(.*)" and continues$""") {
    (response:String) =>
      writeById(textInput, response)
      clickContinue()
  }

  Then("""^the user enters a case ref number "(.*)" and continues$""") {
    (caseRef:String) =>
      writeById(caseRefInput, caseRef)
      clickContinueAmend()
  }
}

