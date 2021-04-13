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

import cucumber.api.java.Before
import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.{AfterClass, BeforeClass}
import org.junit.runner.RunWith
import uk.gov.hmrc.extentreport.ExtentProperties.webDriver
import uk.gov.hmrc.test.ui.conf.Configuration
import uk.gov.hmrc.test.ui.cucumber.runner.Runner.{clickByCSS, createUser, destroyPlanetLink, driver, login, navigateTo}
import uk.gov.hmrc.test.ui.pages.BasePage

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.test.ui.cucumber.stepdefs"),
  plugin = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = "@TraderServiceErrors"
)
class RunnerErrors
object RunnerErrors extends Runner with BasePage {

  @Before
  def initialize(): Unit = {
    webDriver.manage().deleteAllCookies()
    webDriver.navigate.refresh()
    webDriver.manage().deleteAllCookies()
  }

  @BeforeClass
  def setupUser(): Unit = {
    navigateTo(Configuration.settings.SIGN_IN_page)
    login()
    createUser()
    clickByCSS("#update")
  }

  @AfterClass
  def destroyUser(): Unit = {
    navigateTo(Configuration.settings.DESTROY_PLANET)
    if (destroyPlanetLink.isDisplayed.equals(true)){destroyPlanetLink.click()} else clickByCSS("#destroy-planet")
    driver.switchTo().alert().accept()
  }
}
