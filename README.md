# trader-services-route-one-acceptance-tests
UI test suite for `Trader Services` using UITestRunner and `<scalatest/cucumber>`.  

## Running the tests

Prior to executing the tests ensure you have:
 - Installed [MongoDB](https://docs.mongodb.com/manual/installation/) 
 - Installed/configured [service manager 2](https://github.com/hmrc/sm2).  
 - Docker - to run a Chrome or Firefox browser inside a container (Optional)

Run the following command to start services locally:

    sm2 --start TRADER_SERVICES_ALL

## Tests

Run tests as follows:

* Argument `<browser>` must be `chrome`, `edge` or `firefox`.
* Argument `<environment>` must be `local`, `qa` or `staging`.

```bash
./run-tests.sh <browser> <environment>
```

## Running scalafmt

To apply scalafmt formatting using the rules configured in the .scalafmt.conf, run:

`sbt scalafmtAll`

To check the files have been formatted correctly, run:

`sbt scalafmtCheckAll`

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
