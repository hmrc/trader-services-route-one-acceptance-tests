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

import org.openqa.selenium.By


trait LandingPage extends BasePage {

  val traderServicesUrl: String = traderServicesBaseUrl
  val landingHeading = "Trader services"

  def clickRouteOneLink(): Unit = driver.findElement(By.linkText("Start a pre-clearance case")).click()

  def clickAddInfo(): Unit = driver.findElement(By.linkText("Add documents or information")).click()

  def clickCheckStatus(): Unit = driver.findElement(By.linkText("Check status")).click()

  //  def overpayments(): Unit = driver.findElement(By.linkText("Apply for a refund"))
  //  def underpayments(): Unit = driver.findElement(By.linkText("Disclose an underpayment"))
  //  def securities(): Unit = driver.findElement(By.linkText("Apply for a refund"))
  //just check handoff (confirm(url))

}
