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

  def vesselQDay: WebElement = findElementById("dateOfArrival.day")
  def vesselQMonth: WebElement = findElementById("dateOfArrival.month")
  def vesselQYear: WebElement = findElementById("dateOfArrival.year")

  def vesselQHours: WebElement = findElementById("timeOfArrival.hour")
  def vesselQMinutes: WebElement = findElementById("timeOfArrival.minutes")

}
