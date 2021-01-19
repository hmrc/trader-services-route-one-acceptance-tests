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

trait AmendCYAPage extends BasePage with DeclarationNumPage with QuestionPages {

  val urlAmendCYA: String = traderServicesBaseUrl + "/add/check-your-answers"
  val headingMainCYA = "Review your case details"

  def verifyH2DecInfo(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(2)").getText shouldBe text
  def verifyH2AddInfo(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(4)").getText shouldBe text
  def verifyH2Documents(text: String): Unit = findElementByCss("h2.govuk-heading-l:nth-child(6)").getText shouldBe text


  val h2Dec = "Declaration information"
  val decInfoSummary = "Case reference number"

  val h2Additional = "Additional information"
  val additionalInfoType = "Information type"

  val messageOnly = "Message"
  val uploadOnly = "Documents"
  val messageAndUpload= "Message and documents"

  val h2Documents = "Documents you are submitting"
  val documentsInfo = "File names"

  def caseRefRow:WebElement = findElementByCss("/html/body/div/main/div/div/div/dl[1]/div/dt")
  def caseRefAnswer:WebElement = findByXpath("/html/body/div/main/div/div/div/dl[1]/div/dd[1]")

  def infoTypeRow:WebElement = findByXpath("/html/body/div/main/div/div/div/dl[2]/div[1]/dt")
  def infoTypeAnswer:WebElement = findByXpath("/html/body/div/main/div/div/div/dl[2]/div[1]/dd[1]")

  def messageRow:WebElement = findByXpath("/html/body/div/main/div/div/div/dl[2]/div[2]/dt")
  def messageAnswer:WebElement = findByXpath("/html/body/div/main/div/div/div/dl[2]/div[2]/dd[1]")

  def uploadRow: WebElement = findByXpath("/html/body/div/main/div/div/div/dl[3]/div/dt")
  def uploadAnswer: WebElement = findByXpath("/html/body/div/main/div/div/div/dl[3]/div/dd[1]")

}





