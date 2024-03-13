@TraderService
Feature: Back Links
  Scenario Outline: Import: A user goes back through the journey and their answers should be saved
    Given the user is on the start page for trader services, selects New and continues
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
    Then the user will be on the Import Contact details page
    * the user enters an email address "abc@test.com"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New

    When the user clicks back
    Then the user will be on the <journey> Contact details page
    And the details entered for name, email and phone number should be pre-filled with "", "<email>" & ""

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

    When the user clicks the service-name link they will be redirected to the appropriate page

    Examples:
      | journey | epu | entryNo | requestType | route   | priority     | transport | email        |
      | Import  | 001 | 000000Z | New         | Route 1 | Live animals | Air       | abc@test.com |

  Scenario Outline: : Amend back links
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user will be on the write response page
    When the user enters "Hello Caseworker" characters in the write response field and continues
    Then the user will be on the multi-file upload pages for <journey>
    When the user clicks back
    Then the user will be on the write response page
    And the details in the text box should be pre-filled with "<message>"

    When the user clicks back
    Then the user will be on the Amendment type page
    And the last selected option for type of amendment should be <amendType>

    When the user clicks back
    Then the user will be on the Case Reference number page
    And the details in the case ref field should be pre-filled with "<caseRef>"

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with <journey>

    Then the user clicks the service-name link they will be redirected to the appropriate page
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | journey | caseRef                | amendType      | message          |
      | Amend   | PC12010081330XGBNZJO04 | writeAndUpload | Hello Caseworker |
