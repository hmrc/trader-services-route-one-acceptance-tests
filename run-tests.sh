#!/bin/bash -e

BROWSER=${1:-chrome}
ENVIRONMENT=${2:-local}

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner" testReport
