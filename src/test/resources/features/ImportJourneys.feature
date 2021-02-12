@TraderService

Feature: Customs check - Import Journeys

  Scenario Outline: A user wants to complete a New Import journey & see the Air SLA
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
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks only clicks Continue when it's clickable
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA
    When the user clicks the send docs link on the NewSLA confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

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
      | epu | entryNo | requestType  | route | transport |
      | 123 | 123456A | Cancellation | Hold | Maritime   |

#WIP / local only
#  Scenario Outline: A user wants to complete a New Import journey & see the appropriate Maritime SLA
#    Given the user is on the start page for trader services and selects New
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters today's date for entryDate
#    Then the user clicks Continue
#    When the user is on the Import Request Type page and selects <requestType>
#    Then the user is on the Import Route Type Page and selects <route>
#    When the user is on the Import YesNo Priority Page and selects Yes
#    Then the user is on the Import Priority Options Page and selects <priority>
#    When the user is on the ALVS Page and selects Yes
#    Then the user is on the Import Transport Type Page and selects <transport>
#    Then the user is on the Import-Optional Vessel Page
#    And the user clicks Continue
#    Then the user is on the Import Contact Details Page
#    When the user enters a name "<name>"
#    When the user enters an email address "<email>"
#    And the user clicks Continue
#    Then the user is on the multi-file upload pages for a/an New journey
#    When the user clicks the button to upload the first file and selects the "odt" file
#    Then the user clicks only clicks Continue when it's clickable
#    Then the user is on the Import CYA page
#    And the user clicks Submit on the CYA page
#    Then the user is on the New confirmation page
#    And the user should see 3 Hour SLA
#    When the user clicks the send docs link on the NewSLA confirmation page they will go back to the start
#    And the last selected option for journey type should be pre filled with Nothing
#
#    Examples:
#      | epu | entryNo |requestType | route   | priority      | transport | name   | email          |
#      | 555 | 151511c |New         | Route 6 | Human remains | Maritime  | Mr. F  | valid@test.com |