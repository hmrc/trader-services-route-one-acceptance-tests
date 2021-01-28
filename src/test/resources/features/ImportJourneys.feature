@TraderService
Feature: Customs check - Import Journeys

  Scenario Outline: A user wants to complete a New Import journey
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks Continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects Yes
    Then the user is on the Import Priority Options Page and selects <priority>
    When the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects "first" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects No to uploading another file
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    When the user clicks the send docs link on the New confirmation page they will go back to the start
    # nothing pre filled

    Examples:
      | epu | entryNo |requestType | route   | priority      | transport | name   | email          |
      | 123 | 123456A |New         | Route 6 | Human remains | Air       | Mr. F  | valid@test.com |



  Scenario Outline: Route-Hold: A user should reach the mandatory vessel page
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects No
    Then the user is on the ALVS Page and selects No
    When the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Mandatory Vessel Page

    Examples:
      | epu | entryNo |requestType  | route | transport |
      | 123 | 123456A |Cancellation | Hold | Maritime   |
