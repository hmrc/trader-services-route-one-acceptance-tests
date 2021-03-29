@TraderService2

Feature: Customs check - Import journeys

  Scenario Outline: A user wants to complete a New Import journey & see the Air SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    When the user is on the Import YesNo Priority page and selects Yes
    Then the user is on the Import Priority Goods page and selects <priority>
    When the user is on the ALVS page and selects Yes
    Then the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Optional transport details page
    And the user clicks continue
    Then the user is on the Import contact details page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    And the user clicks submit on the CYA page
    And the user waits 1000
    Then the user is on the New confirmation page
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | name  | email          |
      | 123 | 123456A | New         | Route 6 | Human remains | Air       | Mr. F | valid@test.com |


  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    When the user is on the Import YesNo Priority page and selects No
    Then the user is on the ALVS page and selects No
    When the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Mandatory transport details page

    Examples:
      | epu | entryNo | requestType  | route | transport |
      | 123 | 123456A | Cancellation | Hold  | Maritime  |


  Scenario Outline: A user wants to complete a New Import journey & see the appropriate Maritime SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    When the user is on the Import YesNo Priority page and selects Yes
    Then the user is on the Import Priority Goods page and selects <priority>
    When the user is on the ALVS page and selects Yes
    Then the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Optional transport details page
    And the user clicks continue
    Then the user is on the Import contact details page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    And the user clicks submit on the CYA page
    Then the user is on the New confirmation page
#    And the user should see Maritime-Import SLA

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | name  | email          |
      | 555 | 151511c | New         | Route 6 | Human remains | Maritime  | Mr. F | valid@test.com |