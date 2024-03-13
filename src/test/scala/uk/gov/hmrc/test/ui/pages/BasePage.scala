/*
 * Copyright 2023 HM Revenue & Customs
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

import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}
import org.scalatest.Assertion
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import uk.gov.hmrc.test.ui.conf.Configuration.environment
import uk.gov.hmrc.test.ui.conf.Environment
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.{Duration, LocalDate, LocalTime}
import scala.util.Random

trait BasePage extends Matchers with BrowserDriver {

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
    wait.until(condition)
  }

  def host(localPort: Int): String = environment match {
    case Environment.Dev     => "https://www.development.tax.service.gov.uk"
    case Environment.Qa      => "https://www.qa.tax.service.gov.uk"
    case Environment.Staging => "https://www.staging.tax.service.gov.uk"
    case _                   => s"http://localhost:$localPort"
  }

  val traderServicesBaseUrl: String = host(9379) + "/send-documents-for-customs-check"
  val importJourneyUrl: String      = "/new/import"
  val exportJourneyUrl: String      = "/new/export"
  val amendUrl: String              = "/add"

  def confirmUrl(url: String): Unit = {
    waitFor(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(
      currentUrl.contains(url) || url.contains(currentUrl),
      message(s"Expected url is: $url. Actual url is: $currentUrl")
    )
  }

  def confirmUrlUpload(url: String): Unit = {
    waitFor(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    assert(
      currentUrl.contains(url) || url.contains(currentUrl),
      message(s"Expected url is: $url. Actual url is: $currentUrl")
    )
  }

  def writeById(id: WebElement, value: String = ""): Unit =
    writeByElement(id, value)

  def writeByElement(element: WebElement, value: String = ""): Unit = {
    element.clear()
    element.sendKeys(value)
  }

  def findElementById(id: String): WebElement = {
    waitFor(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))))
    driver.findElement(By.id(id))
  }

  def elementToBeClickable(css: String): WebElement = {
    waitFor(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def findElementByCss(css: String): WebElement = {
    waitFor(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def notFindElementByCss(css: String): WebElement = {
    waitFor(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(css))))
    driver.findElement(By.cssSelector(css))
  }

  def navigateTo(url: String): Unit = driver.navigate().to(url)

  def findByXpath(xpath: String): WebElement = driver.findElement(By.xpath(xpath))

  def clickHref(href: String): Unit = driver.findElement(By.cssSelector(href)).click()

  def clickByCSS(css: String): Unit = driver.findElement(By.cssSelector(css)).click()

  def clickSendAnother(): Unit = findElementByCss("a.govuk-button").click()

  def clickUploadContinueSFU(): Unit = elementToBeClickable("button.govuk-button:nth-child(6)").click()

  def clickUploadContinueMFU(): Unit =
    elementToBeClickable(".multi-file-upload > div:nth-child(5) > button:nth-child(1)").click()

  def clickContinue(): Unit = findElementById("send-documents-for-customs-check-submit").click()

  def clickContinueCaseRef(): Unit = findElementByCss("button.govuk-button:nth-child(4)").click()

  def clickBack(): Unit = findElementById("back-link").click()

  def optionSelected(css: String): Unit = driver.findElement(By.cssSelector(css)).isSelected shouldBe true

  def optionNotSelected(css: String): Unit = driver.findElement(By.cssSelector(css)).isSelected shouldBe false

  def verifyInput(id: WebElement, expectedValue: String): Assertion = id.getAttribute("value") shouldBe expectedValue

  def sendNCharactersById(id: WebElement, n: Int, char: String = "a"): Unit = {
    id.clear()
    id.sendKeys(char * n)
  }

  def assertElementText(content: String, element: WebElement): Unit =
    assert(element.getText.equals(content), message(s"Element displayed is: ${element.getText} Expecting: $content"))

  def assertElementTextContains(content: String, element: WebElement): Unit =
    assert(element.getText.contains(content), message(s"Element displayed is: ${element.getText} Expecting: $content"))

  def checkSecondaryContent(content1: String, content2: String, element: WebElement): Unit =
    if (!element.getText.contains(content1)) {
      assertElementTextContains(content2, element)
    } else assertElementTextContains(content1, element)

  def isElementVisible(css: String): Boolean = findElementByCss(css).isDisplayed

  def assertIsVisible(css: String): Assertion = assert(isElementVisible(css))

  def assertElementIsNotVisibleById(id: String): Unit = {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))
    assert(
      driver.findElements(By.id(id)).size() == 0,
      message(s"The element with id $id was visible. Expected not visible")
    )
  }

  // Handoff check urls
  def bannerServiceName(): WebElement = findElementByCss(".hmrc-header__service-name--linked")

  def clickGovUkIcon(): Unit = clickByCSS(".hmrc-header__logotype-text")

  val govUkExternal = "https://www.gov.uk/"

  def clickGiveFeedbackConfirmation(): Unit = clickHref("a[href*='/feedback/send-documents-for-customs-check']")

  lazy val giveFeedbackUrl = "/feedback/send-documents-for-customs-check"

  def clickNchConfirmation(): Unit = clickHref(
    "a[href*='national-clearance-hub-for-goods-entering-leaving-or-transiting-the-eu']"
  )

  lazy val nchConfirmationUrl =
    "https://www.gov.uk/guidance/national-clearance-hub-for-goods-entering-leaving-or-transiting-the-eu"

  def clickChiefUnavailable(): Unit = clickHref(
    "a[href*='/import-and-export-presentation-of-goods-for-export-arrival-c1601']"
  )

  lazy val chiefUnavailableUrl =
    "https://www.gov.uk/government/publications/import-and-export-presentation-of-goods-for-export-arrival-c1601"

  def clickNchAmendLink(): Unit = clickHref("a[href*='national-clearance-hub']")

  val nchAmendUrl = "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/national-clearance-hub"

  def clickGiveFeedbackBanner(): Unit = clickByCSS(".govuk-phase-banner__text > a:nth-child(1)")

  val giveFeedbackBannerUrl = "/contact/beta-feedback"

  def clickDeskProLink(): Unit = clickByCSS(".hmrc-report-technical-issue")

  val deskProUrl = "/contact/report-technical-problem?service=send-documents-for-customs-check"

  def clickURLink(): Unit = clickByCSS("a.govuk-link:nth-child(2)")

  val urBannerLink = "/signup.take-part-in-research.service.gov.uk/home?utm_campaign=Customs_Check"

  // Time and date
  lazy val today: LocalDate   = LocalDate.now
  lazy val (d, m, y)          = (today.getDayOfMonth, today.getMonthValue, today.getYear)
  lazy val (day, month, year) = (today.getDayOfMonth.toString, today.getMonthValue.toString, today.getYear.toString)

  lazy val yesterday: LocalDate = today.minusDays(1)
  lazy val (yd, ym, yy)         =
    (yesterday.getDayOfMonth.toString, yesterday.getMonthValue.toString, yesterday.getYear.toString)

  lazy val tomorrow: LocalDate = today.plusDays(1)
  lazy val (td, tm, ty)        = (tomorrow.getDayOfMonth.toString, tomorrow.getMonthValue.toString, tomorrow.getYear.toString)

  lazy val sixMonthsFromNow: LocalDate = today.plusMonths(6)

  lazy val overSixMonthsFromNow: LocalDate = today.plusMonths(6).plusDays(1)
  lazy val (d6future, m6future, y6future)  = (
    overSixMonthsFromNow.getDayOfMonth.toString,
    overSixMonthsFromNow.getMonthValue.toString,
    overSixMonthsFromNow.getYear.toString
  )

  lazy val sixMonthsAgo: LocalDate  = today.minusMonths(6).minusDays(1)
  lazy val (d6past, m6past, y6past) =
    (sixMonthsAgo.getDayOfMonth.toString, sixMonthsAgo.getMonthValue.toString, sixMonthsAgo.getYear.toString)

  lazy val dayFormatted   = f"$d%02d"
  lazy val monthFormatted = f"$m%02d"

  lazy val nowTime: LocalTime = LocalTime.now()
  lazy val sla2Hour: Int      = nowTime.plusHours(2).getHour
  lazy val sla3Hour: Int      = nowTime.plusHours(3).getHour
  lazy val min: Int           = nowTime.getMinute
  lazy val min1: Int          = nowTime.minusMinutes(1).getMinute

  lazy val sla2hrFormatted = f"$sla2Hour%02d:$min%02d"
  lazy val sla2hrAddMin    = f"$sla2Hour%02d:$min1%02d"

  lazy val sla3hrFormatted = f"$sla3Hour%02d:$min%02d"
  lazy val sla3hrAddMin    = f"$sla3Hour%02d:$min1%02d"

  lazy val threePm: LocalTime  = LocalTime.parse("15:00:00.00")
  lazy val midnight: LocalTime = LocalTime.parse("00:00:00.00")
  lazy val eightAm: LocalTime  = LocalTime.parse("08:00:00.00")

  lazy val between3pmAndMidnight: Boolean = nowTime.isAfter(threePm) && nowTime.isBefore(midnight)
  lazy val betweenMidnightAnd8am: Boolean = nowTime.isAfter(midnight) && nowTime.isBefore(eightAm)
  lazy val between8amAnd3pm: Boolean      = nowTime.isAfter(eightAm) && nowTime.isBefore(threePm)

  def errorContentAmendCaseRef: WebElement = findElementByCss("p.govuk-body:nth-child(3)")

  val errorContentCaseRef: String = "Try to enter your case reference number again."

  // Random inputs
  lazy val randomEpuDigits: Int = Random.nextInt(666)
  val randomEPU: String         = f"$randomEpuDigits%03d"

  lazy val randomAlpha: String = Random.alphanumeric.filter(_.isLetter).head.toString

  lazy val randomImportDigits: Int = Random.nextInt(999999)
  lazy val importEN: String        = f"$randomImportDigits%06d" + randomAlpha

  lazy val randomExportDigits: Int = Random.nextInt(99999)
  lazy val exportEN: String        = randomAlpha + f"$randomExportDigits%05d" + randomAlpha

  def randomString(length: Int): String = Random.alphanumeric.take(length).mkString

  val shortString: String = randomString(20)
  val longString: String  = randomString(1000)

  var lastUsedTestEmail: String = ""

  def generateTestEmailAddress: String = {
    lastUsedTestEmail = s"$shortString@test.com"
    lastUsedTestEmail
  }

  val userCaseRef = "PC12010081330XGBNZJO04"

  // Agent-stubs
  def userId: WebElement = driver.findElement(By.id("userId"))

  def planetId: WebElement = driver.findElement(By.id("planetId"))

  def signInButton: WebElement = driver.findElement(By.id("signIn"))

  def destroyPlanetLink: WebElement = driver.findElement(By.cssSelector("#link_planet_destroy"))

  def login(): Unit = {
    userId.sendKeys("User1")
    planetId.sendKeys("Planet1")
    signInButton.click()
  }
}
