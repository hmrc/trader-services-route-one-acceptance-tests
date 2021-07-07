@TraderService
Feature: Change Links for a New journey

  Background: Set up journey - Import
    Given the user is on the temp start page and enters the journey they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
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
    Then the user will be on the Import-Optional Transport details page
    * the user clicks continue
    Then the user will be on the Import Contact details page
    * the user enters an email address "abc@test.com"
    * the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user clicks the button to upload file "1" and selects "testPdf.pdf"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Import CYA page

  @accessibility
  Scenario Outline: A user changes to route hold - makes transport details mandatory
    When the user clicks the change link for Route
    Then the user is on the Route type page, selects Hold and continues
    Then the user will be on the <journey> YN Priority page
    When the user clicks continue
    Then the user will be on the <journey> Priority Goods page
    When the user clicks continue
    Then the user will be on the ALVS page
    When the user clicks continue
    Then the user will be on the <journey> Transport type page
    And the user clicks continue
    Then the user will be on the Import-Mandatory Transport details page

    Examples:
      | journey |
      | Import  |

  Scenario Outline: User checks the change links (and changes answer for priority goods)
    When the user clicks the change link for Documents
    Then the user will be on the multi-file upload pages for New
    When the user clicks MFU continue
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for ContactDetails
    * the user will be on the <journey> Contact details page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for TransportDetails
    * the user will be on the Import-Optional Transport details page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for Transport
    * the user will be on the <journey> Transport type page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for ALVS
    * the user will be on the ALVS page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for PriorityYN
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for Route
    * the user will be on the <journey> Route type page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    When the user clicks the change link for Request
    * the user will be on the <journey> Request type page
    * the user clicks continue
    * the user will be on the <journey> CYA page

    Then the user clicks the change link for Entry
    Then the user will be on the entry details page
    When the user clicks continue
    Then the user will be on the <journey> CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page


    Examples:
      | journey |
      | Import  |

  Scenario Outline: User checks the change links
    When the user clicks the change link for Documents
    Then the user will be on the multi-file upload pages for New
    And the user navigates to the following "/new/import/check-your-answers"

    When the user clicks the change link for ContactDetails
    * the user will be on the <journey> Contact details page
    * the user clicks back
    * the user will be on the <journey> CYA page

    When the user clicks the change link for TransportDetails
    * the user will be on the Import-Optional Transport details page
    * the user clicks back
    * the user will be on the <journey> CYA page

    When the user clicks the change link for Transport
    * the user will be on the <journey> Transport type page
    * the user clicks back
    * the user will be on the <journey> CYA page

    When the user clicks the change link for ALVS
    * the user will be on the ALVS page
    * the user clicks back
    * the user will be on the <journey> CYA page

    When the user clicks the change link for PriorityYN
    Then the user will be on the <journey> YN Priority page
    * the user clicks back
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for Route
    * the user will be on the <journey> Route type page
    * the user clicks back
    * the user will be on the <journey> CYA page

    When the user clicks the change link for Request
    * the user will be on the <journey> Request type page
    * the user clicks back
    * the user will be on the <journey> CYA page

    Then the user clicks the change link for Entry
    Then the user will be on the entry details page
    When the user clicks back
    Then the user will be on the <journey> CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page


    Examples:
      | journey |
      | Import  |
