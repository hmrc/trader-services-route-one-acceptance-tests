@TraderService   @accessibility
Feature: Customs check - Export journey

  Scenario Outline: A user wants to complete a New Export journey and review their answers
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

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA

    Examples:
      | journey | epu | entryNo | requestType | route | transport | email        | transportName | file        |
      | Export  | 123 | A23456A | New         | Hold  | Maritime  | abc@test.com | PlanEx        | testOdp.odp |


  Scenario Outline: A user wants to complete a New Export journey (route 3 reason)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    Then the user is on the Route type page, selects <route> and continues

    Then the user will be on the <journey> Reason page
    When the user enters "valid" characters in the reason field and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    When the user is on the Transport type page, selects <transport> and continues

    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading

    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page

    Examples:
      | journey | epu | entryNo | requestType | route   | transport | email        | file        |
      | Export  | 129 | A23456A | New         | Route 3 | Maritime  | abc@test.com | testOdp.odp |

  @JsDisabledTraderService
  Scenario Outline: A user wants to complete a New Export journey and review their answers
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
    Then the user navigates to the single file New upload page
    * the user clicks the button to upload and selects the "pdf" file
    * the user should be on the new file upload confirmation page
    * the user selects No to uploading another file

    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA

    Examples:
      | journey | epu | entryNo | requestType | route | transport | email        | transportName |
      | Export  | 123 | A23456A | New         | Hold  | Maritime  | abc@test.com | PlanEx        |

  @JsDisabledTraderService
  Scenario Outline: A user wants to complete a New Export journey (route 3 reason)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    Then the user is on the Route type page, selects <route> and continues

    Then the user will be on the <journey> Reason page
    When the user enters "valid" characters in the reason field and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    When the user is on the Transport type page, selects <transport> and continues

    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user navigates to the single file New upload page
    * the user clicks the button to upload and selects the "pdf" file
    * the user should be on the new file upload confirmation page
    * the user selects No to uploading another file

    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page

    Examples:
      | journey | epu | entryNo | requestType | route   | transport | email        |
      | Export  | 129 | A23456A | New         | Route 3 | Maritime  | abc@test.com |