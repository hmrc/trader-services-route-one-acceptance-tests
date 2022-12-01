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

import org.scalatest.Assertion

trait AmendCYAPage extends BasePage with EntryDetailsPage with QuestionPages {

  val urlAmendCYA: String = traderServicesBaseUrl + "/add/check-your-answers"

  def verifyH2DecInfo(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(2)")

  def verifyH2AddInfo(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(4)")

  def verifyH2Documents(): Assertion = assertIsVisible("h2.govuk-heading-l:nth-child(6)")

  def verifyCaseRefAnswer(): Unit = assert(findByXpath("/html/body/div/main/div/div/div/dl[1]/div/dd[1]").isDisplayed)

  def verifyInfoTypeRow(): Unit = assert(findByXpath("/html/body/div/main/div/div/div/dl[2]/div[1]/dt").isDisplayed)

  def verifyInfoTypeAnswer(): Unit = assert(
    findByXpath("/html/body/div/main/div/div/div/dl[2]/div[1]/dd[1]").isDisplayed
  )

  def verifyMessageRow(): Unit = assert(findByXpath("/html/body/div/main/div/div/div/dl[2]/div[2]/dt").isDisplayed)

  def verifyMessageAnswer(): Unit = assert(
    findByXpath("/html/body/div/main/div/div/div/dl[2]/div[2]/dd[1]").isDisplayed
  )

  def verifyUploadRow(): Unit = assert(findByXpath("/html/body/div/main/div/div/div/dl[3]/div/dt").isDisplayed)

  def verifyUploadAnswer(): Unit = assert(findByXpath("/html/body/div/main/div/div/div/dl[3]/div/dd[1]").isDisplayed)

}
