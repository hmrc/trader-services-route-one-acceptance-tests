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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement

trait AmendPages extends BasePage {

  val urlCaseRef: String = traderServicesBaseUrl + amendUrl + "/case-reference-number"
  val caseRefHeading: String = "What’s the case reference number?"

  def caseRefInput: WebElement = findElementByCss("#caseReferenceNumber")

  def caseRefReveal: WebElement = findElementByCss(".govuk-details__summary-text")

  val urlHowToSend: String = traderServicesBaseUrl + amendUrl + "/type-of-amendment"
  val howToSendHeading: String = "How do you want to send us more information?"

  val urlWriteResponse: String = traderServicesBaseUrl + amendUrl + "/write-response"
  val writeResponseHeading: String = "Write a response to a query from HMRC"

  def textInput: WebElement = findElementByCss("#responseText")

}
