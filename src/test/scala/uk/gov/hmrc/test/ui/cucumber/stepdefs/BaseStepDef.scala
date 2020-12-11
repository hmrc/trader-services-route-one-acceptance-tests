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

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
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
      val actions = new Actions(driver)
      val continue = driver.findElement(By.cssSelector(".govuk-button"))
      actions.moveToElement(continue).perform()
      clickContinue()
  }

//
//  And("""^the user clicks Continue""") { () =>
//    val action = new Actions(driver)
//    action.moveToElement(findElementByCss(".govuk-button")).click()
//
//  }


  And("""^the user clicks Continue and waits""") { () =>
    clickContinue()
    Thread.sleep(1500L)
  }

  And("""^the user clicks back""") { () =>
    clickBack()
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

      case "vesselDate" =>
        writeById(vesselQDay, todayDate.getDayOfMonth.toString)
        writeById(vesselQMonth, todayDate.getMonthValue.toString)
        writeById(vesselQYear, todayDate.getYear.toString)
    }
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") {
    (dateField: String) =>

      if (todayDate.getDayOfMonth <= 9) {
        dateField match {

          case "entryDate" =>
            verifyInput(entryDay, todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
            verifyInput(entryMonth, todayDate.getMonthValue.toString)
            verifyInput(entryYear, todayDate.getYear.toString)

          case "vesselDate" =>
            verifyInput(vesselQDay, todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
            verifyInput(vesselQMonth, todayDate.getMonthValue.toString)
            verifyInput(vesselQYear, todayDate.getYear.toString)

        }
      }
      else {
        dateField match {
          case "entryDate" =>
            verifyInput(entryDay, todayDate.getDayOfMonth.toString)
            verifyInput(entryMonth, todayDate.getMonthValue.toString)
            verifyInput(entryYear, todayDate.getYear.toString)

          case "vesselDate" =>
            verifyInput(vesselQDay, todayDate.getDayOfMonth.toString)
            verifyInput(vesselQMonth, todayDate.getMonthValue.toString)
            verifyInput(vesselQYear, todayDate.getYear.toString)
        }
      }
  }

  Then("""^the user should see "([^"]*)" error message for "([^"]*)"$""") { (errorMessage: String, fieldTitle: String) =>

    driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
    driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).getText.replaceAll("\n", "") shouldBe errorMessage
  }


  And("""^the user should see the invalid date range error message for "(.*)" field""") { (fieldTitle: String) =>
    driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
    driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).getText should startWith("Error:\nDate of arrival must be between")
  }

  When("""^the user clicks the error link for "([^"]*)" it should link to the (.*) field""") {
    (fieldID: String, fieldBodyID:String) =>
    clickHref(s"a[href*='$fieldID']")
      findElementById(fieldBodyID).isSelected
      findElementById(fieldBodyID).clear()
    }
  }

//  Then("""^the user should see below error messages in below order$""") { dataTable: DataTable =>
//
//    dataTable.asMaps(classOf[String], classOf[String]).asScala.foreach { data =>
//      val fieldname: String = data.get("FieldValue")
//      //println("***** field name:   "  +fieldname)
//      val value: String = data.get("ExpectedValue")
//      //  println("***** expectedValue:  "  +value)
//      val pageValue: String = driver.findElement(By.id(s"$fieldname-error-summary")).getText
//      //  println("***** pageValue:  "  +pageValue)
//      assert(value == pageValue)
//    }
//  }


