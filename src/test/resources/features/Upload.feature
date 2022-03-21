@TraderService
#  Tests for SFU (replaced by MFU which is tested via QA runner/manually & as part of standard journey flow tests)

Feature: A user wants to upload documents (Single file)

  Scenario Outline: A user wants upload some documents
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects No and continues
    Then the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import Contact details page
    Then the user enters an email address "<email>"
    And the user clicks continue
    Then the user navigates to the single file New upload page
    When the user clicks the button to upload and selects the "pdf" file
    Then the user should be on the new file upload confirmation page
    Then the user should see their first uploaded doc on upload review page

    Then the user selects Yes to uploading another file
    Then the user will be on the Another upload page
    When the user clicks the button to upload and selects the "png" file
    Then the user should be on the new file upload confirmation page

    Then the user selects Yes to uploading another file
    Then the user will be on the Another upload page
    When the user clicks the button to upload and selects the "jpeg" file
    Then the user should be on the new file upload confirmation page
    Then the user clicks the button to remove a document
    Then the user should be on the new file upload confirmation page
    Then the user selects Yes to uploading another file
    Then the user will be on the Another upload page
    When the user clicks the button to upload and selects the "doc" file
    Then the user should be on the new file upload confirmation page
    Then the user selects No to uploading another file
    Then the user will be on the Import CYA page
    And the user clicks submit on the CYA page
    Then the user will be on the New confirmation page

    Examples:
      | epu       | entryNo  | requestType | route   | transport    | email      |
      | randomEPU | importEN | New         | Route 1 | RoadRoRoRail | a@test.com |
