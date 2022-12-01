import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"            %% "webdriver-factory"       % "0.38.0"   % Test,
    "org.scalatest"          %% "scalatest"               % "3.2.13"   % Test,
    "org.scalatestplus"      %% "selenium-4-2"            % "3.2.13.0" % Test,
    "io.cucumber"            %% "cucumber-scala"          % "8.6.0"    % Test,
    "io.cucumber"             % "cucumber-junit"          % "7.8.0"    % Test,
    "junit"                   % "junit"                   % "4.13.2"   % Test,
    "com.novocode"            % "junit-interface"         % "0.11"     % Test,
    "com.typesafe"            % "config"                  % "1.4.2"    % Test,
    "org.seleniumhq.selenium" % "selenium-chrome-driver"  % "4.4.0"    % Test,
    "org.seleniumhq.selenium" % "selenium-support"        % "4.4.0"    % Test,
    "org.seleniumhq.selenium" % "selenium-firefox-driver" % "4.4.0"    % Test,
    "org.jsoup"               % "jsoup"                   % "1.15.3"   % Test
  )
}
