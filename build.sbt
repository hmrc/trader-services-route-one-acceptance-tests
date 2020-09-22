lazy val testSuite = (project in file("."))
  .enablePlugins(SbtAutoBuildPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "trader-services-route-one-acceptance-tests",
    version := "0.1.0",
    scalaVersion := "2.12.12",
    scalacOptions ++= Seq("-feature"),
    libraryDependencies ++= Dependencies.test,
      //The testOptions from SbtAutoBuildPlugin supports only ScalaTest. Resetting testOptions for Cucumber Tests.
      testOptions in Test := Seq.empty,
    resolvers ++= Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      Resolver.typesafeRepo("releases"),
      "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
    )
  )

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-chrome-driver" % "3.9.1",
  "org.seleniumhq.selenium" % "selenium-support" % "3.9.1",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "3.9.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "info.cukes" %% "cucumber-scala" % "1.2.5" % "test",
  "info.cukes" % "cucumber-junit" % "1.2.5" % "test",
  "info.cukes" % "cucumber-picocontainer" % "1.2.5" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.8.0",
  "com.typesafe" % "config" % "1.3.2",
  "uk.gov.hmrc" %% "zap-automation" % "2.6.0",
  "uk.gov.hmrc" %% "webdriver-factory" % "0.10.0"
)