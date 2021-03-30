@TraderServiceErrors
Feature: Error - no options selected & amend validation

#  Import
  Scenario Outline: Import questions: error validation - no options selected
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request Type page and selects NoOption
    Then the user should see "Error:Select the type of import request" error message for "requestType"
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Import Route Type page and selects <route>
    Then the user is on the Import YesNo Priority page and selects None
    Then the user should see "Error:Select yes if you’re importing priority goods" error message for "hasPriorityGoods"
    When the user is on the Import YesNo Priority page and selects Yes
    When the user is on the Import Priority Goods page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Import Priority Goods page and selects <priority>
    Then the user is on the ALVS page and selects NoOption
    Then the user should see "Error:Select yes if you’re using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS page and selects No
    Then the user is on the Import transport type page and selects NoOption
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
      | epu | entryNo | requestType | route       | priority      |
      | 123 | 123456A | New         | Route 1 CAP | Human remains |

#  Export
  Scenario Outline: Export questions: error validation - no options selected
    Given the user is on the start page for trader services and selects New
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects NoOption
    Then the user should see "Error:Select the type of export request" error message for "requestType"
    When the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects None
    Then the user should see "Error:Select yes if you’re exporting priority goods" error message for "hasPriorityGoods"
    When the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects NoOption
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
      | epu | entryNo | requestType  | route       | priority      |
      | 123 | A23456A | Cancellation | Route 1 CAP | Human remains |

# Amend
  Scenario: Amend case journey (error validation)
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters no characters for case reference number and clicks continue
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters tooFew characters for case reference number and clicks continue
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters tooMany characters for case reference number and clicks continue
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters valid characters for case reference number and clicks continue
    Then the user is on the how to respond page and selects noOption
    Then the user should see "Error:Select how you want to send us more information" error message for "typeOfAmendment"

    Then the user is on the how to respond page and selects writeAndUpload
    When the user enters a response with no characters
    Then the user should see "Error:Enter a response to a query from HMRC" error message for "responseText"
    When the user enters a response with tooMany characters
    Then the user should see "Error:Response must be 1000 characters or fewer" error message for "responseText"
    When the user enters a response with valid characters
    Then the user is on the multi-file upload pages for a/an Amend journey
