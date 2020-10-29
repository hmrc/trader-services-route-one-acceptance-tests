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
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadPages}


class UploadStepDefs extends BasePage with UploadPages with ScalaDsl with EN {


  Then("""^the user is on the (.*) upload page"""){ (page:String) =>

    confirmUrl(urlUpload)

    page match {
      case "First" => verifyHeading(headingUpload)
      case "Another" => verifyHeading(headingUploadAnother)
    }
  }

  //Step here to confirm prog disc content once implemented

  Then("""^the user clicks the button to upload and selects "([^"]*)" file"""){ (file:String) =>
    clickByCSS(".govuk-button")
    uploadFile(file)
    Thread.sleep(1000L)
    clickContinue()
  }

  Then("""^the user should be on the file upload confirmation page after uploading (.*) document/s"""){
    (docAmount:String) =>
      confirmUrl(urlUploaded)

      docAmount match {
        case "1"=> verifyHeading(headingUploadConfirm1)
        case "2"=> verifyHeading(headingUploadConfirm2)
        case "3"=> verifyHeading(headingUploadConfirm3)
      }
  }

  Then("""^the user should see their first uploaded doc (.*) on upload review page$""") { (Answer: String) =>
    findElementByCss("div.govuk-summary-list__row:nth-child(1) > dt:nth-child(1)").isDisplayed
    findElementByCss("div.govuk-summary-list__row:nth-child(1) > dd:nth-child(2)").getText shouldBe Answer
  }

  When("""^the user clicks the button to remove a document$""") { () =>
  clickHref("a[href*='remove']")
  }

  Then("""^the user should see the message saying they have uploaded the max amount of docs""") { () =>
    assertElementText("You have uploaded the maximum number of files and cannot add any more.",
    findElementByCss("p.govuk-body"))
  }

  Then("""^the user selects (.*) to to uploading another file""") { (yesNo: String) =>
    yesNo match {
      case "Yes" => clickByCSS("#uploadAnotherFile")
      case "No" => clickByCSS("#uploadAnotherFile-2")
    }
    clickContinue()
  }
}

// Stepdef for checking file verification page (inaccessible via standard upscan stub)
//  Then("""^the user should be on the (.*) file uploading page"""){(uploadNo:String) =>
//
//    uploadNo match {
//      case "first" => verifyHeading (headingUpload)
//      case _ => verifyHeading(headingUploadAnother)
//    }
//
//    confirmUrl(urlUploadVer)
//    assertElementText("We are checking your file, please wait",
//      driver.findElement(By.cssSelector(".govuk-heading-m")))
//
//    driver.findElement(By.cssSelector(".ccms-loader"))
//
//    assertElementIsNotVisibleById(".ccms-loader")
//
//  }