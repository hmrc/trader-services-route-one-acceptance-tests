lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) // Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "trader-services-route-one-acceptance-tests",
    version := "0.1.0",
    scalaVersion := "3.3.7",
    scalacOptions ++= Seq("-feature"),
    libraryDependencies ++= Dependencies.test
  )
