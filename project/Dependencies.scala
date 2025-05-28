import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"            %% "ui-test-runner"          % "0.45.0",
    "org.scalatestplus"      %% "selenium-4-12"           % "3.2.17.0",
    "io.cucumber"            %% "cucumber-scala"          % "8.21.0",
    "io.cucumber"             % "cucumber-junit"          % "7.18.0",
    "com.novocode"            % "junit-interface"         % "0.11"
  ).map(_ % Test)
}
