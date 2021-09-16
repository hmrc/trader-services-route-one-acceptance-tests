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
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

class BaseStepDef extends BasePage with ScalaDsl with EN with BrowserDriver with Eventually
  with Matchers with EntryDetailsPage with TransportQuestionsPage with AmendPages with LandingPage {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }

  And("""^the user clicks back""") { () =>
    clickBack()
  }

  And("""^the user clicks continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks submit on the CYA page""") { () =>
    Thread.sleep(750)
    clickContinue()
  }

  And("""^the user waits (.*)""") { (millis: Int) =>
    Thread.sleep(millis)
  }

  And("""^the user clicks the (.*) toggle it should translate the page""") { (language: String) =>
    clickByCSS("  #switch-to-" + s"$language" + "> span:nth-child(2)")

    language match {
      case "cy" => assertElementText("Anfon dogfennau i’w gwirio gan y tollau", bannerServiceName())
      case "en" => assertElementText("Send documents for a customs check", bannerServiceName())
    }
  }

  When("""^the user signs out they will be on the give feedback page""") { () =>
    clickSignOut()
    confirmUrl(giveFeedbackUrl)
  }

  When("""^the user navigates to the following "(.*)"""") { (url: String) =>
    navigateTo(traderServicesBaseUrl + url)
  }

  Then("""^the user will be on the following url "(.*)"""") { (url: String) =>
    confirmUrl(traderServicesBaseUrl + url)
  }

  When("""^the user clicks the (.*) link they will be redirected to the appropriate page$""") { (link: String) =>

    link match {
      case "confirmation feedback" => clickGiveFeedbackConfirmation()
        confirmUrl(giveFeedbackUrl)

      case "amend NCH" => caseRefReveal.click()
        clickNchAmendLink()
        confirmUrl(nchAmendUrl)

      case "confirmation NCH" => clickNchConfirmation()
        confirmUrl(nchConfirmationUrl)

      case "chief unavailable" => clickChiefUnavailable()
        confirmUrl(chiefUnavailableUrl)

      case "gov.uk icon" => clickGovUkIcon()
        confirmUrl(govUkExternal)

      case "service-name" => bannerServiceName().click()
        confirmUrl(traderServicesUrl)

      case "banner feedback" => clickGiveFeedbackBanner()
        confirmUrl(giveFeedbackBannerUrl)

      case "deskpro" => clickDeskProLink()
        switchToNewTab(2)
        confirmUrl(deskProUrl)
        closeNewTab()

      case "UR banner" => clickURLink()
        switchToNewTab(2)
        confirmUrl(urBannerLink)
        closeNewTab()
    }
  }

  When("""^the user logs into QA""") {
    navigateTo("https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in")
    writeById(findElementById("redirectionUrl"), "/send-documents-for-customs-check")
    writeById(findElementById("enrolment[0].name"), "HMRC-CTS-ORG")
    writeById(findElementById("input-0-0-name"), "EoriNumber")
    writeById(findElementById("input-0-0-value"), "GB123456789012345")
    findElementById("submit").click()

  }

  And("""^the user enters today's date for (.*)$""") { (dateField: String) =>
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

  When("""^the user enters an invalid (.*) date for (.*)""") { (date: String, field: String) =>
    date match {

      case "past" =>

        field match {
          case "entryDate" =>
            writeById(entryDay, d6past)
            writeById(entryMonth, m6past)
            writeById(entryYear, y6past)

          case "arrivalDate" =>
            writeById(transportQArrivalDay, yd)
            writeById(transportQArrivalMonth, ym)
            writeById(transportQArrivalYear, yy)

          case "departureDate" =>
            writeById(transportQDepartureDay, yd)
            writeById(transportQDepartureMonth, ym)
            writeById(transportQDepartureYear, yy)

        }

      case "future" =>

        field match {
          case "entryDate" =>
            writeById(entryDay, td)
            writeById(entryMonth, tm)
            writeById(entryYear, ty)

          case "arrivalDate" =>
            writeById(transportQArrivalDay, d6future)
            writeById(transportQArrivalMonth, m6future)
            writeById(transportQArrivalYear, y6future)

          case "departureDate" =>
            writeById(transportQDepartureDay, d6future)
            writeById(transportQDepartureMonth, m6future)
            writeById(transportQDepartureYear, y6future)
        }
    }
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") {
    (dateField: String) =>
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

  Then("""^the user should see "(.*)" error message for "([^"]*)"$""") {
    (errorMessage: String, fieldTitle: String) =>

      errorSummaryTitle.isDisplayed
      errorSummaryTitle.getText shouldBe errorSummary

      errorSummaryField(fieldTitle).isDisplayed

      errorSummaryField(fieldTitle).getText.replaceAll("\n", "") shouldBe errorMessage
  }


  Then("""^the user should see the invalid (.*) date range error message for "(.*)" field""") {
    (journey: String, fieldTitle: String) =>
      errorSummaryTitle.isDisplayed
      errorSummaryTitle.getText shouldBe errorSummary
      errorSummaryField(fieldTitle).isDisplayed

      journey match {
        case "arrival" =>
          errorSummaryField(fieldTitle).getText.replaceAll("\n", "") shouldBe betweenError("arrival")

        case "departure" =>
          errorSummaryField(fieldTitle).getText.replaceAll("\n", "") shouldBe betweenError("departure")
      }
  }

  When("""^the user clicks the error link for "([^"]*)" it should link to the (.*) field""") {
    (fieldID: String, fieldBodyID: String) =>
      clickHref(s"a[href*='$fieldID']")
      findElementById(fieldBodyID).isSelected
      findElementById(fieldBodyID).clear()
  }
}


