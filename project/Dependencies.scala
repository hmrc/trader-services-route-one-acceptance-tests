import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"            %% "webdriver-factory"       % "0.45.0"   % Test,
    "org.scalatest"          %% "scalatest"               % "3.2.15"   % Test,
    "org.scalatestplus"      %% "selenium-4-2"            % "3.2.13.0" % Test,
    "io.cucumber"            %% "cucumber-scala"          % "8.14.1"   % Test,
    "io.cucumber"             % "cucumber-junit"          % "7.11.1"   % Test,
    "junit"                   % "junit"                   % "4.13.2"   % Test,
    "com.novocode"            % "junit-interface"         % "0.11"     % Test,
    "com.typesafe"            % "config"                  % "1.4.2"    % Test,
    "org.seleniumhq.selenium" % "selenium-chrome-driver"  % "4.8.1"    % Test,
    "org.seleniumhq.selenium" % "selenium-support"        % "4.8.1"    % Test,
    "org.seleniumhq.selenium" % "selenium-firefox-driver" % "4.8.1"    % Test,
    "org.jsoup"               % "jsoup"                   % "1.15.4"   % Test
  )
}
