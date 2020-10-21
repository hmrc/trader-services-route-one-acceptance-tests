@TraderService
Feature: Pre-clearance - Export Journeys

  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey
      Given the user is on the landing page for trader services
      When the user clicks the link to enter the route1 journey
      Then the user is on the declaration details page
        When the user enters declaration details "<epu>" and "<entryNo>"
        And the user enters a date "<day>" "<month>" "<year>"
        And the user clicks Continue
      Then the user is on the Export Request Type page and selects <requestType>
      Then the user is on the Export Route Type Page and selects <route>
      Then the user is on the Export YesNo Priority Page and selects Yes
      When the user is on the Export Priority Options Page and selects <priority>
      Then the user is on the Export Transport Type Page and selects <transport>
      Then the user is on the Export Vessel Page
        Then the user enters <vesselName> for vessel name
        And the user enters a date for the vessel "11" "10" "2020"
        Then the user clicks Continue
      Then the user is on the Export Contact Details Page
        And the user enters an email address ""
        And the user clicks Continue
      Then the user is on the Export CYA page
        Then the user should see the EPU row & the correct response <epu> on the CYA page
        And the user should see the Entry No row & the correct response <entryNo> on the CYA page
        And the user should see the Entry Date row & the correct response "1 September 2020" on the CYA page
        Then the user should see the Request Type row & the correct response <requestType> on the CYA page
        And the user should see the Route row & the correct response <route> on the CYA page
        Then the user should see the Priority YN row & the correct response Yes on the CYA page
        Then the user should see the Priority Goods row & the correct response <priority> on the CYA page
        And the user should see the Export Transport row & the correct response <transport> on the CYA page
        Then the user should see the Vessel Name row & the correct response <vesselName> on the CYA page
        And the user should see the Vessel Date row & the correct response "11 October 2020" on the CYA page
        And the user should see the Vessel Time row & the correct response "-" on the CYA page
        And the user should see the Contact details row & the blank response - on the CYA page

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority | transport | vesselName | email  |
      | 123 | A23456A | 01  | 09    | 2020 |New         | Route 1 | Class A drugs  | Maritime  | Test Vessel | a@a.com|


  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Selects HOLD - no route Qs & mandatory Vessel)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    When the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>
#    Then the user is on the Export-Mandatory Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "<day>" "<month>" "<year>"
#    Then the user enters a time for the vessel "17" "30"
#    Then the user clicks Continue
#    Then the user is on the Export Contact Details Page
#    And the user clicks Continue
#    Then the user is on the Export CYA page

    Examples:
      | epu | entryNo | day | month | year | requestType | transport |
      | 123 | A23456A | 01  | 09    | 2020 | Hold        | Air       |


  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Mandatory Vessel Qs - C1601)

    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Mandatory Vessel Page
    Then the user enters <vesselName> for vessel name
    Then the user enters a date for the vessel "<day>" "<month>" "<year>"
    Then the user enters a time for the vessel "13" "10"
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user clicks Continue
    Then the user is on the Export CYA page

    Examples:
      | epu | entryNo | day | month | year | requestType | route   | transport    | vesselName  |
      | 123 | A23456A | 01  | 09    | 2020 | C1601       | Route 1 | RoadRoRoRail | test vessel |


#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Mandatory Vessel Qs - C1602)
#
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the Export Request Type page and selects <requestType>
#    Then the user is on the Export Route Type Page and selects <route>
#    Then the user is on the Export YesNo Priority Page and selects No
#    Then the user is on the Export Transport Type Page and selects <transport>
#    Then the user is on the Export-Mandatory Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "01" "11" "2021"
#    Then the user enters a time for the vessel "10" "10"
#    Then the user clicks Continue
#
#
#    Examples:
#      | epu | entryNo | day | month | year | requestType | route  | transport    |
#      | 123 | A23456A | 01  | 09    | 2020 | C1602       | Route 1 | RoadRoRoRail |


#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Mandatory Vessel Qs - Hold)
#
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the Export Request Type page and selects <requestType>
#    Then the user is on the Export YesNo Priority Page and selects No
#    Then the user is on the Export Transport Type Page and selects <transport>
#    Then the user is on the Export-Mandatory Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "01" "11" "2021"
#    Then the user enters a time for the vessel "10" "10"
#    Then the user clicks Continue
#
#
#    Examples:
#      | epu | entryNo | day | month | year | requestType | transport    |
#      | 123 | A23456A | 01  | 09    | 2020 | Hold        | RoadRoRoRail |

#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Mandatory Vessel Qs - Route-Hold)
#
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the Export Request Type page and selects <requestType>
#    Then the user is on the Export Route Type Page and selects <route>
#    Then the user is on the Export YesNo Priority Page and selects No
#    Then the user is on the Export Transport Type Page and selects <transport>
#    Then the user is on the Export-Mandatory Vessel Page
#    Then the user enters Test Vessel for vessel name
#    Then the user enters a date for the vessel "01" "11" "2021"
#    Then the user enters a time for the vessel "10" "10"
#    Then the user clicks Continue
#
#
#    Examples:
#      | epu | entryNo | day | month | year | requestType | route  | transport    |
#      | 123 | A23456A | 01  | 09    | 2020 | New         | Hold   | RoadRoRoRail |


  Scenario Outline: Error validation - no options selected (Question pages only)
#    Question pages include pages with radio options, more detailed validation done on own feature files
    Given the user is on the landing page for trader services
    Then the user clicks the link to enter the route1 journey
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects NoOption
    Then the user should see "Error:Select the type of export request" error message for "requestType"
    When the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects NoOption
    Then the user should see "Error:Select the route" error message for "routeType"
    When the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects None
    Then the user should see "Error:Select yes if you're moving priority goods" error message for "hasPriorityGoods"
    When the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Options Page and selects NoOption
    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
    When the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export Transport Type Page and selects NoOption
    Then the user should see "Error:Select the type of transport you're using" error message for "freightType"

    Examples:
      | epu | entryNo | day | month | year |requestType | route     | priority |
      | 123 | A23456A | 01  | 09    | 2020 |Cancellation     | Route 1 CAP | Art      |