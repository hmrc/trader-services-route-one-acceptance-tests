/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps

import uk.gov.hmrc.test.ui.specpage.TransportQuestionsPage

object TransportStepDefsSteps extends TransportQuestionsPage {

  // ^the user will be on the (.*) Transport details page$
  def thenTheUserWillBeOnTheXTransportDetailsPage(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlImpMandatoryTransport)
          case "Export" => confirmUrl(urlExpMandatoryTransport)

        }
  }

  // ^the user enters "(.*)" for transport name$
  def thenTheUserEntersXForTransportName(transportName: String): Unit = {
    writeById(transportQName, transportName)
  }

  // ^the user enters a date of (.*) for their transportation "(.*)" "(.*)" "(.*)"$
  def thenTheUserEntersADateOfXForTheirTransportationXXX(journey: String, transportDay: String, transportMonth: String, transportYear: String): Unit = {
    journey match {
            case "Arrival" =>
              writeById(transportQArrivalDay, transportDay)
              writeById(transportQArrivalMonth, transportMonth)
              writeById(transportQArrivalYear, transportYear)

            case "Departure" =>
              writeById(transportQDepartureDay, transportDay)
              writeById(transportQDepartureMonth, transportMonth)
              writeById(transportQDepartureYear, transportYear)
          }
  }

  // ^the user enters a time of (.*) for their transportation "(.*)" "(.*)"$
  def thenTheUserEntersATimeOfXForTheirTransportationXX(journey: String, transportHrs: String, transportMins: String): Unit = {
    journey match {
            case "Arrival" =>
              writeById(transportQArrivalHours, transportHrs)
              writeById(transportQArrivalMinutes, transportMins)

            case "Departure" =>
              writeById(transportQDepartureHours, transportHrs)
              writeById(transportQDepartureMinutes, transportMins)
          }
  }

  // ^the details entered for transport name should be pre filled with "(.*)"$
  def thenTheDetailsEnteredForTransportNameShouldBePreFilledWithX(transportName: String): Unit = {
    verifyInput(transportQName, transportName)
  }

  // ^the details entered for Date of (.*) should be pre filled with (.*), (.*) & (.*)$
  def thenTheDetailsEnteredForDateOfXShouldBePreFilledWithX_Y_AndZ(journey: String, transportDay: String, transportMonth: String, transportYear: String): Unit = {
    journey match {

            case "Arrival" =>
              verifyInput(transportQArrivalDay, transportDay)
              verifyInput(transportQArrivalMonth, transportMonth)
              verifyInput(transportQArrivalYear, transportYear)

            case "Departure" =>
              verifyInput(transportQDepartureDay, transportDay)
              verifyInput(transportQDepartureMonth, transportMonth)
              verifyInput(transportQDepartureYear, transportYear)
          }
  }

  // ^the details entered for Time of (.*) should be pre filled with "(.*)" & "(.*)"$
  def thenTheDetailsEnteredForTimeOfXShouldBePreFilledWithXAndY(journey: String, transportHrs: String, transportMins: String): Unit = {
    journey match {
            case "Arrival" =>
              verifyInput(transportQArrivalHours, transportHrs)
              verifyInput(transportQArrivalMinutes, transportMins)

            case "Departure" =>
              verifyInput(transportQDepartureHours, transportHrs)
              verifyInput(transportQDepartureMinutes, transportMins)

          }
  }

}
