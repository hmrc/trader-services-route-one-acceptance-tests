@TraderService

Feature: Customs check - Import journeys

  Background:
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "123" and "123456A"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the Import Request type page

  @accessibility @ZAP
  Scenario Outline: A user wants to complete a New Import journey and review their answers
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    And the user clicks continue
    Then the user will be on the Import Contact details page
    * the user enters a name "<name>"
    * the user enters an email address "<email>"
    * the user enters a phone number "071(234-567)89"
    When the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    When the user clicks continue when files have finished uploading
    Then the user will be on the Import CYA page

    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    * the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    * the user should see the Import Request type row & the correct response <requestType> on the CYA page
    * the user should see the Route row & the correct response <route> on the CYA page
    * the user should see the Priority YN row & the correct response Yes on the CYA page
    * the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    * the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "07123 456 789" on the CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user will see text to give-feedback
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    Then the last selected option for journey type should be pre filled with Nothing

    Examples:
      | journey | epu | entryNo | requestType | route   | priority      | ALVS | transport | name      | email            | entryDateCYA | file        |
      | Import  | 123 | 123456A | New         | Route 6 | Human remains | Yes  | Air       | Abc Testb | valida@email.com | Today        | testPdf.pdf |

  @accessibility @ZAP
  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the ALVS page
    When the user is on the ALVS page, selects No and continues
    Then the user will be on the <journey> Transport type page
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Mandatory Transport details page

    Examples:
      | journey | requestType | route | transport |
      | Import  | New         | Hold  | Maritime  |