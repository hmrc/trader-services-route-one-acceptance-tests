@TraderService
Feature: Customs check - Export journeys

  @accessibility @ZAP
  Scenario Outline: A user wants to complete a New Export RouteOne journey
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects No and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Optional Transport details page
    Then the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateDeparture
    * the user enters a time of Departure for their transportation "01" "45"
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    * the user enters an email address "<email>"
    * the user enters a phone number "00447123456789"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading

    Then the user will be on the Export CYA page
    And the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    * the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    * the user should see the Export Request type row & the correct response <requestType> on the CYA page
    * the user should see the Route row & the correct response <route> on the CYA page
    * the user should see the Priority YN row & the correct response No on the CYA page
    * the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"
    * the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    * the user should see the Transport date Departure row & the correct response "<entryDateCYA>" on the CYA page
    * the user should see the Transport time Departure row & the correct response "01:45" on the CYA page
    * the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "07123456789" on the CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user will see text to give-feedback
#    And the user should see 2 Hour SLA

    Examples:
      | epu | entryNo | requestType | route   | transport | transportName | email        | entryDateCYA | file        |
      | 123 | A23456A | New         | Route 1 | Maritime  | Test Vessel   | abc@test.com | Today        | testOdp.odp |

  @accessibility @ZAP
  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page & no SLA provided
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects No and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Mandatory Transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "13" "37"
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user will be on the multi-file upload pages for New
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA

    Examples:
      | epu       | entryNo  | requestType | route | transport | transportName | email                | file          |
      | randomEPU | exportEN | New         | Hold  | Maritime  | TestShip      | real_email@ymail.com | testXlsx.xlsx |

  Scenario Outline: C160* upload inset text
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects No and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Mandatory Transport details page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "16" "21"
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    And the user enters an email address "awdn_ljd@a.co.uk"
    And the user clicks continue
    Then the user will be on the multi-file upload pages for New
    And the user will only see inset text for Request type C1601
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    When the user clicks the change link for Request
    Then the user is on the Request type page, selects C1602 and continues
    Then the user will be on the Export CYA page
    When the user clicks back
    Then the user will only see inset text for Request type C1602
    Then the user clicks MFU continue
    When the user clicks the change link for Request
    Then the user is on the Request type page, selects C1603 and continues
    Then the user will be on the Export CYA page
    When the user clicks back
    Then the user will only see inset text for Request type C1603

    Examples:
      | epu       | entryNo  | requestType | route   | transport | transportName | file          |
      | randomEPU | exportEN | C1601       | Route 3 | Maritime  | boat          | testDocx.docx |
