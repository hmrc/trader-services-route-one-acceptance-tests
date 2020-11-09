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
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

class BaseStepDef extends BasePage with ScalaDsl with EN with BrowserDriver with Eventually with Matchers {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }

  And("""^the user clicks Continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks back""") { () =>
    clickBack()
  }

  And("""^the user signs out""") { () =>
    signOut
  }

  And("""^the user enters too many characters for (.*)""") { (field:String) =>

    field match {
      case "vesselName" => sendNCharactersById ("vesselName", 129)
      case "fullName" => sendNCharactersById ("contactName", 129)
      case "contactEmail" => sendNCharactersById ("contactEmail", 129)
    }
  }

  Then("""^the user enters today's date for (.*)$""") { (dateField:String) =>
    dateField match {

      case "entryDate" =>
        writeById ("entryDate.day", todayDate.getDayOfMonth.toString)
        writeById ("entryDate.month", todayDate.getMonthValue.toString)
        writeById ("entryDate.year", todayDate.getYear.toString)

      case "vesselDate" =>
        writeById ("dateOfArrival.day", todayDate.getDayOfMonth.toString)
        writeById ("dateOfArrival.month", todayDate.getMonthValue.toString)
        writeById ("dateOfArrival.year", todayDate.getYear.toString)
    }
  }

  Then("""^the details entered for (.*) should be pre filled with today's date$""") {
    (dateField: String) =>
      dateField match {

        case "entryDate" =>
          verifyInput ("entryDate.day", todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
          verifyInput ("entryDate.month", todayDate.getMonthValue.toString)
          verifyInput ("entryDate.year", todayDate.getYear.toString)

        case "vesselDate" =>
          verifyInput ("dateOfArrival.day", todayDate.getDayOfMonth.toString.replaceFirst("", "0"))
          verifyInput ("dateOfArrival.month", todayDate.getMonthValue.toString)
          verifyInput ("dateOfArrival.year", todayDate.getYear.toString)
      }
  }


  Then("""^the user should see "([^"]*)" error message for "([^"]*)"$""") { (errorMessage: String, fieldTitle: String) =>

    driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
    driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).getText.replaceAll("\n", "") shouldBe errorMessage
  }


  And("""^the user should see the invalid date range error message for "(.*)" field""") { (fieldTitle:String) =>
    driver.findElement(By.cssSelector("#error-summary-title")).isDisplayed
    driver.findElement(By.cssSelector("#error-summary-title")).getText shouldBe "There is a problem"

    driver.findElement(By.id(s"$fieldTitle-error")).isDisplayed
    driver.findElement(By.id(s"$fieldTitle-error")).getText should startWith("Error:\nDate of arrival must be between")
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


