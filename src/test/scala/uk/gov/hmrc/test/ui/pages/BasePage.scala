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

package uk.gov.hmrc.test.ui.pages

import java.io.File
import java.time.{Duration, LocalDate}
import java.util.concurrent.TimeUnit

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.scalatest.{Assertion, Matchers}
import uk.gov.hmrc.test.ui.conf.Configuration.environment
import uk.gov.hmrc.test.ui.conf.Environment
import uk.gov.hmrc.test.ui.driver.BrowserDriver

trait BasePage extends Matchers with BrowserDriver {

  val userCaseRef = "PC12010081330XGBNZJO04"

  val fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(20))
    .pollingEvery(Duration.ofMillis(250))

  val fluentWaitUpload: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(60))
    .pollingEvery(Duration.ofMillis(250))

  def host(localPort: Int): String = environment match {
    case Environment.Dev => "https://www.development.tax.service.gov.uk"
    case Environment.Qa => "https://www.qa.tax.service.gov.uk"
    case Environment.Staging => "https://www.staging.tax.service.gov.uk"
    case _ => s"http://localhost:$localPort"
  }

  val traderServicesBaseUrl: String = host(9379) + "/send-documents-for-customs-check"
  val importJourneyUrl: String = "/new/import"
  val exportJourneyUrl: String = "/new/export"
  val amendUrl: String = "/add"

  def confirmUrl(url: String): Unit = {
    fluentWait.until(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(url) || url.contains(currentUrl), message(s"Expected url is: $url. Actual url is: $currentUrl"))
  }

  def confirmUrlUpload(url: String): Unit = {
    fluentWaitUpload.until(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(url) || url.contains(currentUrl), message(s"Expected url is: $url. Actual url is: $currentUrl"))
  }

  def findWriteById(id: String, value: String = "") {
    writeByElement(findElementById(id), value)
  }

  def writeById(id: WebElement, value: String = "") {
    writeByElement(id, value)
  }

  def writeByElement(element: WebElement, value: String = "") {
    element.clear()
    element.sendKeys(value)
  }

  def findElementById(id: String): WebElement = {
    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))))
    driver.findElement(By.id(id))
  }

  def elementToBeClickable(css: String): WebElement = {
    fluentWaitUpload.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
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

  def navigateTo(url: String): Unit = driver.navigate().to(url)

  def findByXpath(xpath: String): WebElement = driver.findElement(By.xpath(xpath))

  def clickHref(href: String): Unit = driver.findElement(By.cssSelector(href)).click()

  def verifyHeading(text: String): Unit = findElementByCss("h1").getText shouldBe text

  def clickById(id: String): Unit = findElementById(id).click()

  def clickByCSS(css: String): Unit = driver.findElement(By.cssSelector(css)).click()


  def clickFinalContinue():Unit = findElementByCss("a.govuk-button").click()
  def clickUploadFirst(): Unit = elementToBeClickable(".file-upload__submit").click()
  def clickUploadContinue(): Unit = elementToBeClickable("button.govuk-button:nth-child(6)").click()

  def clickContinue(): Unit = findElementByCss("button.govuk-button:nth-child(3)").click()
  def clickContinueCaseRef(): Unit = findElementByCss("button.govuk-button:nth-child(4)").click()

  def clickCYAContinue(): Unit = findElementByCss("button.govuk-button:nth-child(2)").click()


  def clickBack(): Unit = findElementById("back-link").click()

  def optionSelected(css: String): Unit = driver.findElement(By.cssSelector(css)).isSelected shouldBe true

  def optionNotSelected(css: String): Unit = driver.findElement(By.cssSelector(css)).isSelected shouldBe false

  def findVerifyInput(id: String, expectedValue: String):
  Assertion = findElementById(id).getAttribute("value") shouldBe expectedValue

  def verifyInput(id: WebElement, expectedValue: String):
  Assertion = id.getAttribute("value") shouldBe expectedValue

  def sendNCharactersById(id: WebElement, n: Int, char: String = "a"): Unit = {
    id.clear()
    id.sendKeys(char * n)
  }

  def assertElementText(content: String, element: WebElement): Unit = {
    assert(element.getText.equals(content), message(s"Element displayed is: ${element.getText} Expecting: $content"))
  }

  def assertElementTextContains(content: String, element: WebElement): Unit = {
    assert(element.getText.contains(content), message(s"Element displayed is: ${element.getText} Expecting: $content"))
  }

  def isElementVisible(css: String): Boolean = findElementByCss(css).isDisplayed

  def assertElementIsNotVisibleById(id: String): Unit = {
    driver.manage.timeouts.implicitlyWait(50, TimeUnit.SECONDS)
    assert(driver.findElements(By.id(id)).size() == 0, message(s"The element with id $id was visible. Expected not visible"))
    driver.manage.timeouts.implicitlyWait(50, TimeUnit.SECONDS)
  }

  lazy val todayDate: LocalDate = LocalDate.now()

  def todayDateCYA: String = {
    s"${todayDate.getDayOfMonth.toString} ${todayDate.getMonth.toString.toLowerCase.capitalize} ${todayDate.getYear.toString}"
  }

  def copyFile(srcFile: File, destFile: File): Unit = {
    copyFile(srcFile, destFile)
  }

//  def signOut: WebElement = findElementByCss("#navigation > li > a")

  //Agent-stubs
  def login(): Unit = {
    userid.sendKeys("User1")
    planetid.sendKeys("Planet1")
    signinBtn.click()
  }

  def userid: WebElement = driver.findElement(By.id("userId"))
  def planetid: WebElement = driver.findElement(By.id("planetId"))
  def signinBtn: WebElement = driver.findElement(By.id("signIn"))

  def destroyPlanet: WebElement = driver.findElement(By.cssSelector("#destroy-planet"))
  def destroyPlanetLink: WebElement = driver.findElement(By.cssSelector("#link_planet_destroy"))

  def enrollment: WebElement = findElementById("principalEnrolments[0].identifiers[0].value")

  def createUser(): Unit = {
    clickByCSS("#affinityGroup-Individual")
    clickById("principalEnrolments[0].key-HMRC-CUS-ORG")
    clickByCSS("#update")
    enrollment.clear()
    enrollment.sendKeys("GB123456789012345")
  }
}

//def clickFinalContinue():Unit = findElementByCss("a.govuk-button").click()
//def clickUploadFirst(): Unit = elementToBeClickable(".file-upload__submit").click()
//def clickUploadContinue(): Unit = elementToBeClickable("button.govuk-button:nth-child(6)").click()
//
//def clickContinue(): Unit = findElementByCss("button.govuk-button:nth-child(3)").click()
//def clickContinueCaseRef(): Unit = findElementByCss("button.govuk-button:nth-child(4)").click()
//
//def clickCYAContinue(): Unit = findElementByCss("button.govuk-button:nth-child(2)").click()
