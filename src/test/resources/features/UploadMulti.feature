@TraderServiceUploads
Feature: A user wants to upload documents

  Scenario Outline: A user wants upload some documents for a new case
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Goods Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    When the user clicks the button to upload the second file and selects the "jpeg" file
    When the user clicks the button to upload the third file and selects the "jpg" file

    Then the user clicks the button to add another document
    When the user clicks the button to upload the fourth file and selects the "png" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the fifth file and selects the "tiff" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the sixth file and selects the "TIF" file

    Then the user clicks the button to add another document
    When the user clicks the button to upload the seventh file and selects the "txt" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the eighth file and selects the "msg" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the ninth file and selects the "C1601" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the tenth file and selects the "C1602" file

    Then the user waits 10000
    Then the user clicks MFU Continue
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA

    Examples:
      | epu | entryNo | requestType | route   | priority                | transport    | name       | email      |
      | 113 | 993456A | New         | Route 3 | Explosives or fireworks | RoadRoRoRail | Abc Testb  | a@test.com |

  Scenario: A user wants to add documents to their case
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects uploadOnly
    Then the user is on the multi-file upload pages for a/an Amend journey
    And the user will only see inset text for request type N/A
    When the user clicks the button to upload the first file and selects the "pdf" file
    When the user clicks the button to upload the second file and selects the "jpeg" file
    When the user clicks the button to upload the third file and selects the "jpg" file

    Then the user clicks the button to add another document
    When the user clicks the button to upload the fourth file and selects the "png" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the fifth file and selects the "tiff" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the sixth file and selects the "TIF" file

    Then the user clicks the button to add another document
    When the user clicks the button to upload the seventh file and selects the "txt" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the eighth file and selects the "msg" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the ninth file and selects the "C1601" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the tenth file and selects the "C1602" file

    Then the user waits 10000
    Then the user clicks MFU Continue
    Then the user is on the Amend uploadOnly review page and should see their responses
    And the user should see what the files they uploaded "testJpg.jpg"
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page