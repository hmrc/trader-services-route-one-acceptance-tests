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
import uk.gov.hmrc.test.ui.pages.{BasePage, CheckAnswersPage}


class CheckAnswersStepDefs extends CheckAnswersPage with BasePage with ScalaDsl with EN {

  Given("""^the user is on the (.*) CYA page$""") { (Journey: String) =>
    Journey match {
      case "Import" => confirmUrl(urlImportCYA)
      case "Export" => confirmUrl(urlExportCYA)
    }
    verifyHeading(headingMainCYA)
    verifyH2Declaration(h2Dec)
    verifyH2Questions(h2Questions)
    verifyH2Vessel(h2Vessel)
    verifyH2Contact(h2ContactDetails)
  }

  //TOP 4 will not change
  Then("""^the user should see the EPU row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[1]/dd[1]")).getText shouldBe Answer
    }

  Then("""^the user should see the Entry No row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[2]/dd[1]")).getText shouldBe Answer

  }

  Then("""^the user should see the Entry Date row & the date (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[3]/dt")).isDisplayed

    Answer match {
      case "Today" => assertElementText(todayDateCYA, driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[3]/dd[1]")))
      case _ => driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[1]/div[3]/dd[1]")).getText shouldBe Answer
    }
  }

  Then("""^the user should see the Request Type row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[1]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[1]/dd[1]")).getText shouldBe Answer

  }

  //ROUTE MAY NOT BE PRESENT - ORDER IMPACTED IF SO -> TO BE RESOLVED
  Then("""^the user should see the Route row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[2]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[2]/dd[1]")).getText shouldBe Answer

  }

  //IF NO - ORDER IMPACTED -> TO BE RESOLVED
  Then("""^the user should see the Priority YN row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[3]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[3]/dd[1]")).getText shouldBe Answer

  }

  Then("""^the user should see the Priority Goods row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[4]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[4]/dd[1]")).getText shouldBe Answer

  }

  Then("""^the user should see the Export Transport row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[5]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[5]/dd[1]")).getText shouldBe Answer

  }

  //VESSEL Qs - Should be static
  Then("""^the user should see the Vessel Name row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[1]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[1]/dd[1]")).getText shouldBe Answer

  }

  Then("""^the user should see the Vessel Date row & the correct response "(.*)" on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[2]/dt")).isDisplayed

    Answer match {
      case "Today" => assertElementText(todayDateCYA, driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[2]/dd[1]")))
      case _ => driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[2]/dd[1]")).getText shouldBe Answer
    }

  }

  Then("""^the user should see the Vessel Time row & the correct response "(.*)" on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[3]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[3]/dd[1]")).getText shouldBe Answer

  }


//SORT OUT BLANK RESPONSE
  Then("""^the user should see the Contact details row & the blank response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[4]/div/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[3]/div[3]/dd[1]")).getText shouldBe Answer

  }

  Then("""^the user should see the Contact details row & the correct responses (.*) on the CYA page$""") { (AnswerName:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[4]/div/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[4]/div/dd[1]/div[1]")).getText shouldBe AnswerName

  }

//PRESENCE OF ALVS ALTERS ORDER -> TO BE RESOLVED
  Then("""^the user should see the ALVS row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[5]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[5]/dd[1]")).getText shouldBe Answer

  }
  Then("""^the user should see the Import transport row & the correct response (.*) on the CYA page$""") { (Answer:String) =>
    driver.findElement(By.xpath("//html/body/div/main/div/div/div[1]/dl[2]/div[6]/dt")).isDisplayed
    driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/dl[2]/div[6]/dd[1]")).getText shouldBe Answer

  }
}


//
//  When("""^the user clicks the change link for (.*)$""") { (changeLink: String) =>
//    changeLink match {
//      case "Contact" => findElementByLink("/trader-services/pre-clearance/import-questions/contact-info")
//      case "Time" =>
//    }
//  }

//  def findBylinkText(linkText: String): WebElement = driver.findElement(By.(linkText))



