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
import uk.gov.hmrc.test.ui.pages.{BasePage, UploadPages}


class UploadStepDefs extends BasePage with UploadPages with ScalaDsl with EN {


  Then("""^the user is on the initial upload page"""){ () =>
    confirmUrl(urlUpload)
    verifyHeading(headingUpload)
  }

  //Step here to confirm prog disc content

  Then("""^the user clicks the button to upload and selects "([^"]*)" file"""){ (file:String) =>
    clickByCSS(".govuk-button")
    uploadFile(file)
    Thread.sleep(1000L)
    clickContinue()
  }

  When("""^the user should be on the (.*) file uploading page"""){(uploadNo:String) =>

    uploadNo match {
      case "first" => verifyHeading (headingUpload)
      case _ => verifyHeading(headingUploadAnother)
    }

    confirmUrl(urlUploadConfirm)
    assertElementText("We are checking your file, please wait",
      driver.findElement(By.cssSelector(".govuk-heading-m")))

    driver.findElement(By.cssSelector(".ccms-loader"))

    assertElementIsNotVisibleById(".ccms-loader")

  }

  Then("""^the user should be on the file upload confirmation page"""){() =>
    confirmUrl(urlUploadConfirm)
    verifyHeading(headingUploadConfirm)
  }

  And("""^the user chooses to upload another document and selects the "([^"]*)" file"""){(file:String) =>
    uploadAnother()
    uploadFile(file)
  }
}
