@TraderServiceErrors
Feature: Error - no options selected & amend validation

  Scenario Outline: Questions pages: error validation - no options selected
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue

    Then the user will be on the <journey> Request type page
    When the user clicks continue
    Then the user should see "Error:Select the type of import request" error message for "requestType"

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user clicks continue
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Route type page, selects <route> and continues

    Then the user will be on the <journey> YN Priority page
    When the user clicks continue
    Then the user should see "Error:Select yes if you’re importing priority goods" error message for "hasPriorityGoods"

    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user will be on the <journey> Priority Goods page
    When the user clicks continue
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"

    When the user is on the Priority Goods page, selects <priority> and continues
    Then the user will be on the ALVS page
    When the user clicks continue
    Then the user should see "Error:Select yes if you’re using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS page, selects No and continues

    Then the user will be on the <journey> Transport type page
    When the user clicks continue
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page

    Examples:
      | journey | epu | entryNo | requestType | route   | priority      | transport |
      | Import  | 123 | 123456A | New         | Route 1 | Human remains | Maritime  |


  Scenario Outline: Amend case journey (error validation)
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "no" characters for case reference number and continues
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters "tooFew" characters for case reference number and continues
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters "tooMany" characters for case reference number and continues
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters "<caseRef>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user clicks continue
    Then the user should see "Error:Select how you want to send us more information" error message for "typeOfAmendment"

    Then the user is on the Amendment type page, selects <amendType> and continues
    When the user enters "no" characters in the write response field and continues
    Then the user should see "Error:Enter a response to a query from HMRC" error message for "responseText"
    When the user enters "too many" characters in the write response field and continues
    Then the user should see "Error:Response must be 1000 characters or fewer" error message for "responseText"

    Examples:
      | journey | caseRef | amendType      |
      | Amend   | valid   | writeAndUpload |