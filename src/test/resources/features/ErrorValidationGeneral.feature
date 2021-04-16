@TraderServiceErrors
Feature: Error - no options selected & amend validation

#  Import
  Scenario Outline: Import questions: error validation - no options selected
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request type page, selects NoOption and continues
    Then the user should see "Error:Select the type of import request" error message for "requestType"
    When the user is on the Import Request type page, selects <requestType> and continues
    Then the user is on the Import Route type page, selects NoOption and continues
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Import Route type page, selects <route> and continues
    Then the user is on the Import YesNo Priority page, selects None and continues
    Then the user should see "Error:Select yes if you’re importing priority goods" error message for "hasPriorityGoods"
    When the user is on the Import YesNo Priority page, selects Yes and continues
    When the user is on the Import Priority Goods page, selects NoOption and continues
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Import Priority Goods page, selects <priority> and continues
    Then the user is on the ALVS page, selects NoOption and continues
    Then the user should see "Error:Select yes if you’re using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS page, selects No and continues
    When the user is on the Import Transport type page, selects NoOption and continues
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
      | epu | entryNo | requestType | route       | priority      |
      | 123 | 123456A | New         | Route 1 CAP | Human remains |

#  Export
  Scenario Outline: Export questions: error validation - no options selected
    Given the user is on the start page for trader services, selects New and continues
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request type page, selects NoOption and continues
    Then the user should see "Error:Select the type of export request" error message for "requestType"
    When the user is on the Export Request type page, selects <requestType> and continues
    Then the user is on the Export Route type page, selects NoOption and continues
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Export Route type page, selects <route> and continues
    Then the user is on the Export YesNo Priority page, selects None and continues
    Then the user should see "Error:Select yes if you’re exporting priority goods" error message for "hasPriorityGoods"
    When the user is on the Export YesNo Priority page, selects Yes and continues
    When the user is on the Export Priority Goods page, selects NoOption and continues
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Export Priority Goods page, selects <priority> and continues
    Then the user is on the Export Transport type page, selects NoOption and continues
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
      | epu | entryNo | requestType  | route       | priority      |
      | 123 | A23456A | Cancellation | Route 1 CAP | Human remains |

# Amend
  Scenario: Amend case journey (error validation)
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "no" characters for case reference number and continues
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters "tooFew" characters for case reference number and continues
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters "tooMany" characters for case reference number and continues
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters "valid" characters for case reference number and continues
    Then the user is on the Amendment type page, selects noOption and continues
    Then the user should see "Error:Select how you want to send us more information" error message for "typeOfAmendment"

    Then the user is on the Amendment type page, selects writeAndUpload and continues
    When the user enters "no" characters in the write response field and continues
    Then the user should see "Error:Enter a response to a query from HMRC" error message for "responseText"
    When the user enters "too many" characters in the write response field and continues
    Then the user should see "Error:Response must be 1000 characters or fewer" error message for "responseText"
    When the user enters "valid" characters in the write response field and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
