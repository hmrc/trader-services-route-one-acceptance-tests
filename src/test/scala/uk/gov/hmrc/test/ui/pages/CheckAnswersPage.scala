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

trait CheckAnswersPage extends BasePage with DeclarationNumPage with QuestionPages with PriorityPages {

  val urlImportCYA: String = traderServicesBaseUrl + importJourneyUrl + "/check-your-answers"
  val urlExportCYA: String = traderServicesBaseUrl + exportJourneyUrl + "/check-your-answers"
  val headingMainCYA = "Review your pre-clearance case details"

  def verifyH2Declaration(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(2)").getText shouldBe text
  def verifyH2Questions(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(4)").getText shouldBe text
  def verifyH2Vessel(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(6)").getText shouldBe text
  def verifyH2Contact(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(8)").getText shouldBe text


  //Declaration detail section
  val h2Dec = "Declaration information"
  val summaryEPU = "EPU number"
  val summaryEntryNo = "Entry number"
  val summaryEntryDate = "Entry date"

  def epuRow:WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dt")
  def epuAnswer:WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dd[1]")

  def entryNoRow:WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dt")
  def entryNoAnswer:WebElement = findByXpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dd[1]")

  def entryDateRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dt:nth-child(1)")
  def entryDateAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dd:nth-child(2)")


  //Question Sections (order may vary.....)
  val h2Questions = "Pre-clearance information"
  val summaryImportRequest = "Type of import request"
  val summaryExportRequest = "Type of export request"
  val summaryRoute = "Route"
  val summaryPriorityYN = "Priority goods"
  val summaryPriorityGoods = "Type of priority goods"
  val summaryALVS = "ALVS"
  val summaryTransport = "Type of transport"

  def requestRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dt:nth-child(1)")
  def requestAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dd:nth-child(2)")

  def routeRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dt:nth-child(1)")
  def routeAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dd:nth-child(2)")

  def priorityYNRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dt:nth-child(1)")
  def priorityYNAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dd:nth-child(2)")

  //if yes ->
  def priorityGoodsRow:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(4) > dt:nth-child(1)")
  def priorityGoodsAnswer:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(4) > dd:nth-child(2)")
  //if NO then the above will become the ALVS row, and the ALVS row will become the transport row

  def ALVSRow:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(5) > dt:nth-child(1)")
  def ALVSAnswer:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(5) > dd:nth-child(2)")

  def transportRow:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(6) > dt:nth-child(1)")
  def transportAnswer:WebElement = findElementByCss("div.govuk-summary-list__row:nth-child(6) > dd:nth-child(2)")

  //Best way to sort? Numbers?


  //Vessel Section
  val h2Vessel = "Vessel information"
  val summaryVesselName = "Vessel name"
  val summaryVesselDate = "Date of arrival"
  val summaryVesselTime = "Time of arrival"

  def vesselNameRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dt:nth-child(1)")
  def vesselNameAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dd:nth-child(2)")

  def vesselDateRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dt:nth-child(1)")
  def vesselDateAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dd:nth-child(2)")

  def vesselTimeRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dt:nth-child(1)")
  def vesselTimeAnswer:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dd:nth-child(2)")

//Contact details section
  val h2ContactDetails = "Contact details"

  def contactDetailRow:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dt:nth-child(1)")
  def contactDetailAnswerName:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(1)")
  def contactDetailAnswerEmail:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(2)")
  def contactDetailAnswerPhone:WebElement = findElementByCss("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(2) > div:nth-child(3)")
}





