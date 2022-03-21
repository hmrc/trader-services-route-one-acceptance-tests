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

trait TransportQuestionsPage extends BasePage {

  val urlImpMandatoryTransport: String = traderServicesBaseUrl + importJourneyUrl + "/transport-information-required"

  val urlExpMandatoryTransport: String = traderServicesBaseUrl + exportJourneyUrl + "/transport-information-required"

  def transportQName: WebElement = findElementById("vesselName")

  def transportQArrivalDay: WebElement = findElementById("dateOfArrival.day")

  def transportQArrivalMonth: WebElement = findElementById("dateOfArrival.month")

  def transportQArrivalYear: WebElement = findElementById("dateOfArrival.year")

  def transportQDepartureDay: WebElement = findElementById("dateOfDeparture.day")

  def transportQDepartureMonth: WebElement = findElementById("dateOfDeparture.month")

  def transportQDepartureYear: WebElement = findElementById("dateOfDeparture.year")

  def transportQArrivalHours: WebElement = findElementById("timeOfArrival.hour")

  def transportQArrivalMinutes: WebElement = findElementById("timeOfArrival.minutes")

  def transportQDepartureHours: WebElement = findElementById("timeOfDeparture.hour")

  def transportQDepartureMinutes: WebElement = findElementById("timeOfDeparture.minutes")

}
