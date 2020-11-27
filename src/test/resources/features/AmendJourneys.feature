@TraderService
Feature: Amend Journeys

  Scenario: Amend case (error validation)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters no characters for case reference number
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters tooFew characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters tooMany characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects noOption
    Then the user should see "Error:Select how you want to send us more information" error message for "typeOfAmendment"

    When the user is on the how to respond page and selects uploadOnly
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user navigates to the landing page for trader services

  Scenario: A user wants to amend their case details (write response only)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects writeOnly
    Then the user is on the write response page
    When the user enters a response with no characters
    Then the user should see "Error:Enter a response to a query from HMRC" error message for "responseText"
    When the user enters a response with tooMany characters
    Then the user should see "Error:Response must be 1000 characters or fewer" error message for "responseText"
    When the user enters a response with valid characters
#    Then the user is on the final confirmation page

  Scenario: A user wants to amend their case details (upload only)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects uploadOnly
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    Then the user selects Yes to to uploading another file
    Then the user is on the AnotherAmend upload page
    Then the user clicks the button to upload and selects "next" file
    Then the user should be on the amend file upload confirmation page after uploading 2 document/s
    Then the user selects No to to uploading another file
#Then the user is on the final confirmation page

  Scenario: Amend: A user wants to amend their case details (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    When the user is on the how to respond page and selects write&Upload
    Then the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    Then the user selects No to to uploading another file
#Then the user is on the final confirmation page - rework THIS


