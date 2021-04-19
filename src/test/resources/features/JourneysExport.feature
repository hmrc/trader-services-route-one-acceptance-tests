@TraderService
Feature: Customs check - Export journeys

  @accessibility @ZAP
  Scenario Outline: A user wants to complete a New Export RouteOne journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
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
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    * the user enters an email address "<email>"
    * the user enters a phone number "00447123456789"
    * the user clicks continue
    Then the user is on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page

    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    * the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    * the user should see the Export Request type row & the correct response <requestType> on the CYA page
    * the user should see the Route row & the correct response <route> on the CYA page
    * the user should see the Priority YN row & the correct response No on the CYA page
    * the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"
    * the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    * the user should see the Transport date Departure row & the correct response "<entryDateCYA>" on the CYA page
    * the user should see the Transport time Departure row & the correct response "-" on the CYA page
    * the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "07123456789" on the CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user will see text to give-feedback
#    And the user should see 2 Hour SLA
    When the user clicks the confirmation NCH link they will be redirected to the appropriate page

    Examples:
      | epu | entryNo | requestType | route   | transport | transportName | email        | entryDateCYA | file        |
      | 123 | A23456A | New         | Route 1 | Maritime  | Test Vessel   | abc@test.com | Today        | testOdp.odp |

  Scenario Outline: A user wants to complete a Cancellation Export RouteOne journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects Yes and continues
    When the user is on the Priority Goods page, selects <priority> and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Optional Transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for New
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    Then the user will see text to cancel
#    And the user should see 2 Hour SLA
    When the user clicks the chief unavailable link they will be redirected to the appropriate page

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | transportName | email   | file        |
      | 123 | A23456A | Cancellation | Route 1 | Human remains | Air       | Test Vessel   | a@a.com | testDoc.doc |

  Scenario Outline: A user wants to complete a Withdrawal Export RouteOne journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects Yes and continues
    When the user is on the Priority Goods page, selects <priority> and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Optional Transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for New
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    Then the user will see text to withdraw
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | transportName | email   | file        |
      | 123 | A23456A | Withdrawal  | Route 1 | Human remains | Maritime  | Test Vessel   | a@a.com | testXls.xls |


  @accessibility @ZAP
  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page & no SLA provided
    Given the user is on the temp start page and enters the journey then they will be on the landing page
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
    Then the user is on the multi-file upload pages for New
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA
    When the user clicks the gov.uk icon link they will be redirected to the appropriate page

    Examples:
      | epu       | entryNo        | requestType | route | transport | transportName | email                 | file          |
      | randomEPU | randomExportEN | New         | Hold  | Maritime  | Test Vessel   | person_real@ymail.com | testXlsx.xlsx |

  Scenario Outline: C160* upload inset text
    Given the user is on the temp start page and enters the journey then they will be on the landing page
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
    Then the user is on the multi-file upload pages for New
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
      | epu       | entryNo        | requestType | route   | transport | transportName | file          |
      | randomEPU | randomExportEN | C1601       | Route 3 | Maritime  | boat          | testDocx.docx |
