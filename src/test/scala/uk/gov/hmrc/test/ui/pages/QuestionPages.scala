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

trait QuestionPages extends BasePage {

  val urlImport: String = traderServicesBaseUrl + "/trader-services/imports"
  val urlExport: String = traderServicesBaseUrl + "/trader-services/exports"

  val headingImport = "Tell us about your imports"
  val headingExport = "Tell us about your exports"

  //Import

  def requestNew: WebElement = findElementById("")
  def requestCancel: WebElement = findElementById("")
  def requestHold: WebElement = findElementById("")
  def requestALVS: WebElement = findElementById("")

  //Export (Including New, Cancel, Hold as above)
  def requestC1601: WebElement = findElementById("")
  def requestC1602: WebElement = findElementById("")
  def requestC1603: WebElement = findElementById("")
  def requestWithdrawal: WebElement = findElementById("")

  //Same for both
  def route1: WebElement = findElementById("")
  def route1CAP: WebElement = findElementById("")
  def route2: WebElement = findElementById("")
  def route3: WebElement = findElementById("")
  def route6: WebElement = findElementById("")
  def routeHold: WebElement = findElementById("")

  //Same for both
  def priorityNone: WebElement = findElementById("")
  def priorityLiveAnimals: WebElement = findElementById("")
  def priorityHumanRemains: WebElement = findElementById("")
  def priorityExplosives: WebElement = findElementById("")
  def priorityArt: WebElement = findElementById("")
  def priorityClassA: WebElement = findElementById("")

  //Import only
  def freightMaritime: WebElement = findElementById("")
  def freightAir: WebElement = findElementById("")
  def freightRoadRoRoRail: WebElement = findElementById("")

}
