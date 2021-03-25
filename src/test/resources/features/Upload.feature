@TraderServiceUploads
Feature: A user wants to upload documents

  Scenario Outline: A user wants upload some documents
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    Then the user is on the Import YesNo Priority page and selects Yes
    When the user is on the Import Priority Goods page and selects <priority>
    Then the user is on the ALVS page and selects Yes
    Then the user is on the Import Transport type page and selects <transport>
    Then the user is on the Import-Optional Transport page
    And the user clicks Continue
    Then the user is on the Import contact details page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks Continue
    Then the user navigates to the single file New upload page
    When the user clicks SFU Upload
    And the user waits 250
    Then the user should see "Error:Select a file" error message for "file"
    When the user clicks the button to upload and selects the "pdf" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc testPdf.pdf on upload review page

    Then the user selects NoOption to uploading another file
    And the user should see "Error:Select yes if you want to upload another document" error message for "uploadAnotherFile"

    Then the user selects Yes to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects the "png" file
    Then the user should be on the new file upload confirmation page after uploading 2 document/s

    Then the user selects Yes to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects the "jpeg" file
    Then the user should be on the new file upload confirmation page after uploading 3 document/s
    Then the user clicks the button to remove a document
    Then the user should be on the new file upload confirmation page after uploading 2 document/s
    Then the user selects Yes to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects the "pdf" file
    Then the user should be on the new file upload confirmation page after uploading 3 document/s
    Then the user selects No to uploading another file
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA

    Examples:
      | epu | entryNo | requestType | route   | priority                | transport    | name      | email      |
      | 113 | 993456A | New         | Route 3 | Explosives or fireworks | RoadRoRoRail | Abc Testb | a@test.com |
