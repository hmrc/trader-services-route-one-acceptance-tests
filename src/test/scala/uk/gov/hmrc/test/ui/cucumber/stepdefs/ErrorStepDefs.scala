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
import uk.gov.hmrc.test.ui.pages._

class ErrorStepDefs extends FinalConfirmationPage with BasePage with TransportQuestionsPage with ContactDetailsPage with
  LandingPage with AmendPages with ScalaDsl with EN {


  And("""^the user enters too many characters for (.*)""") { (field: String) =>

    field match {
      case "transportName" => sendNCharactersById(transportQName, 129)
      case "fullName" => sendNCharactersById(fullName, 129)
      case "contactEmail" => sendNCharactersById(email, 123)
        email.sendKeys("@a.com")
    }
  }

  When("""^the user will be on the duplicate case error page and see their case reference number""") { () =>
    confirmUrl(urlDuplicate)
    verifyHeading(headingDuplicate)
    assertElementTextContains(userCaseRef, findElementByCss("p.govuk-body:nth-child(2)"))
  }

  Then("""^the user will be on the error page for page not found""") { () =>
    verifyHeading("Page not found")
  }

  //Content differs from before and after 4pm
  Then("""^the user will be on the error page for internal server error""") { () =>
    verifyHeading("Sorry, there is a problem with the service")
//    if (openingHours) assertElementText(errorContentText, errorContent)
//    else assertElementText(errorContentOOOText, errorContent)
  }

  Then("""^the user will be on the error page for an amend journey internal server error""") { () =>
    verifyHeading("Sorry, something has gone wrong")
    assertElementText(errorContentCaseRef, errorContentAmendCaseRef)
  }

  When("""^the user clicks the link to re enter a case ref number they will be on the case ref page""") { () =>
    caseRefErrorClickLink()
    confirmUrl(urlCaseRef)
    verifyHeading(caseRefHeading)
  }


  When("""^the user clicks the link on the Page not found page they will be on the start page""") { () =>
    errorClickLink()
    confirmUrl(traderServicesUrl)
    verifyHeading(landingHeading)
  }

  def errorClickLink(): Unit = driver.findElement(By.linkText("Send your documents for a customs check")).click()
  def caseRefErrorClickLink():Unit = clickHref("a[href*='send-documents-for-customs-check/add/case-reference-number']")
}