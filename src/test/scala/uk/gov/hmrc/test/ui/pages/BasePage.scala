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

import java.time.{Duration, LocalDate, LocalTime}
import java.util.UUID
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

  val fluentWaitLong: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(60))
    .pollingEvery(Duration.ofMillis(250))

  def host(localPort: Int): String = environment match {
    case Environment.Dev => "https://www.development.tax.service.gov.uk"
    case Environment.Qa => "https://www.qa.tax.service.gov.uk"
    case Environment.Staging => "https://www.staging.tax.service.gov.uk"
    case _ => s"http://localhost:$localPort"
  }

  val traderServicesBaseUrl: String = host(9379) + "/send-documents-for-customs-check"
  val importjourneyUrl: String = "/new/import"
  val exportjourneyUrl: String = "/new/export"
  val amendUrl: String = "/add"

  val govukExternal = "https://www.gov.uk/"
  val exitSurvey = host(9514) + "/feedback/send-documents-for-customs-check"

  def confirmUrl(url: String): Unit = {
    fluentWait.until(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(url) || url.contains(currentUrl), message(s"Expected url is: $url. Actual url is: $currentUrl"))
  }

  def confirmUrlUpload(url: String): Unit = {
    fluentWaitLong.until(ExpectedConditions.urlContains(url))
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
    fluentWaitLong.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def findElementByCss(css: String): WebElement = {
    fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def notFindElementByCss(css: String): WebElement = {
    fluentWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(css))))
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

  def clickSendAnother(): Unit = findElementByCss("a.govuk-button").click()

  def clickUploadContinueSFU(): Unit = elementToBeClickable("button.govuk-button:nth-child(6)").click()

  def clickUploadContinueMFU(): Unit = elementToBeClickable(".multi-file-upload > div:nth-child(5) > button:nth-child(1)").click()

  def clickContinueSubmit(): Unit = findElementByCss("#send-documents-for-customs-check-submit")

  def clickContinue(): Unit = findElementByCss("button.govuk-button:nth-child(3)").click()

  def clickContinueCaseRef(): Unit = findElementByCss("button.govuk-button:nth-child(4)").click()

  def clickCYAContinue(): Unit = findElementByCss("#send-documents-for-customs-check-submit").click()

  def clickBack(): Unit = findElementById("back-link").click()

  def clickSignOut(): Unit = findElementByCss(".hmrc-sign-out-nav__link").click()

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

  def assertElementTextContainsEither(content: String, content2: String, element: WebElement): Unit = {
    assert(element.getText.contains(content), message(s"Element displayed is: ${element.getText} Expecting: $content or $content2"))
  }

  def isElementVisible(css: String): Boolean = findElementByCss(css).isDisplayed

  def assertElementIsNotVisibleById(id: String): Unit = {
    driver.manage.timeouts.implicitlyWait(1, TimeUnit.SECONDS)
    assert(driver.findElements(By.id(id)).size() == 0, message(s"The element with id $id was visible. Expected not visible"))
    driver.manage.timeouts.implicitlyWait(1, TimeUnit.SECONDS)
  }

  //Time and date
  lazy val todayDate: LocalDate = LocalDate.now()

  val today = LocalDate.now
  val (d, m, y) = (today.getDayOfMonth(), today.getMonthValue(), today.getYear())
  val (day, month, year) = (today.getDayOfMonth().toString, today.getMonthValue().toString, today.getYear().toString)

  val dayFormatted = f"$d%02d"
  val monthFormatted = f"$m%02d"

  def todayDateCYA: String = {
    s"${todayDate.getDayOfMonth.toString} ${todayDate.getMonth.toString.toLowerCase.capitalize} ${todayDate.getYear.toString}"
  }

  lazy val nowTime: LocalTime = LocalTime.now()
  lazy val nowHrs = nowTime.getHour
  lazy val nowMin = nowTime.getMinute
  lazy val sla2Hour = nowTime.plusHours(2).getHour
  lazy val sla3Hour = nowTime.plusHours(3).getHour
  lazy val min = nowTime.getMinute
  lazy val min1 = nowTime.minusMinutes(1).getMinute

  lazy val nowFormatted = f"$nowHrs%02d:$nowMin%02d"
  lazy val sl2hrFormatted = f"$sla2Hour%02d:$min%02d"
  lazy val sl2hrAddMin = f"$sla2Hour%02d:$min1%02d"

  lazy val sla3hrFormatted = f"$sla3Hour%02d:$min%02d"
  lazy val sla3hrMin = f"$sla3Hour%02d:$min1%02d"

  lazy val threePm = LocalTime.parse("15:00:00.00")
  lazy val midnight = LocalTime.parse("00:00:00.00")
  lazy val eightAm = LocalTime.parse("08:00:00.00")

  lazy val between3pmAndMidnight = nowTime.isAfter(threePm) && nowTime.isBefore(midnight)
  lazy val betweenMidnightAnd8am = nowTime.isAfter(midnight) && nowTime.isBefore(eightAm)
  lazy val between8amAnd3pm = nowTime.isAfter(eightAm) && nowTime.isBefore(threePm)

  //todo check this works
  var lastUsedTestEmail: String = ""

  def generateTestEmailAddress: String = {
    lastUsedTestEmail = s"test${UUID.randomUUID().toString}@test.com"
    lastUsedTestEmail
  }

  //Agent-stubs
  def userid: WebElement = driver.findElement(By.id("userId"))

  def planetid: WebElement = driver.findElement(By.id("planetId"))

  def signinBtn: WebElement = driver.findElement(By.id("signIn"))

  def destroyPlanet: WebElement = driver.findElement(By.cssSelector("#destroy-planet"))

  def destroyPlanetLink: WebElement = driver.findElement(By.cssSelector("#link_planet_destroy"))

  def enrollment: WebElement = findElementById("principalEnrolments[0].identifiers[0].value")

  def login(): Unit = {
    userid.sendKeys("User1")
    planetid.sendKeys("Planet1")
    signinBtn.click()
  }

  def createUser(): Unit = {
    clickByCSS("#affinityGroup-Individual")
    clickById("principalEnrolments[0].key-HMRC-CTS-ORG")
    clickByCSS("#update")
    enrollment.clear()
    enrollment.sendKeys("GB123456789012345")
  }
}
