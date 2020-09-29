@TraderService
Feature: Pre-clearance - Import Journeys

  Scenario Outline: A user wants to complete a New IMPORT RouteOne journey
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
#    Then the user is on the "Import" question page
#    Then the user is on the Import Request Type page and selects <requestType>
#    And the user is on the Route Type Page and selects <route>
#    Then the user is one the Priority Page and selects <priority>
#    Then the user is on the Freight Page and selects <freight>
#    When the user clicks Continue
    #  Then the user will be on the contact details page ....

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority| freight |
      | 123 | A23456A | 01  | 09    | 2020 |New         | Route2 | None    | Air     |

  #  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (vessel qs (mandatory))
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the "Import" question page
#    Then the user is on the Import Request Type page and selects <requestType>
#    And the user is on the Route Type Page and selects <route>
#    Then the user is one the Priority Page and selects <priority>
#    Then the user is on the Freight Page and selects <freight>
#    When the user clicks Continue
#     Then the user will be on the vessel questions page ...
#
#    Examples:
#      | epu | entryNo | day | month | year |requestType | route  | priority| freight  |
#      | 123 | A23456A | 01  | 09    | 2020 |Hold        | Route3 | None    | Maritime |


#  ALVS Question to slot into this journey



#  Scenario Outline: A user wants to amend an existing RouteOne journey (Import)
#
#    Then the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration number page
#    When the user enters declaration details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the ***REVIEW*** Import question page
#
#
#    Examples:
#      | epu | entryNo | day | month | year |requestType | route  | priority| freight      |
#      | 123 | A23456A | 01  | 09    | 2020 |Hold        | Route3 | None    | RailRoadRoRo |



#  Scenario Outline: A user wants to cancel an Existing RouteOne journey (Import)
#    Given the user is on the declaration details page
#    When the user enters declaration details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the ***REVIEW*** Import question page
#       Cancel journey....
#
#    Examples:
#      | epu | entryNo | day | month | year |
#      | 123 | A23456A | 01  | 09    | 2020 |


#  Ensure above combinations are valid
#  Scenario: Invalid combinations...?