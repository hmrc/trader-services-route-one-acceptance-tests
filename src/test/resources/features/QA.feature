@TraderServiceQA

Feature: Customs check - Export Journey

  Scenario Outline: A user wants to complete a New Export RouteOne journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Optional Vessel Page
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "12" "25"
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects the "pdf" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects Yes to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects the "jpeg" file
    Then the user should be on the new file upload confirmation page after uploading 2 document/s

    Then the user selects Yes to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects the "ods" file
    Then the user should be on the new file upload confirmation page after uploading 3 document/s

    Then the user selects No to uploading another file
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user copies the case reference number
    Then the user waits


Examples:
| epu | entryNo | requestType | route   | priority      | transport | vesselName  | name  | email   | phone |
| 235 | C11456A | C1601       | Route 1 | Human remains | Maritime  | Test Vessel |  mr c | informationy@xxq-logistics.com | 01296 427444      |



  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user is on the how to respond page and selects writeAndupload
    Then the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects the "png" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    Then the user selects No to uploading another file
    When the user clicks Submit on the CYA page
    Then the user waits


