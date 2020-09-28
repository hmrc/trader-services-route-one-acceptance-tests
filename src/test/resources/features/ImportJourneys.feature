@TraderService
Feature: Pre-clearance - Import Journeys

  Scenario Outline: A user wants to complete a New IMPORT RouteOne journey

    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the consignment number page
    When the user enters consignment details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
##    Then the user is on the Import question page
##    And the user selects New for Import REQUEST TYPE
##    Then the user selects Route1 for ROUTE
##    And the user selects None for PRIORITY
##    Then the user selects Air for FREIGHT
##    And the user clicks Continue
#    Then the user signs out
#    Then the test data is destroyed

    Examples:
      | epu | entryNo | day | month | year |
      | 123 | 123456A | 01  | 09    | 2020 |


#  Scenario Outline: A user wants to amend an existing RouteOne journey (Import)
#
#    Then the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the consignment number page
#    When the user enters consignment details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the ***REVIEW*** Import question page
#
#
#    Examples:
#      | epu | entryNo | day | month | year |
#      | 123 | 123456A | 01  | 09    | 2020 |



#  Scenario: A user wants to cancel an Existing RouteOne journey (Import)

#  Scenario: Invalid combinations...