@TraderService
Feature: Pre-clearance - Export Journeys

  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the consignment number page
    When the user enters consignment details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
#    Then the user is on the Export question page
#    And the user selects New for Export REQUEST TYPE
#    Then the user selects Route1 for ROUTE
#    And the user selects None for PRIORITY
#    And the user clicks Continue
#    Then the user signs out

    Examples:
      | epu | entryNo | day | month | year |
      | 123 | A23456A | 01  | 09    | 2020 |