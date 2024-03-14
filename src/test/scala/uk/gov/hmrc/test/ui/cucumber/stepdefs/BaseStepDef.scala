/*
 * Copyright 2023 HM Revenue & Customs
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
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.must.Matchers
import uk.gov.hmrc.test.ui.pages._

class BaseStepDef
    extends BasePage
    with ScalaDsl
    with EN
    with Eventually
    with Matchers
    with EntryDetailsPage
    with TransportQuestionsPage
    with AmendPages
    with LandingPage {

  And("""^the user clicks back""") { () =>
    clickBack()
  }

  And("""^the user clicks continue""") { () =>
    clickContinue()
  }

  And("""^the user clicks submit on the CYA page""") { () =>
    clickContinue()
  }


  And("""^the user clicks the (.*) toggle it should translate the page""") { (language: String) =>
    clickByCSS("  #switch-to-" + s"$language" + "> span:nth-child(2)")

    language match {
      case "cy" => assertElementText("Anfon dogfennau i’w gwirio gan y tollau", bannerServiceName())
      case "en" => assertElementText("Send documents for a customs check", bannerServiceName())
    }
  }

  When("""^the user navigates to the following "(.*)"""") { (url: String) =>
    navigateTo(traderServicesBaseUrl + url)
  }

  Then("""^the user will be on the following url "(.*)"""") { (url: String) =>
    confirmUrl(traderServicesBaseUrl + url)
  }

  When("""^the user clicks the (.*) link they will be redirected to the appropriate page$""") { (link: String) =>
    link match {
      case "confirmation feedback" =>
        clickGiveFeedbackConfirmation()
        confirmUrl(giveFeedbackUrl)

      case "amend NCH" =>
        caseRefReveal.click()
        clickNchAmendLink()
        confirmUrl(nchAmendUrl)

      case "confirmation NCH" =>
        clickNchConfirmation()
        confirmUrl(nchConfirmationUrl)

      case "chief unavailable" =>
        clickChiefUnavailable()
        confirmUrl(chiefUnavailableUrl)

      case "gov.uk icon" =>
        clickGovUkIcon()
        confirmUrl(govUkExternal)

      case "service-name" =>
        bannerServiceName().click()
        confirmUrl(traderServicesUrl)

      case "banner feedback" =>
        clickGiveFeedbackBanner()
        confirmUrl(giveFeedbackBannerUrl)
    }
  }

  When("""^the user logs into Staging""") {
    navigateTo("https://www.staging.tax.service.gov.uk/auth-login-stub/gg-sign-in")
    writeById(findElementById("redirectionUrl"), "/send-documents-for-customs-check")
    writeById(findElementById("enrolment[0].name"), "HMRC-CTS-ORG")
    writeById(findElementById("input-0-0-name"), "EoriNumber")
    writeById(findElementById("input-0-0-value"), "GB123456789012345")
    findElementById("submit").click()
    login()

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
}
