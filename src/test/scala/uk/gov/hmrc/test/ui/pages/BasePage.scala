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

import java.time.Duration

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver


trait BasePage extends Matchers with BrowserDriver {

  val env: String = System.getProperty("environment")

  val fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofMillis(250))

  def host(localPort: Int): String = env match {
    case "development" => "https://www.development.tax.service.gov.uk"
    case "qa" => "https://www.qa.tax.service.gov.uk"
    case "staging" => "https://www.staging.tax.service.gov.uk"
    case _ => s"http://localhost:$localPort"
  }

  val traderServicesBaseUrl: String = host(9379) + "/trader-services"
  val importJourneyUrl: String = "/pre-clearance/import-questions"
  val exportJourneyUrl: String = "/pre-clearance/export-questions"

  def confirmUrl(url: String): Unit = {
    fluentWait.until(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(url) || url.contains(currentUrl), message(s"Expected url is: $url. Actual url is: $currentUrl"))
  }

  def writeById(id: String, value: String = "") {
    writeByElement(findElementById(id), value)
  }

  def writeByElement(element: WebElement, value: String = "") {
    element.clear()
    element.sendKeys(value)
  }

  def findElementById(id: String): WebElement = {
    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))))
    driver.findElement(By.id(id))
  }

  def findElementByCss(css: String): WebElement = {
    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def verifyHeading(text: String): Unit = findElementByCss("h1").getText shouldBe text

  def clickContinue(): Unit = findElementByCss(".govuk-button").click()

  def clickSubmit(): Unit = findElementByCss("input[type=Submit]").click()

  def clickById(id: String): Unit = findElementById(id).click()

  def clickByCSS(css: String): Unit = driver.findElement(By.cssSelector(css)).click()

  def signOut: WebElement = findElementByCss("#navigation > li > a")

  def navigateTo(url: String): Unit = driver.navigate().to(url)

  def login(): Unit = {
    userid.sendKeys("User1")
    planetid.sendKeys("Planet1")
    signinBtn.click()
  }
  def userid: WebElement = driver.findElement(By.id("userId"))
  def planetid: WebElement = driver.findElement(By.id("planetId"))
  def signinBtn: WebElement = driver.findElement(By.id("signIn"))

  def createUser(): Unit = {
    clickByCSS("#affinityGroup-Individual")
    clickById("principalEnrolments[0].key-HMRC-CUS-ORG")
    clickByCSS("#update")
  }
}
