#!/bin/bash -e

BROWSER=${1:-chrome}
ENVIRONMENT=${2:-local}

sbt clean -Dbrowser="${BROWSER}" -Denvironment="${ENVIRONMENT}" -Dbrowser.usePreviousVersion=true -Dbrowser.option.headless=true "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner" testReport
