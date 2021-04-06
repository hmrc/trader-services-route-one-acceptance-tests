@TraderService
Feature: Customs check - Export journeys

  Scenario Outline: A user wants to complete a New Export RouteOne journey & see RoRo SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "odt" file
    Then the user clicks continue when files have finished uploading

    Then the user is on the Export CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Export Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response No on the CYA page
    When the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"
    Then the user should see the Vessel Name row & the correct response "<transportName>" on the CYA page
    And the user should see the Vessel Date Departure row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Vessel Time Departure row & the correct response "-" on the CYA page
    And the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "" on the CYA page
    Then the user clicks submit on the CYA page

    Then the user is on the New confirmation page
    Then the user will see text to give-feedback
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | transport | transportName | email        | entryDateCYA |
      | 123 | A23456A | New         | Route 1 | Maritime  | Test Vessel   | abc@test.com | Today        |

  Scenario Outline: A user wants to complete a Cancellation Export RouteOne journey & see Air SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "odp" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to cancel
    And the user waits 6000
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | transportName | email   |
      | 123 | A23456A | Cancellation | Route 1 | Human remains | Air       | Test Vessel   | a@a.com |

  Scenario Outline: A user wants to complete a Withdrawal Export RouteOne journey & see Maritime SLA
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "ods" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to withdraw
    And the user waits 6000
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | transportName | email   |
      | 123 | A23456A | Withdrawal  | Route 1 | Human remains | Maritime  | Test Vessel   | a@a.com |


  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page & no SLA provided
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    When the user is on the Export YesNo Priority page and selects No
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Mandatory transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "13" "37"
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "jpg" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see Hold SLA
    And the user waits 6000
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing


    Examples:
      | epu | entryNo | requestType | route | transport | transportName | email                 |
      | 424 | j66666x | New         | Hold  | Maritime  | Test Vessel   | person_real@ymail.com |

  Scenario Outline: C1601: A user reach the mandatory vessel page and then see the upload inset text for C1601
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Mandatory transport details page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "16" "21"
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "awdn_ljd@a.co.uk"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1601
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to give-feedback

    Examples:
      | epu | entryNo | requestType | route   | transport | transportName |
      | 424 | l15125z | C1601       | Route 3 | Maritime  | boat          |


  Scenario Outline: C1602: A user reach the mandatory vessel page and then see the upload inset text for C1602
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Mandatory transport details page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "16" "21"
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "awdn_ljd@a.co.uk"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1602
    When the user clicks the button to upload the first file and selects the "ppt" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to give-feedback

    Examples:
      | epu | entryNo | requestType | route   | transport    | transportName |
      | 123 | A23456A | C1602       | Route 1 | RoadRoRoRail | abc           |

  Scenario Outline: C1603: A user should see the inset text for C1603
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "awjdlnwjdn@a.com"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user will only see inset text for request type C1603
    When the user clicks the button to upload the first file and selects the "pptx" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to give-feedback

    Examples:
      | epu | entryNo | requestType | route   | transport    |
      | 123 | A23456A | C1603       | Route 1 | RoadRoRoRail |