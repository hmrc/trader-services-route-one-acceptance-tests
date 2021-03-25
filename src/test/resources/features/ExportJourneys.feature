@TraderService
Feature: Customs check - Export journeys

  Scenario Outline: A user wants to complete a New Export RouteOne journey & see RoRo SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the export Transport type page and selects <transport>
    Then the user is on the Export-Optional Transport page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for vesselDateDeparture
    Then the user clicks Continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks Continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA
    When the user clicks the send docs link on the New confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport    | transportName | email   |
      | 123 | A23456A | New         | Route 1 | Human remains | RoadRoRoRail | Test Vessel   | a@a.com |


  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page & no SLA provided
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    When the user is on the Export YesNo Priority page and selects No
    Then the user is on the export Transport type page and selects <transport>
    Then the user is on the Export-Mandatory Transport page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for vesselDateDeparture
    And the user enters a time of Departure for their transportation "13" "37"
    Then the user clicks Continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "jpg" file
    Then the user clicks Continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see Hold SLA
    When the user clicks the send docs link on the New confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing


    Examples:
      | epu | entryNo | requestType | route | transport | transportName | email                 |
      | 424 | j66666x | New         | Hold  | Maritime  | Test Vessel   | person_real@ymail.com |

  Scenario Outline: C1601: A user should reach the mandatory Transport page & SLA for Maritime
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the export Transport type page and selects <transport>
    Then the user is on the Export-Mandatory Transport page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for vesselDateDeparture
    And the user enters a time of Departure for their transportation "16" "21"
    Then the user clicks Continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1601
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks Continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA
    When the user clicks the send docs link on the New confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing


    Examples:
      | epu | entryNo | requestType | route   | transport | transportName | email                     |
      | 424 | l15125z | C1601       | Route 3 | Maritime  | Test Vessel   | real-person@hotmail.co.uk |


  Scenario Outline: C1602: A user should be on the mandatory vessel page and the inset text for C1602
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the export Transport type page and selects <transport>
    Then the user is on the Export-Mandatory Transport page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for vesselDateDeparture
    And the user enters a time of Departure for their transportation "16" "21"
    Then the user clicks Continue
    Then the user is on the Export contact details page
    And the user enters an email address "awdn_ljd@a.co.uk"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1602

    Examples:
      | epu | entryNo | requestType | route   | transport    | transportName |
      | 123 | A23456A | C1602       | Route 1 | RoadRoRoRail | abc           |

  Scenario Outline: C1603: A user should see the inset text for C1603
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the export Transport type page and selects <transport>
    Then the user is on the Export-Optional Transport page
    Then the user clicks Continue
    Then the user is on the Export contact details page
    And the user enters an email address "awjdlnwjdn@a.com"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1603

    Examples:
      | epu | entryNo | requestType | route   | transport    |
      | 123 | A23456A | C1603       | Route 1 | RoadRoRoRail |