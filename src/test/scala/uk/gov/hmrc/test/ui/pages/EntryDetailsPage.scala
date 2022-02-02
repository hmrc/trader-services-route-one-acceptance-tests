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

trait EntryDetailsPage extends BasePage {

  val urlEntryDetails: String = traderServicesBaseUrl + "/new/entry-details"
  val headingEntryDetails = "Entry details"

  def EPU: WebElement = findElementById("epu")

  def entryNo: WebElement = findElementById("entryNumber")

  def entryDay: WebElement = findElementById("entryDate.day")

  def entryMonth: WebElement = findElementById("entryDate.month")

  def entryYear: WebElement = findElementById("entryDate.year")
}
