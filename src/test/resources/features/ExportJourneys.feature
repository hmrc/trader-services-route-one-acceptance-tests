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
#      Then the user is on the Export Route Type Page and selects <route>
#      Then the user is on the Export Transport Type Page and selects <transport>
#      When the user is on the YesNo Priority Page and selects Yes
#      Then the user is on the Priority Options Page and selects <priority>

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority    | transport    |
      | 123 | A23456A | 01  | 09    | 2020 |New         | Route1 | LiveAnimals | RoadRoRoRail |

  Scenario Outline: Error validation - no options selected
    Given the user navigates to the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects NoOption
    Then the user should see "Error:Select the type of export request" error message for "requestType" on the page

    Examples:
      | epu | entryNo | day | month | year |
      | 123 | A23456A | 01  | 09    | 2020 |


#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Selects HOLD)


#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (vessel qs)
#    Examples:
#      | epu | entryNo | day | month | year | requestType | route | priority |
#      | 123 | A23456A | 01  | 09    | 2020 | C1601       | Hold  | None     |


#  Scenario Outline: A user wants to make changes to an Existing EXPORT RouteOne journey
