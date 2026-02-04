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

object ErrorStepDefsSteps extends FinalConfirmationPage with AmendPages {

  // ^the user will be on the duplicate case error page and see their case reference number
  def whenTheUserWillBeOnTheDuplicateCaseErrorPageAndSeeTheirCaseReferenceNumber(): Unit = {
    confirmUrl(urlDuplicate)
  }

  // ^the user redirects to Signout link with google link
  def whenTheUserRedirectsToSignoutLinkWithGoogleLink(): Unit = {
    navigateTo(traderServicesBaseUrl + "/sign-out?continueUrl=https://www.google.com")
  }

  // ^the user will be on the error page for internal server error
  def thenTheUserWillBeOnTheErrorPageForInternalServerError(): Unit = {
    assertElementText("Sorry, there is a problem with the service", findElementByCss("h1"))
  }

  // ^the user will be on the error page for an amend journey internal server error
  def thenTheUserWillBeOnTheErrorPageForAnAmendJourneyInternalServerError(): Unit = {
    assertElementText("Sorry, something has gone wrong", findElementByCss("h1"))
        assertElementText(errorContentCaseRef, errorContentAmendCaseRef)
  }

  // ^the user clicks the link to re enter a case ref number they will be on the case ref page
  def whenTheUserClicksTheLinkToReEnterACaseRefNumberTheyWillBeOnTheCaseRefPage(): Unit = {
    clickHref("a[href*='send-documents-for-customs-check/add/case-reference-number']")
        confirmUrl(urlCaseRef)
  }

}
