resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)
addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.0.0")