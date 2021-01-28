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

trait QuestionPages extends BasePage {


  val urlImportRequest: String = traderServicesBaseUrl + importJourneyUrl + "/request-type"
  val headingImportRequest: String = "What type of import request is this?"

  val urlExportRequest: String = traderServicesBaseUrl + exportJourneyUrl + "/request-type"
  val headingExportRequest: String = "What type of export request is this?"


  val urlRouteImport: String = traderServicesBaseUrl + importJourneyUrl + "/route-type"
  val urlRouteExport: String = traderServicesBaseUrl + exportJourneyUrl + "/route-type"
  val headingRoute: String = "Which route is this declaration for?"

  val urlTransportImport: String = traderServicesBaseUrl + importJourneyUrl + "/transport-type"
  val urlTransportExport: String = traderServicesBaseUrl + exportJourneyUrl + "/transport-type"
  val headingTransport: String = "Which type of transport are you using?"

  //ALVS - Import only
  val urlALVS: String = traderServicesBaseUrl + importJourneyUrl + "/automatic-licence-verification"
  val headingALVS = "Do you use Defra’s Automatic Licence Verification System (ALVS)?"

}
