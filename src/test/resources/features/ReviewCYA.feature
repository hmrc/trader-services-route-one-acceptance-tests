@TraderService
Feature: Review/CYA page

  Scenario Outline: A user wants to review their answers (Import)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks Continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects Yes
    Then the user is on the Import Priority Options Page and selects <priority>
    When the user is on the ALVS Page and selects <ALVS>
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks Continue
    Then the user is on the Import CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Import Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    Then the user should see the Vessel Name row & the correct response "-" on the CYA page
    And the user should see the Vessel Date row & the correct response "-" on the CYA page
    And the user should see the Vessel Time row & the correct response "-" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phone>" on the CYA page

    Examples:
      | epu | entryNo |requestType | route   | priority      | ALVS | transport | name       | email          | phone       | entryDateCYA |
      | 123 | 123456A |New         | Route 6 | Human remains | Yes  | Air       | Abc Testb  | valid@test.com | 01234567899 | Today        |


  Scenario Outline: A user wants to review their answers (Export)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Optional Vessel Page
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    When the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the Export CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Export Request Type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response No on the CYA page
    When the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"
    Then the user should see the Vessel Name row & the correct response "<vesselName>" on the CYA page
    And the user should see the Vessel Date row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Vessel Time row & the correct response "-" on the CYA page
    And the user should see the Mandatory Contact details row & the correct responses "<name>", "<email>" & "" on the CYA page

    Examples:
      | epu | entryNo |requestType | route   | transport | vesselName  | name  | email   | entryDateCYA |
      | 123 | A23456A |New         | Route 1 | Maritime  | Test Vessel | 123?  | a@a.com | Today        |