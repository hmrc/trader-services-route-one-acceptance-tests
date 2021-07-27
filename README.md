**This is a template README.md.  Be sure to update this with project specific content that describes your ui test project.**

# trader-services-route-one-acceptance-tests
UI test suite for `Trader Services` using WebDriver and `Cucumber`.  

## Running the tests

Prior to executing the tests ensure you have:
 - Appropriate [drivers installed](#install-driver-binary) - to run tests against locally installed Browser
 - Installed [MongoDB](https://docs.mongodb.com/manual/installation/) 
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  
 - Docker - to run a Chrome or Firefox browser inside a container (Optional)

Run the following command to start services locally:

    sm --start TRADER_SERVICES_ALL -f

Then execute the `run_tests.sh` script:

    **Standard runners
    ./run_tests.sh - runs locally (ensure SM profile above is running)
    ./run_tests_errors.sh - runs tests involving error pages & messages etc ('unhappy paths')
    
    ./run_tests.sh <environment> <browser-driver>
    ie. /run_tests.sh dev chrome
    
    **QA runner (Runs a handful of generic smoke test journeys for export/import/amend)
    ./run_tests_qa.sh
    
    **Further Runners:
    *Accessiblity: run_tests_accessiblity.sh 
        *this won't run in the browser but you can run them locally to make sure they pass before running them in jenkins


The `run_tests.sh` script defaults to the `local` environment with the locally installed `chrome` driver binary.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 - [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**

## Running tests against a containerised browser - on a developer machine

The script `./run-browser-with-docker.sh` can be used to start a Chrome or Firefox container on a developer machine. 
The script requires `remote-chrome` or `remote-firefox` as an argument.

Read more about the script's functionality [here](run-browser-with-docker.sh).

To run against a containerised Chrome browser:

```bash
./run-browser-with-docker.sh remote-chrome 
./run_tests.sh local remote-chrome
```

`./run-browser-with-docker.sh` is **NOT** required when running in a CI environment. 

#### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

For example, to execute the `run_tests.sh` script against Staging  environment using Chrome remote-webdriver

    ./run_tests.sh staging remote-chrome

#### zap-automation config
ZAP tests are now run through DAST runner (in Jenkins).

Alert filtering is still set up within this repo

For more information about ZAP tests, please refer to the `zap-automation` [documentation](https://github.com/hmrc/zap-automation/blob/master/README.md).

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/master/README.md/#user-content-running-tests-using-browser-stack) project.

## [Installing local driver binaries](#install-driver-binaries)

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers. 

See the `drivers/` directory for some helpful scripts to do the installation work for you.  They should work on both Mac and Linux by running the following command:

    ./installGeckodriver.sh <operating-system> <driver-version>
    or
    ./installChromedriver <operating-system> <driver-version>
    
    You can also try the following commands in terminal for mac:
    brew install chromedriver
    brew install geckodriver
    
    Occassionaly these may need updated:
    brew upgrade chromedriver
    brew upgrade geckodriver

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome.  You can, however, however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter your password.*