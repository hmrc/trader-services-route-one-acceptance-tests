#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2

sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner" testReport
