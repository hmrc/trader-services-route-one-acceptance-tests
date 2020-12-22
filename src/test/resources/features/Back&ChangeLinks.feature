@TraderService
Feature: Back Links & Change Links

  #BACK LINKS
  Scenario Outline: Import: A user wants to go back through the journey
    Given the user is on the start page for trader services and selects New
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
    And the details entered for vesselDate should be pre filled with today's date
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
    And the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user is on the start page for trader services
    And the last selected option for journey type should be pre filled with New

    Examples:
| epu | entryNo | requestType | route   | priority                | transport | vesselName | name       | email      |
| 113 | 993456A | New         | Route 3 | Explosives or fireworks | Maritime  | TestShip   | Abc Testb  | a@test.com |


  Scenario Outline: Export: A user wants to go back through the journey
    Given the user is on the start page for trader services and selects New
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
    And the details entered for vesselDate should be pre filled with today's date
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
    And the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user is on the start page for trader services
    And the last selected option for journey type should be pre filled with New

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | name      | email      |
      | 553 | A33456A | Cancellation | Route 6 | Human remains | Air       | Abc Testb | a@test.com |

    Scenario Outline: Amend Back links - A user wants to go back to the start
      Given the user is on the start page for trader services and selects <journey>
      Then the user is on the case ref number page
      When the user enters a case ref number "<caseRef>" and continues
      When the user is on the how to respond page and selects <amendType>
      Then the user is on the write response page
      And the user enters a response "<text>" and continues
      Then the user is on the Amend upload page
      Then the user clicks the button to upload and selects "first" file
      Then the user should be on the amend file upload confirmation page after uploading 1 document/s
      Then the user should see their first uploaded doc test.jpg on upload review page
      Then the user clicks back
      Then the user is on the write response page
      And the details in the text box should be pre-filled with "<text>"
      When the user clicks back
      Then the user is on the how to respond page
      And the last selected option for type of amendment should be <amendType>
      When the user clicks back
      Then the user is on the case ref number page
      And the details in the case ref field should be pre-filled with "<caseRef>"
      When the user clicks back
      Then the user is on the start page for trader services
      And the last selected option for journey type should be pre filled with <journey>

      Examples:
      | journey  | caseRef                | amendType    | text      |
      |  Amend   | PC12010081330XGBNZJO04 | write&Upload | test text |


#CHANGE LINKS
  Scenario Outline: Import: A user wants to change an answer via the CYA page
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects New
    Then the user is on the Import Route Type Page and selects Route 1
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects No
    Then the user is on the Import Transport Type Page and selects Air
    Then the user is on the Import-Optional Vessel Page
    When the user enters "Test Shop" for vessel name
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    And the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user enters a phone number "<phoneNo>"
    And the user clicks Continue
    Then the user is on the Import CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "No" & "Air"

    When the user clicks the change link for ContactDetails
    Then the user is on the Import Contact Details Page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & "<phoneNo>"
    Then the user enters a name ""
    Then the user enters a phone number ""
    Then the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks the change link for Transport
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import CYA page

    When the user clicks the change link for Vessel
    Then the user is on the Import-Optional Vessel Page
    And the user enters "<vesselName>" for vessel name
    When the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks the change link for ALVS
    Then the user is on the ALVS Page and selects <ALVS>
    Then the user is on the Import CYA page

    When the user clicks the change link for PriorityYN
    Then the user is on the Import YesNo Priority Page and selects No
    Then the user is on the Import CYA page

    When the user clicks the change link for Route
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YN Priority Page
    When the user clicks Continue
    Then the user is on the ALVS Page
    When the user clicks Continue
    Then the user is on the Import Transport Page
    And the user clicks Continue
    Then the user is on the Import-Mandatory Vessel Page
    And the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "11" "15"
    When the user clicks Continue
    Then the user is on the Import CYA page

    When the user clicks the change link for Request
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import CYA page

    Then the user should see the Import Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response Hold (for pre-lodged requests) on the CYA page
    And the user should see the Priority YN row & the correct response No on the CYA page
    When the user answered NoToPriority then they should see the correct responses for the Import journey "", "<ALVS>" & "<transport>"
    And the user should see the Vessel Name row & the correct response "<vesselName>" on the CYA page
    And the user should see the Vessel Date row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Vessel Time row & the correct response "11:15" on the CYA page
    And the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "" on the CYA page

    Then the user clicks the change link for Declaration
    Then the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    Then the user enters declaration details "<epu>" and "X00000H"
    And the user enters today's date for entryDate
    When the user clicks Continue
    Then the last selected option for Export Request should be pre filled with Nothing


    Examples:
| epu | entryNo | requestType  | route | priority   | ALVS | transport | vesselName | name      | email      | phoneNo    | entryDateCYA|
| 113 | 993456A | Cancellation | Hold  | High value art | Yes  | Maritime  | TestShip   | Abc Testb | a@test.com | 01234567891 | Today       |


  Scenario Outline: Export: A user wants to change an answer via the CYA page
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects C1601
    Then the user is on the Export Route Type Page and selects <route>
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
    When the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"

    When the user clicks the change link for Request
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export CYA page

    When the user clicks the change link for Route
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export CYA page

    When the user clicks the change link for PriorityYN
    Then the user is on the Export YesNo Priority Page and selects Yes
    Then the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export CYA page

    When the user clicks the change link for PriorityGoods
    And the last selected option for priority goods should be pre filled with <priority>
    And the user clicks Continue
    Then the user is on the Export CYA page

    When the user clicks the change link for Vessel
    And the user is on the Export-Optional Vessel Page
    And the details entered for Vessel Name should be pre filled with "<vesselName>"
    And the details entered for vesselDate should be pre filled with today's date
    And the details entered for Time of Arrival should be pre filled with "12" & "34"
    Then the user clicks Continue
    Then the user is on the Export CYA page

    When the user clicks the change link for Transport
    And the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export CYA page

    When the user clicks the change link for ContactDetails
    Then the user is on the Export Contact Details Page
    And the user enters a phone number "<phoneNo>"
    When the user clicks Continue
    Then the user is on the Export CYA page

    Then the user should see the Export Request Type row & the correct response <requestType> on the CYA page
    Then the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Export journey "<priority>" & "<transport>"
    And the user should see the Vessel Name row & the correct response "<vesselName>" on the CYA page
    And the user should see the Vessel Date row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Vessel Time row & the correct response "12:34" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phoneNo>" on the CYA page

    Then the user clicks the change link for Declaration
    Then the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    Then the user enters declaration details "<epu>" and "000000H"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the last selected option for Import Request should be pre filled with Nothing

    Examples:
| epu | entryNo | requestType | route   | priority     | transport | vesselName | name     | email        | phoneNo    | entryDateCYA |
| 669 | X12088M | New         | Route 2 | Live animals | Air       | Ship Test  | Ms. Test | xyz@test.com | 07712 345 671 | Today        |