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

package uk.gov.hmrc.test.ui.pages

import io.cucumber.datatable.DataTable
import org.openqa.selenium.WebElement

trait CheckAnswersPage extends BasePage with DeclarationNumPage with QuestionPages with PriorityPages {

  val urlCYA: String = traderServicesBaseUrl + ""
  val headingCYA = "Check the details"

}

//  private val checkYourAnswersContainerSelector: String = ".govuk-check-your-answers"
//  private val questionSelector: String = ".cya-question"
//  private val answerSelector: String = ".cya-answer"
//  private val changeSelector: String = ".cya-change > a"
//
//
//  private val answerRowMapping: Map[String, String] = {
//    Map(
//        "Declaration" -> headingDecDetails,
//      "ImportRequest" ->
//        "ImportRoute" ->
//        "PriorityYN" ->
//        "PriorityGoods" ->
//        "Transport" ->
//        "Vessel" ->
//        "ContacctDetails" ->
//    )
//  }
//a
//  private def assertQuestionAnswer(row: Int, question: String, answer: String): Unit = {
//    val rowSelector: String = s"$checkYourAnswersContainerSelector > div:nth-of-type($row)"
//    val questionElement: WebElement = findElementByCss(s"$rowSelector > $questionSelector")
//    val answerElement: WebElement = findElementByCss(s"$rowSelector > $answerSelector")
//
//    assertElementText(question, questionElement)
//    assertElementText(answer, answerElement)
//  }
//
//  def checkQuestionsAndAnswers(data: DataTable): Unit = {
//
//    val questionColumnId: Int = 0
//    val answerColumnId: Int = 1
//    val tableContent: util.List[util.Map[String, String]] = data.asMaps(classOf[String], classOf[String])
//
//    for (rowId <- 0 to tableContent.toArray().length) {
//
//      val question: String = answerRowMapping.getOrElse(
//        data.raw().get(rowId).get(questionColumnId),
//        throw new IllegalArgumentException("Invalid CYA question key: check pages/deregVat/CheckYourAnswersPage.answerRowMapping for valid keys")
//      )
//
//      val answer: String = question match {
//        case EnterCancellationDatePage.checkYourAnswersQuestion =>
//          data.raw().get(rowId).get(answerColumnId) match {
//            case "" => EnterCancellationDatePage.checkYourAnswersDate
//            case value => value
//          }
//
//        case _ => data.raw().get(rowId).get(answerColumnId)
//      }
//
//      assertQuestionAnswer(rowId + 1, question, answer)
//    }
//  }
//
//  def selectChangeLink(questionNumber: Int): Unit = {
//    val rowSelector: String = s"$checkYourAnswersContainerSelector > div:nth-of-type($questionNumber)"
//    findElementByCss(s"$rowSelector > $changeSelector").click()
//  }
//}
//
//}
