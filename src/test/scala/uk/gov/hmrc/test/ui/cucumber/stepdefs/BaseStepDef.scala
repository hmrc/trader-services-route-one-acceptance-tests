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
import org.openqa.selenium.By
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.{BasePage, DeclarationNumPage, VesselQuestionsPage}
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

class BaseStepDef extends BasePage with ScalaDsl with EN with BrowserDriver with Eventually
  with Matchers with DeclarationNumPage with VesselQuestionsPage {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }

  And("""^the user clicks Continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks Submit on the CYA page""") { () =>
   clickCYAContinue()
  }

  And("""^the user clicks only clicks Continue when it's clickable""") { () =>
    //to be replaced & altered
    Thread.sleep(3000)
    clickUploadContinue()
  }

  And("""^the user waits""") { () =>
    Thread.sleep(7000l)
  }

  And("""^the user clicks back""") { () =>
    clickBack()
  }

  And("""^the user clicks the sign out button they will be redirected to the exit survey feedback form""") { () =>
    clickSignOut()
    confirmUrl(exitSurvey)
  }

  When("""^the user navigates to the following (.*)""") { (url: String) =>
    navigateTo(traderServicesBaseUrl + url)
  }

  Then("""^the user enters today's date for (.*)$""") { (dateField: String) =>
    dateField match {

      case "entryDate" =>
        writeById(entryDay, todayDate.getDayOfMonth.toString)
        writeById(entryMonth, todayDate.getMonthValue.toString)
        writeById(entryYear, todayDate.getYear.toString)

      case "vesselDateArrival" =>
        writeById(vesselQArrivalDay, todayDate.getDayOfMonth.toString)
        writeById(vesselQArrivalMonth, todayDate.getMonthValue.toString)
        writeById(vesselQArrivalYear, todayDate.getYear.toString)

      case "vesselDateDeparture" =>
        writeById(vesselQDepartureDay, todayDate.getDayOfMonth.toString)
        writeById(vesselQDepartureMonth, todayDate.getMonthValue.toString)
        writeById(vesselQDepartureYear, todayDate.getYear.toString)
    }
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") {
    (dateField: String) =>

      dateField match {

        case "entryDate" =>
          if (todayDate.getDayOfMonth <= 9) {
            verifyInput(entryDay, todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
          } else
            verifyInput(entryDay, todayDate.getDayOfMonth.toString)

          if (todayDate.getMonthValue <= 9) {
            verifyInput(entryMonth, todayDate.getMonthValue.toString.replaceFirst("", "0"))
          } else
            verifyInput(entryMonth, todayDate.getMonthValue.toString)

          verifyInput(entryYear, todayDate.getYear.toString)

        case "vesselDateArrival" =>
          if (todayDate.getDayOfMonth <= 9) {
            verifyInput(vesselQArrivalDay, todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
          } else
            verifyInput(vesselQArrivalDay, todayDate.getDayOfMonth.toString)

          if (todayDate.getMonthValue <= 9) {
            verifyInput(vesselQArrivalMonth, todayDate.getMonthValue.toString.replaceFirst("", "0"))
          } else
            verifyInput(vesselQArrivalMonth, todayDate.getMonthValue.toString)

          verifyInput(vesselQArrivalYear, todayDate.getYear.toString)


        case "vesselDateDeparture" =>
           if (todayDate.getDayOfMonth <= 9) {
              verifyInput(vesselQDepartureDay, todayDate.getDayOfMonth.toString.replaceFirst("", "0"))} else
              verifyInput(vesselQDepartureDay, todayDate.getDayOfMonth.toString)

          if (todayDate.getMonthValue <= 9) {
              verifyInput(vesselQDepartureMonth, todayDate.getMonthValue.toString.replaceFirst("", "0"))} else
              verifyInput(vesselQDepartureMonth, todayDate.getMonthValue.toString)

            verifyInput(vesselQDepartureYear, todayDate.getYear.toString)

  }
  }

  Then("""^the user should see "([^"]*)" error message for "([^"]*)"$""") { (errorMessage: String, fieldTitle: String) =>

    driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
    driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).getText.replaceAll("\n", "") shouldBe errorMessage
  }


  And("""^the user should see the invalid (.*) date range error message for "(.*)" field""") {
    (journey: String, fieldTitle: String) =>
      driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
      driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

      driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed

      journey match {
        case "arrival" =>
      driver.findElement (By.id (s"$fieldTitle-error") ).getText should startWith ("Error:\nDate of arrival must be between")

        case "departure" =>
          driver.findElement (By.id (s"$fieldTitle-error") ).getText should startWith ("Error:\nDate of departure must be between")
      }
  }

  When("""^the user clicks the error link for "([^"]*)" it should link to the (.*) field""") {
    (fieldID: String, fieldBodyID:String) =>
    clickHref(s"a[href*='$fieldID']")
      findElementById(fieldBodyID).isSelected
      findElementById(fieldBodyID).clear()
    }

  When("""^the user logs into QA""") {
    navigateTo("https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in")
    writeById(findElementById("redirectionUrl"), "/send-documents-for-customs-check")
    clickByCSS("#inputForm > div.form-field-group > p > input")
  }
  }


