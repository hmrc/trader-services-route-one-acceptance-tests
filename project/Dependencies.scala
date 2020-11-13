import sbt.Keys.resolvers
import sbt._

object Dependencies {

  val ScalatestVersion = "3.0.5"
  val CucumberVersion = "1.2.5"

  val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")  //Related to jenkins


  resolvers ++= Seq(
    "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
    //  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
    "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

  //resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
  resolvers += "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"


  val test = Seq(
    "uk.gov.hmrc"                %% "webdriver-factory"       % "0.10.0" % Test,
    "org.scalatest"              %% "scalatest"               % "3.0.7"  % Test,
    "io.cucumber"                %% "cucumber-scala"          % "6.1.1" % Test,
    "io.cucumber"                %  "cucumber-junit"          % "6.1.1" % Test,
    "junit"                      %  "junit"                   % "4.12"  % Test,
    "com.novocode"               %  "junit-interface"         % "0.11"  % Test,
    "uk.gov.hmrc"                %% "zap-automation"          % "2.7.0" % Test,
    "com.typesafe"               %  "config"                  % "1.3.2" % Test,
    "org.seleniumhq.selenium"    % "selenium-chrome-driver"   % "3.9.1" % Test,
    "org.seleniumhq.selenium"    % "selenium-support"         % "3.9.1" % Test,
    "org.seleniumhq.selenium"    % "selenium-firefox-driver"  % "3.9.1" % Test,
    "uk.gov.hmrc" %% "extent-report" % "0.7.0",
    "com.aventstack" % "extentreports" % "4.0.9" % "provided",
    "org.jsoup" % "jsoup" % "1.7.3" % "test",
    "info.cukes" % "cucumber-junit" % CucumberVersion % "test",
    "info.cukes" % "cucumber-picocontainer" % CucumberVersion % "test",
    "info.cukes" %% "cucumber-scala" % CucumberVersion % "test"
  )

  <dependency>
    <groupId>com.vimalselvam</groupId>
    <artifactId>cucumber-extentsreport</artifactId>
    <version>3.0.2</version>
  </dependency>


    <dependency>
      <groupId>com.aventstack</groupId>
      <artifactId>extentreports</artifactId>
      <version>3.1.2</version>
    </dependency>

}