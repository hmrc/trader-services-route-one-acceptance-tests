@TraderService
Feature: Back Links & Change Links - Amend


  Scenario: Amend: A user wants to change their request type and information via the CYA page
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
    Then the user selects No to uploading another file
    Then the user is on the Amend writeAndupload review page

    When the user clicks the change link on the amend review page for caseRef
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    When the user is on the how to respond page and selects writeOnly
    And the user enters a response with valid characters
    Then the user is on the Amend writeOnly review page

    When the user clicks the change link on the amend review page for message
    Then the user is on the write response page
    And the user enters a response "Sample message for PEGA" and continues

    When the user clicks the change link on the amend review page for amendment
    Then the user is on the how to respond page and selects uploadOnly
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects "first" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user selects No to uploading another file
    Then the user is on the Amend uploadOnly review page
    When the user clicks the change link on the amend review page for documents
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user selects Yes to uploading another file
    Then the user clicks the button to upload and selects "next" file
    Then the user should be on the amend file upload confirmation page after uploading 2 document/s
    Then the user selects No to uploading another file
    Then the user is on the Amend uploadOnly review page
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page

    Scenario Outline: Amend Back links - A user wants to go back to the start
      Given the user is on the start page for trader services and selects <journey>
      Then the user is on the case ref number page
      When the user enters a case ref number "<caseRef>" and continues
      When the user is on the how to respond page and selects <amendType>
      Then the user is on the write response page
      And the user enters a response "<text>" and continues
      Then the user is on the Amend upload page
      Then the user clicks the button to upload and selects "first" file
      Then the user should be on the amend file upload confirmation page after uploading 1 document/s
      Then the user should see their first uploaded doc test.jpg on upload review page
      When the user selects No to uploading another file
      Then the user is on the Amend writeAndupload review page
      Then the user clicks back
      Then the user should be on the amend file upload confirmation page after uploading 1 document/s
      Then the user clicks back
      Then the user is on the write response page
      And the details in the text box should be pre-filled with "<text>"
      When the user clicks back
      Then the user is on the how to respond page
      And the last selected option for type of amendment should be <amendType>
      When the user clicks back
      Then the user is on the case ref number page
      And the details in the case ref field should be pre-filled with "<caseRef>"
      When the user clicks back
      Then the user is on the start page for trader services
      And the last selected option for journey type should be pre filled with <journey>
      Then the user clicks the banner link to return to the landing page

      Examples:
      | journey  | caseRef                | amendType    | text      |
      |  Amend   | PC12010081330XGBNZJO04 | write&Upload | test text |
