resolvers += MavenRepository(
  name = "HMRC-open-artefacts-maven2",
  root = "https://open.artefacts.tax.service.gov.uk/maven2"
)
resolvers += Resolver.url(
  name = "HMRC-open-artefacts-ivy",
  baseURL = url("https://open.artefacts.tax.service.gov.uk/ivy2")
)(
  Resolver.ivyStylePatterns
)

addSbtPlugin("uk.gov.hmrc"   % "sbt-auto-build" % "3.13.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt"   % "2.4.6")
