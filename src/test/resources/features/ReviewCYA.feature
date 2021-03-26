@TraderService
Feature: Review/CYA page

  Scenario Outline: A user wants to review their answers (Import)
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    When the user is on the Import YesNo Priority page and selects Yes
    Then the user is on the Import Priority Goods page and selects <priority>
    When the user is on the ALVS page and selects <ALVS>
    Then the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Optional transport details page
    And the user clicks continue
    Then the user is on the Import contact details page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "png" file
    Then the user clicks continue when files have finished uploading

    Then the user is on the Import CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Import Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    Then the user should see the Vessel Name row & the correct response "-" on the CYA page
    And the user should see the Vessel Date Arrival row & the correct response "-" on the CYA page
    And the user should see the Vessel Time Arrival row & the correct response "-" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phone>" on the CYA page

    Examples:
      | epu | entryNo | requestType | route   | priority      | ALVS | transport | name      | email          | phone         | entryDateCYA |
      | 003 | 123456A | New         | Route 6 | Human remains | Yes  | Air       | Abc Testb | valid@test.com | 01234 567 899 | Today        |


  Scenario Outline: A user wants to review their answers (Export)
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
    When the user clicks the button to upload the first file and selects the "pdf" file
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

    Examples:
      | epu | entryNo | requestType | route   | transport | transportName | email        | entryDateCYA |
      | 123 | A23456A | New         | Route 1 | Maritime  | Test Vessel   | abc@test.com | Today        |