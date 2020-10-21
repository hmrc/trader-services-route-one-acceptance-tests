@TraderService
Feature: Pre-clearance - Import Journeys

  Scenario Outline: A user wants to complete a New IMPORT RouteOne journey
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import Vessel Page
    Then the user clicks Continue
    Then the user is on the Import Contact Details Page
#    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Import CYA page
    Then the user should see the EPU row & the correct response <epu> on the CYA page
    And the user should see the Entry No row & the correct response <entryNo> on the CYA page
    And the user should see the Entry Date row & the correct response "1 October 2020" on the CYA page
    Then the user should see the Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    And the user should see the Priority Goods row & the correct response <priority> on the CYA page
    And the user should see the ALVS row & the correct response Yes on the CYA page
    And the user should see the Import transport row & the correct response <transport> on the CYA page
    Then the user should see the Vessel Name row & the correct response - on the CYA page
    And the user should see the Vessel Date row & the correct response "-" on the CYA page
    And the user should see the Vessel Time row & the correct response "-" on the CYA page
    Then the user should see the Contact details row & the correct response <email> on the CYA page
#Check for NAME & Email?

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority    | transport | name       | email          |
      | 123 | 123456A | 01  | 10    | 2020 |New      | Route 6 | Human remains | Air       | Abc Testb  | valid@test.com |


#  Scenario Outline: A user wants to complete a HOLD EXPORT RouteOne journey (Skips route, mandatory Vessel Qs)
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    When the user is on the Import Request Type page and selects <requestType>
#    Then the user is on the Import YesNo Priority Page and selects No
#    Then the user is on the ALVS Page and selects No
#    Then the user is on the Import Transport Type Page and selects <transport>
#    Then the user is on the Mandatory-Import Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "01" "11" "2021"
#    Then the user enters a time for the vessel "10" "10"
#    Then the user is on the Import contact details page
#
#    Examples:
#      | epu | entryNo | day | month | year |requestType | transport |
#      | 123 | 123456A | 01  | 10    | 2020 |Hold        | Maritime  |

#  Scenario Outline: A user wants to complete a Route-Hold EXPORT RouteOne journey
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    When the user is on the Import Request Type page and selects <requestType>
#    Then the user is on the Import Route Type Page and selects <route>
#    Then the user is on the Import YesNo Priority Page and selects No
#    Then the user is on the ALVS Page and selects No
#    Then the user is on the Import Transport Type Page and selects <transport>
#    Then the user is on the Mandatory-Import Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "01" "11" "2021"
#    Then the user enters a time for the vessel "10" "10"
#
#    Examples:
#      | epu | entryNo | day | month | year |requestType | route | transport |
#      | 123 | 123456A | 01  | 10    | 2020 |New         | Hold  | Maritime  |


  Scenario Outline: A user wants to complete a Cancellation IMPORT RouteOne journey
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import Vessel Page
    Then the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters an email address "<email>"
    When the user clicks Continue
    Then the user is on the Import CYA page

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority     | transport | email   |
      | 123 | 123456A | 01  | 10    | 2020 |Cancellation    | Route 6 | Human remains | Air       | a@a.com |


  Scenario Outline: Error validation - no options selected (Question pages only)
    Given the user is on the landing page for trader services
    Then the user clicks the link to enter the route1 journey
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects NoOption
    Then the user should see "Error:Select the type of import request" error message for "requestType"
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects None
    Then the user should see "Error:Select yes if you're moving priority goods" error message for "hasPriorityGoods"
    When the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects NoOption
    Then the user should see "Error:Select yes if you're using an Automatic Licence Verification System (ALVS)" error message for "hasALVS"
    Then the user is on the ALVS Page and selects No
    Then the user is on the Import Transport Type Page and selects NoOption
    Then the user should see "Error:Select the type of transport you're using" error message for "freightType"

    Examples:
      | epu | entryNo | day | month | year |requestType | route     | priority |
      | 123 | 123456A | 01  | 09    | 2020 |New         | Route 1 CAP | Art      |