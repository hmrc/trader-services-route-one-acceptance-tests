@TraderService @accessibility
Feature: Error pages

  Scenario Outline: A user enters a failed request (Stub EPU: 666)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the <journey> Transport type page
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the error page for internal server error

    Examples:
      | journey | epu | entryNo | requestType | route   | transport | email   | file        |
      | Export  | 666 | X23456A | New         | Route 1 | Air       | a@a.com | testOdt.odt |


  Scenario Outline: A user enters a duplicate case (Stub EPU: 667)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the <journey> Transport type page
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the duplicate case error page and see their case reference number

    Examples:
      | journey | epu | entryNo | requestType | route   | transport | email   | file        |
      | Export  | 667 | A23456A | New         | Route 2 | Air       | a@a.com | testOds.ods |


  Scenario Outline: A user enters an invalid case reference number
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    When the user clicks submit on the CYA page
    Then the user will be on the error page for an amend journey internal server error
    When the user clicks the link to re enter a case ref number they will be on the case ref page

    When the user enters "valid" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the Amend review page
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | caseNo                 | amendType | message   |
      | Amend   | PC12010081330XGBNZJ666 | writeOnly | Test Text |

  Scenario: A user hits the wrong url
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user navigates to the following "/entry-detailx"
    Then the user will be on the error page for page not found
    When the user clicks the link on the Page not found page they will be on the start page


