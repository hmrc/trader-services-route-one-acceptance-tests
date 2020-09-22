#!/bin/bash
ENV=${1:-local}
BROWSER=${2:-chrome}
DRIVER=

sbt -Dbrowser=$BROWSER -Denvironment=$ENV $DRIVER "testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner"


#if [ "$BROWSER" = "chrome" ]; then
#    DRIVER="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver"
#elif [ "$BROWSER" = "firefox" ]; then
#    DRIVER="-Dwebdriver.gecko.driver=/usr/local/bin/geckodriver"
#fi