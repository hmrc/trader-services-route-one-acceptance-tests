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

trait PriorityPages extends BasePage {

  val urlImportYNPriority: String = traderServicesBaseUrl + importjourneyUrl + "/has-priority-goods"
  val urlExportYNPriority: String = traderServicesBaseUrl + exportjourneyUrl + "/has-priority-goods"

  val headingImportYNPrio = "Are you importing any priority goods?"
  val headingExportYNPrio = "Are you exporting any priority goods?"

  val urlImportPriority: String = traderServicesBaseUrl + importjourneyUrl + "/which-priority-goods"
  val urlExportPriority: String = traderServicesBaseUrl + exportjourneyUrl + "/which-priority-goods"
  val headingPriority = "Which type of priority goods are you moving?"

}
