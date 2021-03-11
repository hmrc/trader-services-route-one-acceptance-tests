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
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadMultiPages}


class UploadMultiStepDefs extends BasePage with UploadMultiPages with ScalaDsl with EN {

  Then("""^the user is on the multi-file upload pages for a/an (.*) journey"""){ (page:String) =>
    verifyHeading(headingUpload)

    page match {
      case "New" => confirmUrl(urlUploadMulti)
      case "Amend" => confirmUrl(urlUploadMultiAmend)
    }
  }

  Then("""^the user clicks the button to add another document"""){ () =>
   uploadAnother()
  }

  Then("""^the user clicks the button to upload the (.*) file and selects the "([^"]*)" file"""){ (fileOrder:String, file:String) =>
    Thread.sleep(250l)

    fileOrder match {
      case "first" =>     uploadFile1(file)
      case "second" =>    uploadFile2(file)
      case "third" =>     uploadFile3(file)
      case "fourth" =>     uploadFile4(file)
      case "fifth" =>    uploadFile5(file)
      case "sixth" =>     uploadFile6(file)
      case "seventh" =>     uploadFile7(file)
      case "eighth" =>    uploadFile8(file)
      case "ninth" =>     uploadFile9(file)
      case "tenth" =>     uploadFile10(file)
    }
  }

  And("""^the user clicks Continue when files have finished uploading""") { () =>
    clickUploadContinueMFU()
    if(findElementByCss(".file-upload__spinner").isDisplayed.equals(true)) {
      notFindElementByCss(".file-upload__spinner")
      clickUploadContinueMFU()}
    else {findElementByCss(".file-upload__spinner").isDisplayed.equals(false)}
    }

  And("""^the user will only see inset text for request type (.*)""") { (exportRq:String) =>

    exportRq match {
      case "C1601" => assertElementTextContains("For this export, you must upload form C1601 - Presentation of goods for export (arrival). You can include other supporting documents too.", insetText)
      case "C1602" => assertElementTextContains("For this export, you must upload form C1602 - Notification of exit of goods (departure). You can include other supporting documents too.", insetText)
      case "C1603" => assertElementTextContains("For this export, you must upload form C1603 - Notification of retrospective arrival. You can include other supporting documents too.", insetText)
      case "N/A" => assertElementIsNotVisibleById("govuk-inset-text")
    }
  }
  }
