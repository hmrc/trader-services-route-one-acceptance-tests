@TraderService
Feature: Pre-clearance - Import Journey

  Scenario: A user wants to complete a New RouteOne journey (Import)

    Given the user attempts to log in
    Then a user is created
    Then the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the test data is destroyed
#    Then the user is on the consignment number page
#    When the user enters consignment details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the Import question page
#    And the user selects New for Import REQUEST TYPE
#    Then the user selects Route1 for ROUTE
#    And the user selects None for PRIORITY
#    Then the user selects Air for FREIGHT
#    And the user clicks Continue
#    Then the user signs out

#
#    Examples:
#      | epu | entryNo | day | month | year |
#      | 123 | 123456A | 01  | 09    | 2020 |

#  Scenario: A user wants to amend an Existing RouteOne journey (Import)
#  Scenario: A user wants to cancel an Existing RouteOne journey (Import)
#
#    Given the user attempts to log in
#    Then a user is created
#    Then the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the consignment number page
#    When the user enters valid consignment details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the Import question page
#    And the user selects Hold for Import REQUEST TYPE
#    And the user selects Cancellation for Import REQUEST TYPE
#    Then the user selects Route1CAP for ROUTE
#    And the user selects LiveAnimals for PRIORITY
#    Then the user selects Maritime for FREIGHT
#    And the user clicks Continue
#    Then the user should see "<string>" error message for "<string>" on the page
#    Then the test data is destroyed
#