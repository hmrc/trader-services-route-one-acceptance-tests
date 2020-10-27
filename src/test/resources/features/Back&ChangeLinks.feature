@TraderService
Feature: Check Back Links & Change Links

  #BACK LINKS
  Scenario Outline: A user wants to go back through the journey - Import
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    When the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "23" "15"
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks back
    Then the user is on the Import Contact Details Page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""

    When the user clicks back
    Then the user is on the Import-Optional Vessel Page
    And the details entered for Vessel Name should be pre filled with "<vesselName>"
    And the details entered for Date of Arrival should be pre filled with today's date
    And the details entered for Time of Arrival should be pre filled with "23" & "15"

    When the user clicks back
    Then the user is on the Import Transport Page
    And the last selected option for transport type should be pre filled with <transport>
    When the user clicks back
    Then the user is on the ALVS Page
    And the last selected option for ALVS should be pre filled with Yes

    When the user clicks back
    Then the user is on the Import Priority Goods Page
    And the last selected option for priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user is on the Import YN Priority Page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user is on the Import Route Type Page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user is on the Import Request Type Page
    And the last selected option for Import Request should be pre filled with <requestType>

    When the user clicks back
    Then the user is on the declaration details page
    And the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    And the details entered for Declaration Date should be pre filled with today's date

    When the user clicks back
    Then the user is on the landing page for trader services

    Examples:
| epu | entryNo | requestType | route   | priority   | transport | vesselName | name       | email      |
| 113 | 993456A | New         | Route 3 | Explosives | Maritime  | TestShip   | Abc Testb  | a@test.com |


  Scenario Outline: A user wants to go back through the journey - Export
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Optional Vessel Page
    And the user enters today's date for vesselDate
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    Then the user clicks Continue
    And the user is on the Export CYA page

    When the user clicks back
    Then the user is on the Export Contact Details Page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""

    When the user clicks back
    Then the user is on the Export-Optional Vessel Page
    And the details entered for Vessel Name should be pre filled with ""
    And the details entered for Date of Arrival should be pre filled with today's date
    And the details entered for Time of Arrival should be pre filled with "" & ""

    When the user clicks back
    Then the user is on the Export Transport Page
    And the last selected option for transport type should be pre filled with <transport>

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
    And the details entered for Declaration Date should be pre filled with today's date

    When the user clicks back
    Then the user is on the landing page for trader services

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | name      | email      |
      | 553 | A33456A | Cancellation | Route 6 | Human remains | Air       | Abc Testb | a@test.com |


#CHANGE LINKS
  Scenario Outline: A user wants to change an answer via the CYA page - Import
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    When the user enters "Test Shop" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "23" "15"
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    And the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks the change link for ContactDetails
    Then the user is on the Import Contact Details Page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""

    Then the user clicks Continue
    Then the user clicks the change link for Vessel
    Then the user is on the Import-Optional Vessel Page
    And the user enters "<vesselName>" for vessel name
    Then the user clicks Continue
    Then the user clicks Continue

    Then the user is on the Import CYA page
    And the user clicks the change link for ALVS
    Then the user is on the ALVS Page and selects No

    Then the user is on the Import Transport Type Page and selects Air
    And the user clicks Continue
    And the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks the change link for PriorityYN
    Then the user is on the Import YesNo Priority Page and selects No
    Then the user is on the ALVS Page
    And the user clicks Continue
    And the user clicks Continue
    Then the user clicks Continue
    Then the user clicks Continue
    Then the user is on the Import CYA page

#    SELECTORS - need to be less brittle
#    And the user should see the Priority YN row & the correct response No on the CYA page
#    And the user should see the ALVS row & the correct response No on the CYA page
#    And the user should see the Import transport row & the correct response Air on the CYA page
#    And the user should see the Vessel Name row & the correct response <vesselName> on the CYA page
    
    Examples:
      | epu | entryNo | requestType | route   | priority   | transport | vesselName | name      | email      |
      | 113 | 993456A | New         | Route 3 | Explosives | Maritime  | TestShip   | Abc Testb | a@test.com |

    
    
  Scenario Outline: A user wants to change an answer via the CYA page - Export
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Mandatory Vessel Page
    When the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "12" "34"
    And the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Export CYA page

    When the user clicks the change link for PriorityYN
    Then the user is on the Export YesNo Priority Page and selects Yes
    Then the user is on the Export Priority Options Page and selects <priority>
    
    Then the user is on the Export Transport Page
    And the last selected option for transport type should be pre filled with <transport>
    And the user clicks Continue
    Then the user is on the Export-Mandatory Vessel Page
    And the details entered for Vessel Name should be pre filled with "<vesselName>"
    And the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""
    And the user clicks Continue
    Then the user is on the Export CYA page
    
    When the user clicks the change link for Request
    Then the user is on the Export Request Type page and selects Withdrawal
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YN Priority Page
    Then the user clicks Continue
    Then the user is on the Export Priority Goods Page
    And the last selected option for priority goods should be pre filled with <priority>
    Then the user clicks Continue
    Then the user clicks Continue
    Then the user is on the Export-Optional Vessel Page
    And the user enters "" for vessel name
    Then the user enters a date for the vessel "" "" ""
    Then the user enters a time for the vessel "" ""
    And the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user clicks Continue
    Then the user is on the Export CYA page
    

#    SELECTORS - need to be less brittle
#    And the user should see the Priority YN row & the correct response No on the CYA page
#    And the user should see the ALVS row & the correct response No on the CYA page
#    And the user should see the Import transport row & the correct response Air on the CYA page
#    And the user should see the Vessel Name row & the correct response <vesselName> on the CYA page

    Examples:
      | epu | entryNo | requestType | route   | priority     | transport | vesselName | name     | email        |
      | 669 | X12088M | Hold        | Route 2 | Live animals | Air       | Ship Test  | Ms. Test | xyz@test.com |