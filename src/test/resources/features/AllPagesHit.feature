@accessibility @ZAP

Feature: Hit all pages within the service - ZAP & Accessibility testing

  Scenario Outline: a11y/ZAP- every page in journey hit (Export - Transport-Optional)
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    When the user is on the entry details page
    And the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    When the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    When the user is on the Export-Optional transport details page
    And the user clicks continue
    Then the user is on the Export contact details page
    When the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    And the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    When the user clicks submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA
    When the user clicks the send docs link on the New confirmation page they will go back to the start


    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | email   |
      | 123 | A23456A | New         | Route 1 | Human remains | Air       | a@a.com |

  Scenario Outline: a11y/ZAP - every page in journey hit (Export - Transport-Mandatory)

    Given the user navigates to the temporary start page for trader services and clicks start
    When the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    Then the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    When the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects No
    When the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Mandatory transport details page

    Examples:
      | epu | entryNo | requestType | route   | transport    |
      | 123 | A23456A | C1601       | Route 1 | RoadRoRoRail |


  Scenario Outline: a11y/ZAP - every page in journey hit (Import - Transport-Optional)
    Given the user navigates to the temporary start page for trader services and clicks start
    When the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request Type page and selects <requestType>
    When the user is on the Import Route Type page and selects <route>
    Then the user is on the Import YesNo Priority page and selects Yes
    When the user is on the Import Priority Goods page and selects <priority>
    Then the user is on the ALVS page and selects Yes
    When the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Optional transport details page
    When the user clicks continue
    Then the user is on the Import contact details page
    When the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "jpg" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the New confirmation page

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | name      | email          |
      | 123 | 123456A | New         | Route 6 | Human remains | Air       | Abc Testb | valid@test.com |

  Scenario Outline: a11y/ZAP - every page in journey hit (Import - Vessel-Mandatory)
    Given the user navigates to the temporary start page for trader services and clicks start
    When the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    Then the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request Type page and selects <requestType>
    When the user is on the Import Route Type page and selects <route>
    Then the user is on the Import YesNo Priority page and selects No
    When the user is on the ALVS page and selects No
    Then the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Mandatory transport details page

    Examples:
      | epu | entryNo | requestType  | route | transport |
      | 123 | 123456A | Cancellation | Hold  | Maritime  |


  Scenario: 11y/ZAP - Amend: Hit each page
    Given the user navigates to the temporary start page for trader services and clicks start
    When the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number and clicks continue
    Then the user is on the how to respond page and selects writeAndUpload
    When the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend writeAndUpload review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page
    When the user clicks the send docs link on the Amend confirmation page they will go back to the start


  Scenario Outline: A user enters a duplicate case (Stub EPU: 667)
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    Then the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    When the user enters a name "<name>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user will be on the duplicate case error page
    When the user clicks the link to add documents they will be redirected to amend journey

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | transportName | name  | email   |
      | 667 | A23456A | Cancellation | Route 2 | Human remains | Air       | Test Vessel   | Mr. F | a@a.com |


  Scenario Outline: A user enters a failed request (Stub EPU: 666)
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    When the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    When the user is on the Export-Optional transport details page
    And the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    When the user clicks continue
    Then the user is on the Export contact details page
    And the user enters an email address "<email>"
    When the user enters a name "<name>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user is on the error page for internal server error

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | transportName | name  | email   |
      | 666 | X23456A | New         | Route 3 | Human remains | Air       | Test Vessel   | Mr. F | a@a.com |


  Scenario: A user hits the wrong url
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user navigates to the following "/entry-detailx"
    Then the user is on the error page for page not found
    When the user clicks the link on the page not found they will be on the start page
