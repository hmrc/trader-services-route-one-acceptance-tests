#@TraderService
#Feature: Pre-clearance - Export Journey
#
#  Scenario Outline: A user wants to complete a New RouteOne journey (Export)

#    Given the user attempts to log in
#    Then the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the consignment number page
#    When the user enters consignment details <epu> and <entryNo>
#    And the user enters a date <day> <month> <year>
#    And the user clicks Continue
#    Then the user is on the Export question page
#    And the user selects New for Import REQUEST TYPE
#    Then the user selects Route1 for ROUTE
#    And the user selects None for PRIORITY
#    And the user clicks Continue
#    Then the user signs out

#    Examples:
#      | epu | entryNo | day | month | year |
#      | 123 | A23456B | 01  | 09    | 2020 |



#  Scenario: A user wants to amend an Existing RouteOne journey (Export)
#  Scenario: A user wants to cancel an Existing RouteOne journey (Export)