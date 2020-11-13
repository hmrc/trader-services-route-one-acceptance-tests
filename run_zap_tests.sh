#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-firefox}
REMOTE=${3:-false}

sbt -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER -Dzap.proxy=true "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner"
sbt "testOnly uk.gov.hmrc.test.ui.ZapRunner"