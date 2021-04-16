@TraderServiceErrors @accessibility @ZAP
Feature: Error pages

  Scenario Outline: A user enters a duplicate case (Stub EPU: 667)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user is on the Export Request type page, selects <requestType> and continues
    When the user is on the Export Route type page, selects <route> and continues
    Then the user is on the Export YesNo Priority page, selects Yes and continues
    When the user is on the Export Priority Goods page, selects <priority> and continues
    Then the user is on the Export Transport type page, selects <transport> and continues
    When the user will be on the Export-Optional transport details page
    * the user clicks continue
    Then the user will be on the Export Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    * the user clicks the button to upload the first file and selects the "pdf" file
    * the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the duplicate case error page

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | email   |
      | 667 | A23456A | Cancellation | Route 2 | Human remains | Air       | a@a.com |


  Scenario Outline: A user enters a failed request (Stub EPU: 666)
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user is on the Export Request type page, selects <requestType> and continues
    When the user is on the Export Route type page, selects <route> and continues
    Then the user is on the Export YesNo Priority page, selects Yes and continues
    When the user is on the Export Priority Goods page, selects <priority> and continues
    Then the user is on the Export Transport type page, selects <transport> and continues
    When the user will be on the Export-Optional transport details page
    * the user clicks continue
    Then the user will be on the Export Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    * the user clicks the button to upload the first file and selects the "pdf" file
    * the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the error page for internal server error

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | email   |
      | 666 | X23456A | New         | Route 3 | Human remains | Air       | a@a.com |


  Scenario: A user hits the wrong url
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user navigates to the following "/entry-detailx"
    Then the user will be on the error page for page not found
    When the user clicks the link on the Page not found page they will be on the start page


