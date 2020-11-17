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

trait AmendPage extends BasePage {

  val urlCaseRef: String = traderServicesBaseUrl + "/pre-clearance/amend/case-reference-number"
val caseRefHeading: String = "What's the case reference number?"

val urlHowToSend:String = traderServicesBaseUrl + "/pre-clearance/amend/select-how-to-send"
val howToSendHeading:String = ""

  def caseRefInput: WebElement = findElementByCss("#caseReferenceNumber")


//  def linkNCH: WebElement = findElementByCss("p.govuk-body:nth-child(2) > a:nth-child(1)")
  //https://www.gov.uk/government/organisations/hm-revenue-customs/contact/national-clearance-hub
}

//hint -> For example PC12010081330XGBNZJO04