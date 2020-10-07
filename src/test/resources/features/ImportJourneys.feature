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
#    Then the user is on the Import Route Type Page and selects <route>
#    Then the user is on the Import YesNo Priority Page and selects Yes
#    When the user is on the Import Priority Options Page and selects <priority>
#    Then the user is on the Import Transport Type Page and selects <transport>
#    Then the user is on the Import contact details page

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority     | transport |
      | 123 | 123456A | 01  | 10    | 2020 |Cancel      | Route6 | HumanRemains | Air       |



  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Selects HOLD - no route Qs)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    When the user is on the Import Request Type page and selects <requestType>
#    Then the user is on the Import YesNo Priority Page and selects No

    Examples:
      | epu | entryNo | day | month | year |requestType | transport |
      | 123 | 123456A | 01  | 10    | 2020 |Hold        | Maritime  |


#  Scenario Outline: A user wants to amend an existing RouteOne journey (Import)
#  Scenario Outline: A user wants to cancel an Existing RouteOne journey (Import)


#  Scenario Outline: Error validation - no options selected
#    Given the user navigates to the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the Export Request Type page and selects NoOption
#    Then the user should see "Error:Select the type of import request" error message for "requestType"
#    When the user is on the Export Request Type page and selects <requestType>
#    Then the user is on the Import Route Type Page and selects NoOption
#    Then the user should see "Error:Select the route" error message for "routeType"
#    When the user is on the Import Route Type Page and selects <route>
#    Then the user is on the Import YesNo Priority Page and selects None
#    Then the user should see "Error:Select yes if you're moving priority goods" error message for "hasPriorityGoods"
#    When the user is on the Import YesNo Priority Page and selects Yes
#    When the user is on the Import Priority Options Page and selects NoOption
#    Then the user should see "Error:Select the type of priority goods" error message for "priorityGoods"
#    When the user is on the Import Priority Options Page and selects <priority>
#    Then the user is on the Import Transport Type Page and selects NoOption
#    Then the user should see "Error:Select the type of transport you're using" error message for "freightType"
#
#    Examples:
#      | epu | entryNo | day | month | year |requestType | route     | priority | transport    |
#      | 123 | A23456A | 01  | 09    | 2020 |Cancel      | Route1CAP | Art      | RoadRoRoRail |