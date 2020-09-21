#@TraderService @ZAP
#
#    When the user enters the following information
#      | Service name     | trader-services-route-one-frontend      |
#      | Redirect url     | /trader-services                        |
#      | Enrolment key    | HMRC-MTD-TBC                            |
#
#
#Feature: An enrolled user wants to submit a new route one request
#
#  Scenario: Enter Consignment Information
#    Given the user is on the consignment number page
#    When the user enters the EPU & Entry Number(.*) and (.*)
#    When the user enters the date (.*) (.*) (.*)
#
#      | EPU | EntryNo |day | month | year |
#      | 669 | A123456 | 01 | 01    | 2020 |
#
#    And the user clicks Continue
