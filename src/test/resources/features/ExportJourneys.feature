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
      Then the user is on the Export contact details page

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority | transport |
      | 123 | A23456A | 01  | 09    | 2020 |New         | Route1 | ClassA   | Maritime  |


  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Selects HOLD - no route Qs)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    When the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>

    Examples:
      | epu | entryNo | day | month | year |requestType | transport |
      | 123 | A23456A | 01  | 09    | 2020 |Hold        | Air       |


  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (Mandatory Vessel Qs)

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
    Then the user is on the Export Vessel Page

    Examples:
      | epu | entryNo | day | month | year | requestType | route |transport    |
      | 123 | A23456A | 01  | 09    | 2020 | C1601       | Hold  |RoadRoRoRail |


#  Scenario Outline: A user wants to AMEND an Existing EXPORT RouteOne journey
#  Scenario Outline: A user wants to CANCEL an Existing EXPORT RouteOne journey


  Scenario Outline: Error validation - no options selected
    Given the user navigates to the declaration details page
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
      | epu | entryNo | day | month | year |requestType | route     | priority | transport    |
      | 123 | A23456A | 01  | 09    | 2020 |Cancel      | Route1CAP | Art      | RoadRoRoRail |