import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"                %% "webdriver-factory"         % "0.25.0"  % "test",
    "org.scalatest"              %% "scalatest"                 % "3.0.7"   % "test",
    "io.cucumber"                %% "cucumber-scala"            % "8.2.2"   % "test",
    "io.cucumber"                %  "cucumber-junit"            % "7.2.3"   % "test",
    "junit"                      %  "junit"                     % "4.12"    % "test",
    "com.novocode"               %  "junit-interface"           % "0.11"    % "test",
    "com.typesafe"               %  "config"                    % "1.3.2"   % "test",
    "org.seleniumhq.selenium"    %  "selenium-chrome-driver"    % "3.9.1"   % "test",
    "org.seleniumhq.selenium"    %  "selenium-support"          % "3.9.1"   % "test",
    "org.seleniumhq.selenium"    %  "selenium-firefox-driver"   % "3.9.1"   % "test",
    "org.jsoup"                  %  "jsoup"                     % "1.7.3"   % "test"
  )
}