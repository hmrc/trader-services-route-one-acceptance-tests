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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement

trait FinalConfirmationPage extends BasePage {

val urlConfirmation = traderServicesBaseUrl + "/pre-clearance/confirmation"
  val headingConfirmation = "You've submitted your documents"

  def caseRefNo:WebElement = findElementByCss(".govuk-panel__body > strong:nth-child(2)")

  def subheading1:WebElement = findElementByCss("h2.govuk-heading-m:nth-child(2)")
  def content1:WebElement = findElementByCss("p.govuk-body:nth-child(3)")

 //placeholders
//  def linkPreClearance:Unit = findElementById("")
//  def linkC1Forms:Unit = findElementById("")
}
