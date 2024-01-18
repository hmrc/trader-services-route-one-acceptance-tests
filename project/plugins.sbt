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

addSbtPlugin("uk.gov.hmrc"   % "sbt-auto-build" % "3.19.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt"   % "2.5.2")
