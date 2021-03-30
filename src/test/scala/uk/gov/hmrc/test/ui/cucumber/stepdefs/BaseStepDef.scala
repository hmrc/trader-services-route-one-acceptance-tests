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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebElement
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.{BasePage, EntryDetailsPage, TransportQuestionsPage}
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

class BaseStepDef extends BasePage with ScalaDsl with EN with BrowserDriver with Eventually
  with Matchers with EntryDetailsPage with TransportQuestionsPage {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }

  And("""^the user clicks continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks SFU upload""") { () =>
    clickByCSS(".file-upload__submit")
  }

  And("""^the user clicks MFU continue""") { () =>
    clickUploadContinueMFU()
  }

  And("""^the user clicks submit on the CYA page""") { () =>
    Thread.sleep(750)
    clickCYAContinue()
  }

  And("""^the user waits (.*)""") { (millis: Int) =>
    Thread.sleep(millis)
  }

  And("""^the user clicks back""") { () =>
    clickBack()
  }

  When("""^the user navigates to the following "(.*)"""") { (url: String) =>
    navigateTo(traderServicesBaseUrl + url)
  }

  When("""^the user logs into QA""") {
    navigateTo("https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in")
    writeById(findElementById("redirectionUrl"), "/send-documents-for-customs-check")
    clickByCSS("#inputForm > div.form-field-group > p > input")
  }

  Then("""^the user enters today's date for (.*)$""") { (dateField: String) =>
    dateField match {

      case "entryDate" =>
        writeById(entryDay, day)
        writeById(entryMonth, month)
        writeById(entryYear, year)

      case "transportDateArrival" =>
        writeById(transportQArrivalDay, day)
        writeById(transportQArrivalMonth, month)
        writeById(transportQArrivalYear, year)

      case "transportDateDeparture" =>
        writeById(transportQDepartureDay, day)
        writeById(transportQDepartureMonth, month)
        writeById(transportQDepartureYear, year)
    }
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") { (dateField: String) =>
    dateField match {

      case "entryDate" =>
        verifyInput(entryDay, dayFormatted)
        verifyInput(entryMonth, monthFormatted)
        verifyInput(entryYear, year)

      case "transportDateArrival" =>
        verifyInput(transportQArrivalDay, dayFormatted)
        verifyInput(transportQArrivalMonth, monthFormatted)
        verifyInput(transportQArrivalYear, year)

      case "transportDateDeparture" =>
        verifyInput(transportQDepartureDay, dayFormatted)
        verifyInput(transportQDepartureMonth, monthFormatted)
        verifyInput(transportQDepartureYear, year)
    }
  }

  //Error checking
  def errorSummaryTitle: WebElement = findElementByCss("#error-summary-title")

  def errorSummaryField(fieldTitle: String): WebElement = findElementById(s"$fieldTitle-error")

  val errorSummary = "There is a problem"

  Then("""^the user should see "([^"]*)" error message for "([^"]*)"$""") { (errorMessage: String, fieldTitle: String) =>

    errorSummaryTitle.isDisplayed
    errorSummaryTitle.getText shouldBe errorSummary

    errorSummaryField(fieldTitle).isDisplayed
    errorSummaryField(fieldTitle).getText.replaceAll("\n", "") shouldBe errorMessage
  }

  And("""^the user should see the invalid (.*) date range error message for "(.*)" field""") {
    (journey: String, fieldTitle: String) =>
      errorSummaryTitle.isDisplayed
      errorSummaryTitle.getText shouldBe errorSummary
      errorSummaryField(fieldTitle).isDisplayed

      journey match {
        case "arrival" =>
          errorSummaryField(fieldTitle).getText should startWith("Error:\nDate of arrival must be between")

        case "departure" =>
          errorSummaryField(fieldTitle).getText should startWith("Error:\nDate of departure must be between")
      }
  }

  When("""^the user clicks the error link for "([^"]*)" it should link to the (.*) field""") {
    (fieldID: String, fieldBodyID: String) =>
      clickHref(s"a[href*='$fieldID']")
      findElementById(fieldBodyID).isSelected
      findElementById(fieldBodyID).clear()
  }
}


