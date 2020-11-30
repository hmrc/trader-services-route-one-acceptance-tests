@TraderService
Feature: A user wants to upload documents

  Scenario Outline: A user wants upload some documents
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Import CYA page
    And the user clicks Continue
    Then the user is on the First upload page
#    When the user clicks Continue and waits
#    Then the user should see "Error:Select a file" error message for "upload-file"
    When the user clicks the button to upload and selects "first" file
    Then ensure the user is on the correct New page and click continue if not
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc test.jpg on upload review page
    
    Then the user selects NoOption to to uploading another file
    And the user should see "Error:Select yes if you want to upload another document" error message for "uploadAnotherFile"

    Then the user selects Yes to to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects "next" file
    Then ensure the user is on the correct New page and click continue if not
    Then the user should be on the new file upload confirmation page after uploading 2 document/s

    Then the user selects Yes to to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects "last" file
    Then ensure the user is on the correct New page and click continue if not
    Then the user should be on the new file upload confirmation page after uploading 3 document/s
    Then the user clicks the button to remove a document
    Then the user should be on the new file upload confirmation page after uploading 2 document/s
    Then the user selects Yes to to uploading another file
    Then the user is on the Another upload page
    When the user clicks the button to upload and selects "last" file
    Then ensure the user is on the correct New page and click continue if not
    Then the user should be on the new file upload confirmation page after uploading 3 document/s
    Then the user selects No to to uploading another file
    Then the user is on the New confirmation page

    Examples:
| epu | entryNo | requestType | route   | priority                | transport | name       | email      |
| 113 | 993456A | New         | Route 3 | Explosives or fireworks | Maritime  | Abc Testb  | a@test.com |


#    Steps for file verification page (inaccessible via standard stub - too quick)

#    Then the user should be on the first file uploading page
#    Then the user should be on the file upload confirmation page
#    When the user chooses to upload another document and selects the "second" file
#    Then the user should be on the <any> file uploading page
#    Then the user should be on the file upload confirmation page
