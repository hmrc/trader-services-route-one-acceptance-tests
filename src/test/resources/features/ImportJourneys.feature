@TraderService @ZAP
Feature: Pre-clearance - Import Journeys

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
    Then the user is on the Import CYA page
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects "first" file
    Then ensure the user is on the correct New page and click continue if not
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects No to to uploading another file
    Then the user is on the New confirmation page
    When the user clicks to submit documents they will be back on the start page

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


  Scenario Outline: Import questions: error validation - no options selected
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects NoOption
    Then the user should see "Error:Select the type of import request" error message for "requestType"
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects None
    Then the user should see "Error:Select yes if you’re importing priority goods" error message for "hasPriorityGoods"
    When the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects NoOption
    Then the user should see "Error:Select yes if you’re using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS Page and selects No
    Then the user is on the Import Transport Type Page and selects NoOption
    Then the user should see "Error:Select the type of transport you’re using" error message for "freightType"

    Examples:
      | epu | entryNo | requestType | route       | priority       |
      | 123 | 123456A | New         | Route 1 CAP | High value art |