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

trait CheckAnswersPage extends BasePage with DeclarationNumPage with QuestionPages with PriorityPages {

  val urlImportCYA: String = traderServicesBaseUrl + importJourneyUrl + "/check-your-answers"
  val urlExportCYA: String = traderServicesBaseUrl + exportJourneyUrl + "/check-your-answers"

  val headingMainCYA = "Review your pre-clearance case details"

  val h2Dec = "Declaration information"
  val summaryEPU = "EPU number"
  val summaryEntryNo = "Entry number"
  val summaryDate = "Entry date"

  val h2Questions = "Pre-clearance information"
  val summaryImportRequest = "Type of import request"
  val summaryExportRequest = "Type of export request"
  val summaryRoute = "Route"
  val summaryPriorityYN = "Priority goods"
  val summaryPriorityGoods = "Type of priority goods"
  val summaryALVS = "ALVS"
  val summaryTransport = "Type of transport"

  val h2Vessel = "Vessel information"
  val summaryVesselName = "Vessel name"
  val summaryVesselDate = "Date of arrival"
  val summaryVesselTime = "Time of arrival"

  val h2ContactDetails = "Contact details"

  val change = "Change"

  def verifyH2Declaration(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(2)").getText shouldBe text

  def verifyH2Questions(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(4)").getText shouldBe text

  def verifyH2Vessel(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(6)").getText shouldBe text

  def verifyH2Contact(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(8)").getText shouldBe text

//CHANGE links
//
//  def epuChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(3) > div:nth-child(1) > dd:nth-child(3) > a:nth-child(1)")
//  def entryNoChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(3) > div:nth-child(2) > dd:nth-child(3) > a:nth-child(1)")
//  def entryDateChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(3) > div:nth-child(3) > dd:nth-child(3) > a:nth-child(1)")
//
//
//  def requestChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(5) > div:nth-child(1) > dd:nth-child(3) > a:nth-child(1)")
//
//  def routeChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(5) > div:nth-child(2) > dd:nth-child(3) > a:nth-child(1)")
//
//  def PriorityYNChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(5) > div:nth-child(3) > dd:nth-child(3) > a:nth-child(1)")
//
//  def PriorityGoodsChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(5) > div:nth-child(4) > dd:nth-child(3) > a:nth-child(1)")
//  def ALVSChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(5) > div:nth-child(5) > dd:nth-child(3) > a:nth-child(1)")
//  def transportChange:Unit = clickByCSS("div.govuk-summary-list__row:nth-child(5) > dd:nth-child(3) > a:nth-child(1)")
//
//
//  def vesselNameChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(7) > div:nth-child(1) > dd:nth-child(3) > a:nth-child(1))")
//  def dateChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(7) > div:nth-child(2) > dd:nth-child(3) > a:nth-child(1)")
//  def timeChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(7) > div:nth-child(3) > dd:nth-child(3) > a:nth-child(1)")
//
//  def contactChange:Unit = clickByCSS("dl.govuk-summary-list:nth-child(9) > div:nth-child(1) > dd:nth-child(3) > a:nth-child(1)")
//
//
//

}





