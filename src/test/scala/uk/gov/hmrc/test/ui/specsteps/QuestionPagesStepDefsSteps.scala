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

import uk.gov.hmrc.test.ui.specpage.QuestionPages

object QuestionPagesStepDefsSteps extends QuestionPages {

  // ^the user will be on the (.*) Request type page
  def thenTheUserWillBeOnTheXRequestTypePage(journey: String): Unit = {
    journey match {
          case "Import" =>
            confirmUrl(urlImportRequest)
          case "Export" =>
            confirmUrl(urlExportRequest)
        }
  }

  // ^the user is on the Request type page, selects (.*) and continues
  def whenTheUserIsOnTheRequestTypePageSelectsXAndContinues(requestType: String): Unit = {
    requestType match {
          // Import & Export
          case "New"          => clickByCSS("#requestType")
          case "Cancellation" => clickByCSS("#requestType-2")

          // Export Only
          case "Withdrawal" => clickByCSS("#requestType-3")
          case "C1601"      => clickByCSS("#requestType-4")
          case "C1602"      => clickByCSS("#requestType-5")
          case "C1603"      => clickByCSS("#requestType-6")

          case _ =>
        }
        clickContinue()
  }

  // ^the last selected option for (.*) Request should be pre filled with (.*)$
  def thenTheLastSelectedOptionForXRequestShouldBePreFilledWithX(journey: String, request: String): Unit = {
    journey match {
            case "Import" =>
              request match {
                case "New"          => optionSelected("#requestType")
                case "Cancellation" => optionSelected("#requestType-2")
                case _              =>
                  optionNotSelected("#requestType")
                  optionNotSelected("#requestType-2")
              }

            case "Export" =>
              request match {
                case "New"          => optionSelected("#requestType")
                case "Cancellation" => optionSelected("#requestType-2")
                case "C1601"        => optionSelected("#requestType-3")
                case "C1602"        => optionSelected("#requestType-4")
                case "C1603"        => optionSelected("#requestType-5")
                case "Withdrawal"   => optionSelected("#requestType-6")

                case _ =>
                  optionNotSelected("#requestType")
                  optionNotSelected("#requestType-2")
                  optionNotSelected("#requestType-3")
                  optionNotSelected("#requestType-4")
                  optionNotSelected("#requestType-5")
                  optionNotSelected("#requestType-6")
              }
          }
  }

  // ^the user will be on the (.*) Route type page
  def thenTheUserWillBeOnTheXRouteTypePage(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlRouteImport)
          case "Export" => confirmUrl(urlRouteExport)
        }
  }

  // ^the user is on the Route type page, selects (.*) and continues
  def whenTheUserIsOnTheRouteTypePageSelectsXAndContinues(routeType: String): Unit = {
    routeType match {
          case "Route 1"     => clickByCSS("#routeType")
          case "Route 1 CAP" => clickByCSS("#routeType-2")
          case "Route 2"     => clickByCSS("#routeType-3")
          case "Route 3"     => clickByCSS("#routeType-4")
          case "Route 6"     => clickByCSS("#routeType-5")
          case "Hold"        => clickByCSS("#routeType-6")
          case _             =>
        }
        clickContinue()
  }

  // ^the last selected option for Route should be pre filled with (.*)$
  def thenTheLastSelectedOptionForRouteShouldBePreFilledWithX(route: String): Unit = {
    route match {
          case "Route 1"     => optionSelected("#routeType")
          case "Route 1 CAP" => optionSelected("#routeType-2")
          case "Route 2"     => optionSelected("#routeType-3")
          case "Route 3"     => optionSelected("#routeType-4")
          case "Route 6"     => optionSelected("#routeType-5")
          case "Hold"        => optionSelected("#routeType-6")
        }
  }

  // ^the user will be on the (.*) Reason page
  def thenTheUserWillBeOnTheXReasonPage(journey: String): Unit = {
    journey match {
          case "Import" => confirmUrl(urlReasonImport)
          case "Export" => confirmUrl(urlReasonExport)
        }
  }

  // ^the user enters "(.*)" characters in the reason field and continues
  def whenTheUserEntersXCharactersInTheReasonFieldAndContinues(response: String): Unit = {
    response match {
          case "too many" => writeById(textInputNew, randomString(1001))
          case "valid"    => writeById(textInputNew, randomString(1000))
          case "no"       => writeById(textInputNew, randomString(0))
          case _          => writeById(textInputNew, response)
        }
        clickContinue()
  }

  // ^the details in the reason text box should be pre-filled with "(.*)"$
  def thenTheDetailsInTheReasonTextBoxShouldBePreFilledWithX(text: String): Unit = {
    verifyInput(textInputNew, text)
  }

  // ^the user will be on the (.*) Transport type page
  def thenTheUserWillBeOnTheXTransportTypePage(journey: String): Unit = {
    journey match {
          case "Import" =>
            confirmUrl(urlTransportImport)

          case "Export" =>
            confirmUrl(urlTransportExport)
        }
  }

  // ^the user is on the Transport type page, selects (.*) and continues
  def whenTheUserIsOnTheTransportTypePageSelectsXAndContinues(requestType: String): Unit = {
    requestType match {
          case "Air"          => clickByCSS("#freightType")
          case "Maritime"     => clickByCSS("#freightType-2")
          case "RoadRoRoRail" => clickByCSS("#freightType-3")
          case _              =>
        }
        clickContinue()
  }

  // ^the last selected option for Transport type should be pre filled with (.*)$
  def thenTheLastSelectedOptionForTransportTypeShouldBePreFilledWithX(transport: String): Unit = {
    transport match {
          case "Air"          => optionSelected("#freightType")
          case "Maritime"     => optionSelected("#freightType-2")
          case "RoadRoRoRail" => optionSelected("#freightType-3")
        }
  }

  // ^the user will be on the ALVS page$
  def thenTheUserWillBeOnTheALVSPage(): Unit = {
    confirmUrl(urlALVS)
  }

  // ^the user is on the ALVS page, selects (.*) and continues
  def whenTheUserIsOnTheALVSPageSelectsXAndContinues(yesNo: String): Unit = {
    yesNo match {
          case "Yes" => clickByCSS("#hasALVS")
          case "No"  => clickByCSS("#hasALVS-2")
          case _     =>
        }
        clickContinue()
  }

  // ^the last selected option for ALVS should be pre filled with (.*)$
  def thenTheLastSelectedOptionForALVSShouldBePreFilledWithX(alvs: String): Unit = {
    alvs match {
          case "Yes" => optionSelected("#hasALVS")
          case "No"  => optionSelected("#hasALVS-2")
        }
  }

}
