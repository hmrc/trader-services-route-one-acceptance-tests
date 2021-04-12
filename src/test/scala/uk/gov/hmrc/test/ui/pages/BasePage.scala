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
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, FluentWait}
import org.scalatest.{Assertion, Matchers}
import uk.gov.hmrc.test.ui.conf.Configuration.environment
import uk.gov.hmrc.test.ui.conf.Environment
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.util.Random

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
  }

  def switchToNewTab(totalTabs: Int): Unit = {
    fluentWait.until[Boolean](new ExpectedCondition[Boolean] {
      def apply(d: WebDriver): Boolean = d.getWindowHandles.size() == totalTabs
    })
    val tab = driver.getWindowHandles.toList
    driver.switchTo().window(tab.last)
  }

  def closeNewTab(): Unit = {
    val tab = driver.getWindowHandles.toList
    driver.close()
    driver.switchTo().window(tab(tab.length - 2))
  }

  //Handoff check urls
  def bannerServiceName(): WebElement = findElementByCss(".govuk-header__link--service-name")

  def clickGovUkIcon(): Unit = clickByCSS(".govuk-header__logotype-text")

  val govukExternal = "https://www.gov.uk/"

  def clickGiveFeedbackConfirmation(): Unit = clickHref("a[href*='/feedback/send-documents-for-customs-check']")

  lazy val giveFeedbackUrl = "/feedback/send-documents-for-customs-check"

  def clickNchConfirmation(): Unit = clickHref("a[href*='national-clearance-hub-for-goods-entering-leaving-or-transiting-the-eu']")

  lazy val nchConfirmationUrl = "https://www.gov.uk/guidance/national-clearance-hub-for-goods-entering-leaving-or-transiting-the-eu"

  def clickChiefUnavailable(): Unit = clickHref("a[href*='/import-and-export-presentation-of-goods-for-export-arrival-c1601']")

  lazy val chiefUnavailableUrl = "https://www.gov.uk/government/publications/import-and-export-presentation-of-goods-for-export-arrival-c1601"

  def clickNchAmendLink(): Unit = clickHref("a[href*='national-clearance-hub']")

  val nchAmendUrl = "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/national-clearance-hub"

  def clickGiveFeedbackBanner(): Unit = clickByCSS(".govuk-phase-banner__text > a:nth-child(1)")

  val giveFeedbackBannerUrl = "/contact/beta-feedback"

  def clickDeskproLink(): Unit = clickByCSS(".report-a-problem > a:nth-child(1)")

  val deskproUrl = "/contact/problem_reports_nonjs"

  def clickURLink(): Unit = clickByCSS(".govuk-body")

  val urBannerLink = "/signup.take-part-in-research.service.gov.uk/home?utm_campaign=Customs_Check"

  //Time and date

  lazy val today: LocalDate = LocalDate.now
  lazy val (d, m, y) = (today.getDayOfMonth, today.getMonthValue, today.getYear)
  lazy val (day, month, year) = (today.getDayOfMonth.toString, today.getMonthValue.toString, today.getYear.toString)

  lazy val dayFormatted = f"$d%02d"
  lazy val monthFormatted = f"$m%02d"

  def todayDateCYA: String = {
    s"${today.getDayOfMonth.toString} ${today.getMonth.toString.toLowerCase.capitalize} ${today.getYear.toString}"
  }

  lazy val nowTime: LocalTime = LocalTime.now()
  lazy val nowHrs: Int = nowTime.getHour
  lazy val nowMin: Int = nowTime.getMinute
  lazy val sla2Hour: Int = nowTime.plusHours(2).getHour
  lazy val sla3Hour: Int = nowTime.plusHours(3).getHour
  lazy val min: Int = nowTime.getMinute
  lazy val min1: Int = nowTime.minusMinutes(1).getMinute

  lazy val nowFormatted = f"$nowHrs%02d:$nowMin%02d"
  lazy val sl2hrFormatted = f"$sla2Hour%02d:$min%02d"
  lazy val sl2hrAddMin = f"$sla2Hour%02d:$min1%02d"

  lazy val sla3hrFormatted = f"$sla3Hour%02d:$min%02d"
  lazy val sla3hrMin = f"$sla3Hour%02d:$min1%02d"

  lazy val threePm: LocalTime = LocalTime.parse("15:00:00.00")
  lazy val midnight: LocalTime = LocalTime.parse("00:00:00.00")
  lazy val eightAm: LocalTime = LocalTime.parse("08:00:00.00")

  lazy val between3pmAndMidnight: Boolean = nowTime.isAfter(threePm) && nowTime.isBefore(midnight)
  lazy val betweenMidnightAnd8am: Boolean = nowTime.isAfter(midnight) && nowTime.isBefore(eightAm)
  lazy val between8amAnd3pm: Boolean = nowTime.isAfter(eightAm) && nowTime.isBefore(threePm)

  lazy val randomEPU: String = (Random.nextInt(569) + 100).toString
  lazy val randomAlpha: String = Random.alphanumeric.filter(_.isLetter).head.toString

  lazy val randomImportEN: String = (100000 + Random.nextInt(899999)).toString + randomAlpha
  lazy val randomExportEN: String = randomAlpha + (10000 + Random.nextInt(89999)).toString + randomAlpha

  var lastUsedTestEmail: String = ""

  def generateTestEmailAddress: String = {
    lastUsedTestEmail = s"test${UUID.randomUUID().toString}@test.com"
    lastUsedTestEmail
  }

  //Agent-stubs
  def userId: WebElement = driver.findElement(By.id("userId"))

  def planetId: WebElement = driver.findElement(By.id("planetId"))

  def signInButton: WebElement = driver.findElement(By.id("signIn"))

  def destroyPlanet: WebElement = driver.findElement(By.cssSelector("#destroy-planet"))

  def destroyPlanetLink: WebElement = driver.findElement(By.cssSelector("#link_planet_destroy"))

  def enrollment: WebElement = findElementById("principalEnrolments[0].identifiers[0].value")

  def login(): Unit = {
    userId.sendKeys("User1")
    planetId.sendKeys("Planet1")
    signInButton.click()
  }

  def createUser(): Unit = {
    clickByCSS("#affinityGroup-Individual")
    clickById("principalEnrolments[0].key-HMRC-CTS-ORG")
    clickByCSS("#update")
    enrollment.clear()
    enrollment.sendKeys("GB123456789012345")
  }
}
