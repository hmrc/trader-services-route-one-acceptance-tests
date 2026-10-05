import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"            %% "ui-test-runner"          % "0.56.0",
    "org.scalatestplus"      %% "selenium-4-21"           % "3.2.19.0",
    "com.novocode"            % "junit-interface"         % "0.11"
  ).map(_ % Test)
}
