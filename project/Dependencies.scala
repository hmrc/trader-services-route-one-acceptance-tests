import sbt._

object Dependencies {

  val ScalatestVersion = "3.0.5"
  val CucumberVersion = "1.2.5"

  val test = Seq(
    "uk.gov.hmrc"                %% "webdriver-factory"       % "0.15.0" % "test",
    "org.scalatest"              %% "scalatest"               % "3.0.7"  % "test",
    "io.cucumber"                %% "cucumber-scala"          % "6.1.1" % "test",
    "io.cucumber"                %  "cucumber-junit"          % "6.1.1" % "test",
    "junit"                      %  "junit"                   % "4.12"  % "test",
    "com.novocode"               %  "junit-interface"         % "0.11"  % "test",
    "uk.gov.hmrc"                %% "zap-automation"          % "2.7.0" % "test",
    "com.typesafe"               %  "config"                  % "1.3.2" % "test",
    "org.seleniumhq.selenium"    % "selenium-chrome-driver"   % "3.9.1" % "test",
    "org.seleniumhq.selenium"    % "selenium-support"         % "3.9.1" % "test",
    "org.seleniumhq.selenium"    % "selenium-firefox-driver"  % "3.9.1" % "test",
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