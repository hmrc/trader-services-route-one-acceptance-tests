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

import uk.gov.hmrc.test.ui.specpage.{AmendCYAPage, AmendPages}

object AmendCYAStepDefsSteps extends AmendPages with AmendCYAPage {

  // ^the user will be on the Amend (.*) review page and should see their responses$
  def givenTheUserWillBeOnTheAmendXReviewPageAndShouldSeeTheirResponses(journey: String): Unit = {
    confirmUrl(urlAmendCYA)

        journey match {
          case "writeOnly" =>
            verifyH2AddInfo()
            verifyInfoTypeAnswer()

          case "uploadOnly" =>
            verifyH2Documents()
            verifyInfoTypeAnswer()
            verifyUploadRow()

          case "writeAndUpload" =>
            verifyH2AddInfo()
            verifyInfoTypeAnswer()

            verifyH2Documents()
            verifyUploadRow()
        }
  }

  // ^the user will be on the Amend review page$
  def thenTheUserWillBeOnTheAmendReviewPage(): Unit = {
    confirmUrl(urlAmendCYA)
  }

  // ^the user clicks the change link on the amend review page for (.*)$
  def whenTheUserClicksTheChangeLinkOnTheAmendReviewPageForX(changeLink: String): Unit = {
    changeLink match {

          case "CaseRef"   => clickHref("a[href*='case-reference-number']")
          case "Amendment" => clickHref("a[href*='type-of-amendment']")
          case "Message"   => clickHref("a[href*='write-response']")
          case "Documents" =>
              clickHref("a[href*='upload-files']")
        }
  }

  // ^the user should see the message they entered$
  def thenTheUserShouldSeeTheMessageTheyEntered(): Unit = {
    verifyMessageAnswer()
  }

  // ^the user should see the files they uploaded$
  def thenTheUserShouldSeeTheFilesTheyUploaded(): Unit = {
    verifyUploadAnswer()
  }

}
