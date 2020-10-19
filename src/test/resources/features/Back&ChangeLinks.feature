@TraderService
Feature: Check Back Links & Change Links

  Scenario Outline: A user wants to change an answer - Import
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import Vessel Page
#    Then the user clicks Continue
#    Then the user is on the Import contact details page

    When the user clicks back
    Then the user is on the Import Transport Page
    When the user clicks back
    Then the user is on the ALVS Page
    When the user clicks back
    Then the user is on the Import Priority Goods Page
    When the user clicks back
    Then the user is on the Import YN Priority Page
    When the user clicks back
    Then the user is on the Import Route Type Page
    When the user clicks back
    Then the user is on the Import Request Type Page
    When the user clicks back
    Then the user is on the declaration details page
    When the user clicks back
    Then the user is on the landing page for trader services

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority     | transport | name      | email      |
      | 123 | 123456A | 01  | 10    | 2020 |Cancel      | Route6 | HumanRemains | Air       | Abc Testb | a@test.com |


  Scenario Outline: A user wants to change an answer - Export
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
    Then the user is on the Export Vessel Page
#    Then the user clicks Continue
#    Then the user is on the Export contact details page

    When the user clicks back
    Then the user is on the Export Transport Page
    And the last selected option for vessel should be pre filled with <transport>

    When the user clicks back
    Then the user is on the Export Priority Goods Page
    And the last selected option for priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user is on the Export YN Priority Page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user is on the Export Route Type Page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user is on the Export Request Type Page
    And the last selected option for Export Request should be pre filled with <requestType>

    When the user clicks back
    Then the user is on the declaration details page
    And the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    And the details entered for Declaration Date should be pre filled with <day>, <month> & <year>

    When the user clicks back
    Then the user is on the landing page for trader services

    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority   | transport | name      | email      |
      | 123 | A23456A | 01  | 09    | 2020 |Withdrawal  | Route2 | Explosives | Maritime  | Abc Testb | a@test.com |
