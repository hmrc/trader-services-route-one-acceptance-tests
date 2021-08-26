@TraderService   @accessibility
Feature: Customs check - Export journey

  Scenario Outline: A user wants to complete a New Import journey and review their answers
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page

    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects No and continues
    When the user is on the Transport type page, selects <transport> and continues

    Then the user will be on the <journey> Transport details page
    * the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateDeparture
    * the user enters a time of Departure for their transportation "13" "37"
    * the user clicks continue

    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user enters a phone number "00447123456789"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading

    Then the user will be on the <journey> CYA page
    And the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    * the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    * the user should see the <journey> Request type row & the correct response <requestType> on the CYA page
    * the user should see the Route row & the correct response <route> on the CYA page
    * the user should see the Priority YN row & the correct response No on the CYA page
    * the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"
    * the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    * the user should see the Transport date Departure row & the correct response "Today" on the CYA page
    * the user should see the Transport time Departure row & the correct response "13:37" on the CYA page
    * the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "07123456789" on the CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA

    Examples:
      | journey | epu | entryNo | requestType | route | transport | email        | entryDateCYA | transportName | file        |
      | Export  | 123 | A23456A | New         | Hold  | Maritime  | abc@test.com | Today        | PlanEx        | testOdp.odp |
