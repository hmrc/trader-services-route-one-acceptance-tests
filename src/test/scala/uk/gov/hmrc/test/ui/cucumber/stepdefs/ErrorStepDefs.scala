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
import uk.gov.hmrc.test.ui.pages._

class ErrorStepDefs
    extends FinalConfirmationPage
    with BasePage
    with TransportQuestionsPage
    with ContactDetailsPage
    with LandingPage
    with AmendPages
    with ScalaDsl
    with EN {

  When("""^the user will be on the duplicate case error page and see their case reference number""") { () =>
    confirmUrl(urlDuplicate)
  }

  // Content differs from before and after 4pm
  Then("""^the user will be on the error page for internal server error""") { () =>
    assertElementText("Sorry, there is a problem with the service", findElementByCss("h1"))
  }

  Then("""^the user will be on the error page for an amend journey internal server error""") { () =>
    Thread.sleep(9999999)
    assertElementText("Sorry, there is a problem with the service", findElementByCss("h1"))
    assertElementText(errorContentCaseRef, errorContentAmendCaseRef)
  }

  When("""^the user clicks the link to re enter a case ref number they will be on the case ref page""") { () =>
    clickHref("a[href*='send-documents-for-customs-check/add/case-reference-number']")
    confirmUrl(urlCaseRef)
  }
}
