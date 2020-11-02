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

import java.time.{Duration, LocalDate}
import java.util.concurrent.TimeUnit

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.{Assertion, Matchers}
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

  def findElementByLink(href: String): Unit = {
    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(href))))
    driver.findElement(By.linkText(href))
  }

  def findElementByHref(hrefValue: String, hrefcss: WebElement): Unit = {
    fluentWait.until(ExpectedConditions.visibilityOf(hrefcss))
    val href = hrefcss.getAttribute("href")
    assert(href == hrefValue, s"Heading was '$href' but expected '$hrefValue'")
  }

  def findByXpath(xpath:String): WebElement = driver.findElement(By.xpath(xpath))

  def clickHref(href:String):Unit = driver.findElement(By.cssSelector(href)).click()

  def verifyHeading(text: String): Unit = findElementByCss("h1").getText shouldBe text

  def clickContinue(): Unit = findElementByCss(".govuk-button").click()

  def clickBack(): Unit = findElementById("back-link").click()

  def clickById(id: String): Unit = findElementById(id).click()

  def clickByCSS(css: String): Unit = driver.findElement(By.cssSelector(css)).click()

  def optionSelected(css: String): Unit = driver.findElement(By.cssSelector(css)).isSelected shouldBe true

  def verifyInput(id: String, expectedValue: String):
  Assertion = findElementById(id).getAttribute("value") shouldBe expectedValue

  def signOut: WebElement = findElementByCss("#navigation > li > a")

  def assertElementText(content: String, element: WebElement): Unit = {
    assert(element.getText.equals(content), message (s"Element displayed is: ${element.getText} Expecting: $content"))
  }

  lazy val todayDate: LocalDate = LocalDate.now()

  def todayDateCYA: String = {
    s"${todayDate.getDayOfMonth.toString} ${todayDate.getMonth.toString.toLowerCase.capitalize} ${todayDate.getYear.toString}"
  }

  def assertElementIsNotVisibleById(id: String): Unit = {
    driver.manage.timeouts.implicitlyWait(50, TimeUnit.SECONDS)
    assert(driver.findElements(By.id(id)).size() == 0, message(s"The element with id $id was visible. Expected not visible"))
    driver.manage.timeouts.implicitlyWait(50, TimeUnit.SECONDS)
  }

  def navigateTo(url: String): Unit = driver.navigate().to(url)

//  def validateErrorSummaryLinksToError(pageField: String, bodyField: String): Boolean = {
//    clickById(pageField + "PageErrMsg")
//    findElementById(bodyField).isSelected
//  }

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
