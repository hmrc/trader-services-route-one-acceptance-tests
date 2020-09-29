@TraderService
Feature: Pre-clearance - Export Journeys

  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey
      Given the user is on the landing page for trader services
      When the user clicks the link to enter the route1 journey
      Then the user is on the declaration details page
      When the user enters declaration details "<epu>" and "<entryNo>"
      And the user enters a date "<day>" "<month>" "<year>"
      And the user clicks Continue
      Then the user is on the "Export" question page
      And the user selects "<requestType>" for Export REQUEST TYPE
      Then the user selects "<route>" for ROUTE
      And the user selects "<priority>" for PRIORITY
      When the user clicks Continue
    #  Will need to add steps for freight Qs...
    #  Then the user will be on the contact details page ....

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority|
      | 123 | A23456A | 01  | 09    | 2020 |New         | Route1 | None    |

  Scenario Outline: Error validation - no options selected
    Given the user navigates to the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the "Export" question page
    When the user clicks Continue
    Then the user should see "Error:Tell us what is the type of request" error message for "requestType" on the page
    Then the user should see "Error:Tell us which route" error message for "routeType" on the page
    Then the user should see "Error:Select yes if the consigment contains priority goods" error message for "goodsPriority" on the page

    Examples:
      | epu | entryNo | day | month | year |
      | 123 | A23456A | 01  | 09    | 2020 |

#Above error messages to be updated



#  Scenario Outline: A user wants to complete a New EXPORT RouteOne journey (vessel qs)
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the "Export" question page
#    And the user selects "<requestType>" for Export REQUEST TYPE
#    Then the user selects "<route>" for ROUTE
#    And the user selects "<priority>" for PRIORITY
#    When the user clicks Continue
#     Then the user will be on the vessel questions page ...
#
#    Examples:
#      | epu | entryNo | day | month | year | requestType | route | priority |
#      | 123 | A23456A | 01  | 09    | 2020 | C1601       | Hold  | None     |


#  Scenario Outline: A user wants to make changes to an Existing EXPORT RouteOne journey
#    Given the user is on the landing page for trader services
#    When the user clicks the link to enter the route1 journey
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters a date "<day>" "<month>" "<year>"
#    And the user clicks Continue
#    Then the user is on the "Export" question page
#    And the user selects "<requestType>" for Export REQUEST TYPE
#    Then the user selects "<route>" for ROUTE
#    And the user selects "<priority>" for PRIORITY
#    When the user clicks Continue
#     Then the user will be on the contact details page ....
#
#    Examples:
#      | epu | entryNo | day | month | year | requestType | route      | priority    |
#      | 123 | A23456A | 01  | 09    | 2020 |C1602       | Route1Cap  | LiveAnimals |



#Cover as many radio button options throughout different scenarios


