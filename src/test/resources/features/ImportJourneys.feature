@TraderService
Feature: Pre-clearance - Import Journeys

  Scenario Outline: A user wants to complete a New IMPORT RouteOne journey
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
#    Then the user is on the Import Request Type page and selects <requestType>


    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority| freight |
      | 123 | 123456A | 01  | 09    | 2020 |New         | Route2 | None    | Air     |


#  Scenario Outline: A user wants to amend an existing RouteOne journey (Import)
#  Scenario Outline: A user wants to cancel an Existing RouteOne journey (Import)


#  Ensure combinations are valid, if not ->
#  Scenario: Invalid combinations...?