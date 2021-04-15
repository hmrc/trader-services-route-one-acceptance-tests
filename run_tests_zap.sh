#!/usr/bin/env bash

ENV=${1:-local}
BROWSER=${2:-chrome}
REMOTE=${3:-false}

echo "Starting ZAP Daemon..."

/Applications/OWASP\ ZAP.app/Contents/Java/zap.sh -daemon -config api.disablekey=true -port 11000 &
ZAP_PID=$!
sleep 10
echo "Running browser tests..."
sbt -Denv=${ENV} -Dbrowser=${BROWSER} -Dzap.proxy=true "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunZap"

sleep 2
echo "Running Zap tests..."
sbt "testOnly uk.gov.hmrc.test.ui.cucumber.runner.ZapRunner"

if [[ "${REMOTE}" == "false" ]] ; then
  echo "Killing Zap Daemon..."
  kill ${ZAP_PID}
fi