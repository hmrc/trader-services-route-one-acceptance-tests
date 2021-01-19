@TraderService
Feature: Amend Journeys

  Scenario: Amend case journey (error validation)
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

    Then the user is on the how to respond page and selects writeAndupload
    When the user enters a response with no characters
    Then the user should see "Error:Enter a response to a query from HMRC" error message for "responseText"
    When the user enters a response with tooMany characters
    Then the user should see "Error:Response must be 1000 characters or fewer" error message for "responseText"
    When the user enters a response with valid characters
    
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user clicks the banner link to return to the landing page

  Scenario: A user wants to add a message to their case (write response only)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects writeOnly
    Then the user is on the write response page
    When the user enters a response "Sample message" and continues
    Then the user is on the Amend writeOnly review page and should see their responses
    And the user should see what they entered as their message "Sample message"
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page

  Scenario: A user wants to add another document to a case (upload only)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects uploadOnly
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    Then the user selects Yes to uploading another file
    Then the user is on the AnotherAmend upload page
    Then the user clicks the button to upload and selects "next" file
    Then the user should be on the amend file upload confirmation page after uploading 2 document/s
    Then the user selects No to uploading another file
    Then the user is on the Amend uploadOnly review page and should see their responses
    And the user should see what the files they uploaded "test.jpg"
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page

  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    When the user is on the how to respond page and selects writeAndupload
    Then the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    Then the user selects No to uploading another file
    Then the user is on the Amend writeAndupload review page and should see their responses
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page
