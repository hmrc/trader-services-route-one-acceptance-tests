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

package uk.gov.hmrc.test.ui.conf

import com.typesafe.config.{Config, ConfigFactory}
import org.openqa.selenium.WebDriver
import uk.gov.hmrc.webdriver.SingletonDriver

case class Configuration(baseUrl: String, SIGN_IN_PAGE: String, DESTROY_PLANET:String)

object Configuration {

  val driverInstance: WebDriver = SingletonDriver.getInstance()

  val config: Config = ConfigFactory.load()
  val defaultConfig: Config = config
  val envConfig: Config = config.withFallback(defaultConfig)

  lazy val environment: Environment.Name = {
    val environmentProperty = Option(System.getProperty("environment")).getOrElse("Local").toLowerCase
    environmentProperty match {
      case "local" => Environment.Local
      case "qa" => Environment.Qa
      case "dev" => Environment.Dev
      case "staging" => Environment.Staging
      case _ => throw new IllegalArgumentException(s"Environment '$environmentProperty' not known")
    }
  }

  lazy val settings: Configuration = create()

  private def create(): Configuration = {
    environment match {
      case Environment.Local =>
        new Configuration(
          baseUrl = "http://localhost",
          SIGN_IN_PAGE = "http://localhost:9379/trader-services/pre-clearance/new-or-existing",
          DESTROY_PLANET = "http://localhost:9099/agents-external-stubs/"
        )
      case Environment.Dev =>
        new Configuration(
          baseUrl = "https://www.development.tax.service.gov.uk/",
          SIGN_IN_PAGE = "https://www.development.tax.service.gov.uk/trader-services/pre-clearance/new-or-existing",
          DESTROY_PLANET = "https://www.development.tax.service.gov.uk/agents-external-stubs/"
        )
      case Environment.Qa =>
        new Configuration(
          baseUrl = "https://www.qa.tax.service.gov.uk/",
          SIGN_IN_PAGE = "https://www.qa.tax.service.gov.uk/trader-services/pre-clearance/new-or-existing",
          DESTROY_PLANET = "https://www.qa.tax.service.gov.uk/agents-external-stubs/"
        )

      case Environment.Staging =>
        new Configuration(
          baseUrl = "https://www.staging.tax.service.gov.uk/",
          SIGN_IN_PAGE = "https://www.staging.tax.service.gov.uk/trader-services/pre-clearance/new-or-existing",
          DESTROY_PLANET = "https://www.staging.tax.service.gov.uk/agents-external-stubs/"
        )

      case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
    }
  }
}

object Environment extends Enumeration {
  type Name = Value
  val Local, Dev, Qa, Staging = Value
}