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

trait QuestionPages extends BasePage {


  val urlImportRequest: String = traderServicesBaseUrl + "/pre-clearance/import-questions/request-type"
  val headingImportRequest: String = "What type of import request is this?"

  val urlExportRequest: String = traderServicesBaseUrl + "/pre-clearance/export-questions/request-type"
  val headingExportRequest: String = "What type of export request is this?"



  val urlRouteImport: String = traderServicesBaseUrl + "/pre-clearance/import-questions/route-type"
  val urlRouteExport: String = traderServicesBaseUrl + "/pre-clearance/export-questions/route-type"
  val headingRoute: String = "Which route is this?"

  val urlTransportImport: String = traderServicesBaseUrl + ""
  val urlTransportExport: String = traderServicesBaseUrl + ""
  val headingTransport: String = "How is it being transported?"
}
