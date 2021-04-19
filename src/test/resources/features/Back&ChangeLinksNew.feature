@TraderService
Feature: Back Links & Change Links for a New journey

  Background: : Import: Set up journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "001" and "000000Z"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the Import Request type page
    When the user is on the Request type page, selects New and continues
    Then the user will be on the Import Route type page
    When the user is on the Route type page, selects Route 1 and continues
    Then the user will be on the Import YN Priority page
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user will be on the Import Priority Goods page
    When the user is on the Priority Goods page, selects Live animals and continues
    Then the user will be on the ALVS page
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects Air and continues
    Then the user will be on the Import-Optional Transport details page
    * the user clicks continue
    Then the user will be on the Import Contact details page
    * the user enters an email address "abc@test.com"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user clicks the button to upload file "1" and selects "testPdf.pdf"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Import CYA page

  Scenario Outline: A user changes to route hold - makes transport details mandatory
    When the user clicks the change link for Route
    Then the user is on the Route type page, selects Hold and continues
    Then the user will be on the <journey> YN Priority page
    When the user clicks continue
    Then the user will be on the <journey> Priority Goods page
    When the user clicks continue
    Then the user will be on the ALVS page
    When the user clicks continue
    Then the user will be on the <journey> Transport type page
    And the user clicks continue
    Then the user will be on the Import-Mandatory Transport details page
    * the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateArrival
    * the user enters a time of Arrival for their transportation "11" "15"
    When the user clicks continue
    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page

    Examples:
      | journey | transportName |
      | Import  | TestShip      |

  Scenario Outline: A user changes some answers via the change links
    Given the user will be on the <journey> CYA page
    When the user clicks the change link for Documents
    Then the user will be on the multi-file upload pages for New
    When the user clicks MFU continue
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for ContactDetails
    * the user will be on the <journey> Contact details page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for Transport
    * the user will be on the <journey> Transport type page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for TransportDetails
    * the user will be on the Import-Optional Transport details page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for ALVS
    * the user will be on the ALVS page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for PriorityYN
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for Request
    Then the user is on the Request type page, selects <requestType> and continues
    * the user will be on the <journey> CYA page

    Then the user clicks the change link for Entry
    Then the user will be on the entry details page
    When the user clicks continue
    Then the user will be on the <journey> CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page


    Examples:
      | journey | requestType |
      | Import  | New         |


  Scenario Outline: Import: A user goes back through the journey and their answers should be saved
    Given the user will be on the <journey> CYA page
    When the user clicks back
    Then the user will be on the multi-file upload pages for New
    When the user clicks back
    Then the user will be on the <journey> Contact details page
    And the details entered for name, email and phone number should be pre-filled with "", "<email>" & ""

    When the user clicks back
    Then the user will be on the Import-Optional Transport details page

    When the user clicks back
    Then the user will be on the <journey> Transport type page
    And the last selected option for Transport type should be pre filled with <transport>

    When the user clicks back
    Then the user will be on the ALVS page
    And the last selected option for ALVS should be pre filled with Yes

    When the user clicks back
    Then the user will be on the <journey> Priority Goods page
    And the last selected option for Priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user will be on the <journey> YN Priority page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user will be on the <journey> Route type page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user will be on the <journey> Request type page
    And the last selected option for <journey> Request should be pre filled with <requestType>

    When the user clicks back
    Then the user will be on the entry details page
    * the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    * the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with New

    When the user clicks back
    Then the user will be on the temporary start page

    Examples:
      | journey | epu | entryNo | requestType | route   | priority     | transport | email        |
      | Import  | 001 | 000000Z | New         | Route 1 | Live animals | Air       | abc@test.com |
