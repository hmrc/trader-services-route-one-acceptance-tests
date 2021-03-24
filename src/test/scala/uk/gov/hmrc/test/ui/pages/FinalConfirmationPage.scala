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

import org.openqa.selenium.{By, WebElement}

trait FinalConfirmationPage extends BasePage {

  val urlConfirmation = traderServicesBaseUrl + "/new/confirmation"
  val headingConfirmation = "You’ve submitted your documents"

  val urlDuplicate = traderServicesBaseUrl + "/new/case-already-exists"
  val headingDuplicate = "This case already exists"

  val urlAmendConfirm = traderServicesBaseUrl + amendUrl + "/confirmation"
  val headingAmendConfirm = "You’ve submitted your extra information"

  def clickLinkToAmend(): Unit = driver.findElement(By.linkText("add more information or documents to the existing case")).click()

  def caseRefNo:WebElement = findElementByCss(".govuk-panel__body > strong:nth-child(2)")

  def slaPara:WebElement = findElementByCss("p.govuk-body:nth-child(3)")

  val holdSLA = "When your transportation arrives, we’ll begin the document checks. Once our checks are complete, you’ll hear from us through CHIEF or your declaration software."

//  def linkNCH:Unit = driver.findElement(By.linkText("getting your goods cleared by the National Clearance Hub"))
//  def linkC1Forms:Unit = driver.findElement(By.linkText("arrival and exit when CHIEF is not available"))

}
