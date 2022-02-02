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

trait NewCYAPage extends BasePage {

  val urlImportCYA: String = traderServicesBaseUrl + importJourneyUrl + "/check-your-answers"
  val urlExportCYA: String = traderServicesBaseUrl + exportJourneyUrl + "/check-your-answers"
  val headingMainCYA = "Review your case details"

  def verifyH2EntryDetails(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(2)").getText shouldBe text

  def verifyH2Questions(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(4)").getText shouldBe text

  def verifyH2Vessel(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(6)").getText shouldBe text

  def verifyH2Contact(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(8)").getText shouldBe text


  //Entry details section
  val h2Entry = "Entry information"
  val summaryEPU = "EPU number"
  val summaryEntryNo = "Entry number"
  val summaryEntryDate = "Entry date"

  def epuRow: WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dt")

  def epuAnswer: WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dd[1]")

  def entryNoRow: WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dt")

  def entryNoAnswer: WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dd[1]")

  def entryDateRow: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dt:nth-child(1)")

  def entryDateAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dd:nth-child(2)")


  //Question Section (order may vary)
  val h2Questions = "Customs information"
  val summaryImportRequest = "Type of import request"
  val summaryExportRequest = "Type of export request"
  val summaryRoute = "Route"
  val summaryPriorityYN = "Priority goods"
  val summaryPriorityGoods = "Type of priority goods"
  val summaryALVS = "ALVS"
  val summaryTransport = "Type of transport"

  //Always request type
  def firstQRow: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dt:nth-child(1)")

  def firstQAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dd:nth-child(2)")

  //Always route type
  def secondQRow: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dt:nth-child(1)")

  def secondQAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dd:nth-child(2)")

  //Always Priority YN
  def thirdQRow: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dt:nth-child(1)")

  def thirdQAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dd:nth-child(2)")

  //The following vary based on journey (exp/imp) & answer to priority goods
  def fourthQRow: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(4) > dt:nth-child(1)")

  def fourthQAnswer: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(4) > dd:nth-child(2)")

  def fifthQRow: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(5) > dt:nth-child(1)")

  def fifthQAnswer: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(5) > dd:nth-child(2)")

  //Only accessible in Import & Yes to priority
  def sixthQRow: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(6) > dt:nth-child(1)")

  def sixthQAnswer: WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(6) > dd:nth-child(2)")


  //Vessel Section
  val h2Vessel = "Transport information"
  val summaryTransportName = "Name of ship, vehicle or airline"
  val summaryVesselArrivalDate = "Date of arrival"
  val summaryVesselArrivalTime = "Estimated time of arrival"

  val summaryVesselDepartureDate = "Date of departure"
  val summaryVesselDepartureTime = "Estimated time of departure"

  def seventhRowFirstQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dt:nth-child(1)")

  def seventhRowFirstAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dd:nth-child(2)")

  def seventhRowSecondQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dt:nth-child(1)")

  def seventhRowSecondAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dd:nth-child(2)")

  def seventhRowThirdQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dt:nth-child(1)")

  def seventhRowThirdAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dd:nth-child(2)")

  //Contact details section
  val h2ContactDetails = "Contact details"

  def eighthRowFirstQ: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dt:nth-child(1)")

  def eighthRowFirstAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(1)")

  def eighthRowSecondAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(2)")

  def eighthRowThirdAnswer: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(3)")

  def contactDetailAnswerEmailOnly: WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(1)")
}





