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

package uk.gov.hmrc.test.ui.cucumber.runner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith
import org.junit.{AfterClass, BeforeClass}
import uk.gov.hmrc.test.ui.conf.Configuration
import uk.gov.hmrc.test.ui.pages.BasePage

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.test.ui.cucumber.stepdefs"),
  plugin = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = "@accessibility"
)
class AccessibilityRunner

object AccessibilityRunner extends AccessibilityRunner with BasePage {
  @BeforeClass
  def setupUser(): Unit = {
    navigateTo(Configuration.settings.SIGN_IN_PAGE)
    login()
    createUser()
    clickByCSS("#update")
  }

  @AfterClass
  def destroyUser(): Unit = {
    navigateTo("http://localhost:9099/agents-external-stubs/")
    if (destroyPlanetLink.isDisplayed.equals(true)){destroyPlanetLink.click()}
    else clickByCSS("#destroy-planet")
    driver.switchTo().alert().accept()
  }
}
