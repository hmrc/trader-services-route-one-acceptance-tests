#!/bin/bash

sbt -Dbrowser=remote-chrome -Denvironment=staging "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunnerStaging"
