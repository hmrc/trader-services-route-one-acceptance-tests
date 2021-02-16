@TraderServiceUploadsM
Feature: A user wants to upload documents

  Scenario Outline: A user wants upload some documents
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
#    When the user clicks Continue and waits
#    Then the user should see "Error:Select a file" error message for "file-1"
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the second file and selects the "ods" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the third file and selects the "odt" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the fourth file and selects the "odp" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the fifth file and selects the "doc" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the sixth file and selects the "docx" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the seventh file and selects the "xls" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the eighth file and selects the "jpg" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the ninth file and selects the "TIF" file
    Then the user clicks the button to add another document

    When the user clicks the button to upload the tenth file and selects the "png" file
    And the user waits
    Then the user clicks only clicks Continue when it's clickable
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA

    Examples:
      | epu | entryNo | requestType | route   | priority                | transport    | name       | email      |
      | 113 | 993456A | New         | Route 3 | Explosives or fireworks | RoadRoRoRail | Abc Testb  | a@test.com |
