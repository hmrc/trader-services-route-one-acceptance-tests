@TraderService

Feature: Customs check - Import journeys

  Scenario Outline: A user wants to complete a New Import journey
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
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "doc" file
    Then the user clicks continue when files have finished uploading

    Then the user is on the Import CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Import Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    Then the user should see the Vessel Name row & the correct response "-" on the CYA page
    And the user should see the Vessel Date Arrival row & the correct response "-" on the CYA page
    And the user should see the Vessel Time Arrival row & the correct response "-" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phone>" on the CYA page
    And the user clicks submit on the CYA page

    Then the user is on the New confirmation page
    Then the user will see text to give-feedback
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | ALVS | transport | name      | email          | phone         | entryDateCYA |
      | 093 | 127756A | New         | Route 6 | Human remains | Yes  | Air       | Abc Testb | valid@test.com | 01234 567 899 | Today        |


  Scenario Outline: A user wants to complete a Cancellation Import journey
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
    When the user clicks the button to upload the first file and selects the "docx" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    And the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to cancel
    When the user clicks the feedback they will be redirected to the appropriate page

#    And the user should see Maritime-Import SLA

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | name  | email          |
      | 555 | 151511c | Cancellation | Route 6 | Human remains | Maritime  | Mr. F | valid@test.com |

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
      | epu | entryNo | requestType | route | transport |
      | 123 | 123456A | New         | Hold  | Maritime  |