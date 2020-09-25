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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.Configuration
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

class BaseStepDef extends BasePage with ScalaDsl with EN with BrowserDriver with Eventually with Matchers {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }

  Given("""^the user attempts to log in$""") { () =>
    navigateTo(Configuration.settings.SIGN_IN_PAGE)
    confirmUrl("")
    verifyHeading("Sign in")
    login()
  }
  Then("""^a user is created""") { () =>
    createUser()
    clickByCSS("#update")
  }

  Then("""^the test data is destroyed$""") { () =>
    destroyUser()
  }

  And("""^the user clicks Continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks Submit""") { () =>
    clickSubmit()
  }

  And("""^the user signs out""") { () =>
    signOut
  }

  Then("""^the user should see "([^"]*)" error message for "([^"]*)" on the page$""") { (errorMessage: String, fieldTitle: String) =>

    driver.findElement(By.id("error-summary-heading")).getText shouldBe "There is a problem"
    driver.findElement(By.id(s"$fieldTitle-error-summary")).getText shouldBe errorMessage
    driver.findElement(By.id(s"$fieldTitle-error")).getText.contains(errorMessage)

    driver.findElement(By.id("error-summary-heading")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error-summary")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed

  }
}
