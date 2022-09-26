/*
 * Copyright 2022 HM Revenue & Customs
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
import org.scalatest.Assertion

trait NewCYAPage extends BasePage {

  val urlImportCYA: String = traderServicesBaseUrl + importJourneyUrl + "/check-your-answers"
  val urlExportCYA: String = traderServicesBaseUrl + exportJourneyUrl + "/check-your-answers"

  def verifyH2EntryDetails(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(2)")

  def verifyH2Questions(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(4)")

  def verifyH2Vessel(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(6)")

  def verifyH2Contact(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(8)")


  //Entry details section

  def verifyEpuRow(): Unit = assert(findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dt").isDisplayed)

  def verifyEpuAnswer(): Unit = assert(findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dd[1]").isDisplayed)

  def verifyEntryNoRow(): Unit = assert(findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dt").isDisplayed)

  def verifyEntryNoAnswer(): Unit = assert(findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dd[1]").isDisplayed)

  def verifyEntryDateRow(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dt:nth-child(1)")

  def verifyEntryDateAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dd:nth-child(2)")


  //Question Section (order may vary)

  //Always request type
  def firstQRow: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dt:nth-child(1)")

  def verifyFirstQAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dd:nth-child(2)")

  //Always route type
  def verifySecondQAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dd:nth-child(2)")

  //Always Priority YN
  def verifyThirdQAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dd:nth-child(2)")

  //The following vary based on journey (exp/imp) & answer to priority goods
  def verifyFourthQAnswer(): Assertion = assertIsVisible("div.govuk-summary-list__row:nth-child(4) > dd:nth-child(2)")

  def verifyFifthQAnswer(): Assertion = assertIsVisible("div.govuk-summary-list__row:nth-child(5) > dd:nth-child(2)")

  //Only accessible in Import & Yes to priority
  def verifySixthQAnswer(): Assertion = assertIsVisible("div.govuk-summary-list__row:nth-child(6) > dd:nth-child(2)")


  //Vessel Section

  def verifySeventhRowFirstAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dd:nth-child(2)")

  def seventhRowSecondQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dt:nth-child(1)")

  def verifySeventhRowSecondAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dd:nth-child(2)")

  def seventhRowThirdQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dt:nth-child(1)")

  def verifySeventhRowThirdAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dd:nth-child(2)")

  //Contact details section

  def verifyEighthRowFirstQ(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dt:nth-child(1)")

  def verifyEighthRowFirstAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(1)")

  def verifyEighthRowSecondAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(2)")

  def verifyEighthRowThirdAnswer(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(3)")

  def verifyContactDetailAnswerEmailOnly(): Assertion = assertIsVisible("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(1)")
}





