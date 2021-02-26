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

trait VesselQuestionsPage extends BasePage {

  val urlImportVessel: String = traderServicesBaseUrl + importJourneyUrl + "/transport-information"
  val urlImpMandatoryVessel: String = traderServicesBaseUrl + importJourneyUrl + "/transport-information-required"

  val urlExportVessel: String = traderServicesBaseUrl + exportJourneyUrl + "/transport-information"
  val urlExpMandatoryVessel: String = traderServicesBaseUrl + exportJourneyUrl + "/transport-information-required"

  val headingVessel = "More details about your transport"

  def vesselQName: WebElement = findElementById("vesselName")

  def vesselQArrivalDay: WebElement = findElementById("dateOfArrival.day")
  def vesselQArrivalMonth: WebElement = findElementById("dateOfArrival.month")
  def vesselQArrivalYear: WebElement = findElementById("dateOfArrival.year")

  def vesselQDepartureDay: WebElement = findElementById("dateOfDeparture.day")
  def vesselQDepartureMonth: WebElement = findElementById("dateOfDeparture.month")
  def vesselQDepartureYear: WebElement = findElementById("dateOfDeparture.year")

  def vesselQArrivalHours: WebElement = findElementById("timeOfArrival.hour")
  def vesselQArrivalMinutes: WebElement = findElementById("timeOfArrival.minutes")

  def vesselQDepartureHours: WebElement = findElementById("timeOfDeparture.hour")
  def vesselQDepartureMinutes: WebElement = findElementById("timeOfDeparture.minutes")

}
