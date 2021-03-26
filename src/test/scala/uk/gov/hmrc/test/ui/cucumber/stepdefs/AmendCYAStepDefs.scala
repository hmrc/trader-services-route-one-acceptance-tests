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
import uk.gov.hmrc.test.ui.pages.{AmendCYAPage, AmendPages, BasePage}

class AmendCYAStepDefs extends AmendPages with AmendCYAPage with BasePage with ScalaDsl with EN {

  Given("""^the user is on the Amend (.*) review page and should see their responses$""") { (journey: String) =>
    confirmUrl(urlAmendCYA)
    verifyHeading(headingMainCYA)
    verifyH2DecInfo(h2Dec)
    assertElementText(additionalInfoType, infoTypeRow)
    assertElementText(userCaseRef, caseRefAnswer)

    journey match {
      case "writeOnly" =>
        verifyH2AddInfo(h2Additional)
        assertElementText(messageOnly, infoTypeAnswer)

      case "uploadOnly" =>
        verifyH2Documents(h2Documents)
        assertElementText(uploadOnly, infoTypeAnswer)
        assertElementText(documentsInfo, uploadRow)

      case "writeAndUpload" =>
        verifyH2AddInfo(h2Additional)
        assertElementText(messageAndUpload, infoTypeAnswer)

        verifyH2Documents(h2Documents)
        assertElementText(documentsInfo, uploadRow)

    }
  }

  When("""^the user clicks the change link on the amend review page for (.*)$""") { (changeLink: String) =>
    changeLink match {

      case "caseRef" => clickHref("a[href*='case-reference-number']")
      case "amendment" => clickHref("a[href*='type-of-amendment']")
      case "message" => clickHref("a[href*='write-response']")
      case "documents" => clickHref("a[href*='upload-files']")
    }
  }

  Then("""^the user should see what they entered as their message "(.*)"$""") { (response: String) =>
    assertElementText(response, messageAnswer)
  }

  Then("""^the user should see what the files they uploaded "(.*)"$""") { (uploads: String) =>
    assertElementTextContains(uploads, uploadAnswer)
  }
}
