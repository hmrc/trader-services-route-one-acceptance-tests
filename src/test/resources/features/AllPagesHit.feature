@accessibility @ZAP

Feature: Hit all pages within the service - ZAP & Accessibility testing

  Scenario Outline: a11y/ZAP- every page in journey hit (Export - Vessel-Optional)
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Options Page and selects <priority>
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Optional Vessel Page
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects No to uploading another file
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user is on the New confirmation page
    And the user should see 2 Hour SLA
    When the user clicks the send docs link on the New confirmation page they will go back to the start


    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | email   |
      | 123 | A23456A | New         | Route 1 | Human remains | Air       | a@a.com |

  Scenario Outline: a11y/ZAP - every page in journey hit (Export - Vessel-Mandatory)

    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Mandatory Vessel Page
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    And the user enters a time for the vessel "16" "20"
    Then the user clicks Continue

    Examples:
      | epu | entryNo | requestType | route   | transport    | vesselName |
      | 123 | A23456A | C1601       | Route 1 | RoadRoRoRail | Train1     |


  Scenario Outline: a11y/ZAP - every page in journey hit (Import - Vessel-Optional)
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks Continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects Yes
    Then the user is on the Import Priority Options Page and selects <priority>
    When the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    And the user clicks Continue
    Then the user is on the Import Contact Details Page
    When the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "xlsx" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s
    Then the user selects No to uploading another file
    Then the user is on the Import CYA page
    Then the user clicks Submit on the CYA page
    Then the user is on the New confirmation page

    Examples:
      | epu | entryNo |requestType | route   | priority      | transport | name       | email          |
      | 123 | 123456A |New         | Route 6 | Human remains | Air       | Abc Testb  | valid@test.com |

  Scenario Outline: a11y/ZAP - every page in journey hit (Import - Vessel-Mandatory)
    Given the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    When the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects No
    Then the user is on the ALVS Page and selects No
    When the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Mandatory Vessel Page

    Examples:
      | epu | entryNo |requestType  | route | transport |
      | 123 | 123456A |Cancellation | Hold | Maritime   |


  Scenario: 11y/ZAP - Amend: Hit each page
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user enters valid characters for case reference number
    When the user is on the how to respond page and selects writeAndupload
    Then the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "doc" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user should see their first uploaded doc testDoc.doc on upload review page
    Then the user selects No to uploading another file
    Then the user is on the Amend writeAndupload review page and should see their responses
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page
    When the user clicks the send docs link on the Amend confirmation page they will go back to the start

