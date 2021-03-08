@TraderServiceErrors
Feature: Error - no options selected

#  Import
  Scenario Outline: Import questions: error validation - no options selected
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects NoOption
    Then the user should see "Error:Select the type of import request" error message for "requestType"
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects None
    Then the user should see "Error:Select yes if you’re importing priority goods" error message for "hasPriorityGoods"
    When the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects NoOption
    Then the user should see "Error:Select yes if you’re using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS Page and selects No
    Then the user is on the Import Transport Type Page and selects NoOption
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
    | epu | entryNo | requestType | route       | priority       |
    | 123 | 123456A | New         | Route 1 CAP | Human remains |

#  Export
  Scenario Outline: Export questions: error validation - no options selected
    Given the user is on the start page for trader services and selects New
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects NoOption
    Then the user should see "Error:Select the type of export request" error message for "requestType"
    When the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects None
    Then the user should see "Error:Select yes if you’re exporting priority goods" error message for "hasPriorityGoods"
    When the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Options Page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export Transport Type Page and selects NoOption
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
    | epu | entryNo | requestType  | route       | priority       |
    | 123 | A23456A | Cancellation | Route 1 CAP | Human remains  |



