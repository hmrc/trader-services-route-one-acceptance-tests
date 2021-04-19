@TraderService

Feature: Customs check - Import journeys

  Scenario Outline: A user wants to complete a New Import journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    And the user clicks continue
    Then the user will be on the Import Contact details page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for New
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading

    Then the user will be on the Import CYA page
    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    And the user should see the Entry Date row & the date <entryDateCYA> on the CYA page
    Then the user should see the Import Request type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    Then the user should see the Transport name row & the correct response "-" on the CYA page
    And the user should see the Transport date Arrival row & the correct response "-" on the CYA page
    And the user should see the Transport time Arrival row & the correct response "-" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phone>" on the CYA page
    And the user clicks submit on the CYA page

    Then the user is on the New confirmation page
    Then the user will see text to give-feedback
#    And the user should see 2 Hour SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority      | ALVS | transport | name      | email            | phone         | entryDateCYA | file        |
      | 093 | 127756A | New         | Route 6 | Human remains | Yes  | Air       | Abc Testb | valida@email.com | 01234 567 899 | Today        | testPdf.pdf |

  @accessibility @ZAP
  Scenario Outline: A user wants to complete a Cancellation Import journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    And the user clicks continue
    Then the user will be on the Import Contact details page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for New
    When the user clicks the button to upload file "1" and selects "<file>"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Import CYA page
    And the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    Then the user will see text to cancel
    When the user clicks the confirmation feedback link they will be redirected to the appropriate page
#    And the user should see Maritime-Import SLA

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | name  | email          | file          |
      | 555 | 151511c | Cancellation | Route 6 | Human remains | Maritime  | Mr. F | valid@test.com | testJpeg.jpeg |

  @accessibility @ZAP
  Scenario Outline: Route-Hold: A user should reach the mandatory Transport page (+ lang toggle check)
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects No and continues
    Then the user is on the ALVS page, selects No and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Mandatory Transport details page
    When the user clicks the cy toggle it should translate the page
    When the user clicks the en toggle it should translate the page

    Examples:
      | epu | entryNo | requestType | route | transport |
      | 123 | 123456A | New         | Hold  | Maritime  |