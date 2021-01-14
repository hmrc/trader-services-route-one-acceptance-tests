@TraderServiceErrors
Feature: Error Pages

  Scenario Outline: A user enters a duplicate case
    Given the user is on the start page for trader services and selects New
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
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user enters an email address "<email>"
    When the user enters a name "<name>"
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects "first" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects No to to uploading another file
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user will be on the duplicate case error page
    When the user clicks the link to add documents they will be redirected to amend journey

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | vesselName  | name  | email   |
      | 667 | A23456A | Cancellation | Route 2 | Human remains | Air       | Test Vessel | Mr. F | a@a.com |


  Scenario: A user hits the wrong url
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user navigates to the following /declaration-detailx
    Then the user is on the error page for page not found
    When the user clicks the link on the page not found they will be on the start page


