@accessibility

Feature: Accessibility test the service

  Scenario Outline: Accessibility - every page in journey hit (Export - Vessel-Optional)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
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
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDate
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    And the user enters an email address "<email>"
    When the user enters a name "<name>"
    And the user clicks Continue
    Then the user is on the Export CYA page
    Then the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects "first" file
    Then the user should be on the file upload confirmation page after uploading 1 document/s
    Then the user selects No to to uploading another file
    Then the user is on the final confirmation page
    And the user should see a case reference number

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | vesselName  | name  | email   |
      | 123 | A23456A | New         | Route 1 | Class A drugs | Maritime  | Test Vessel | Mr. F | a@a.com |

  Scenario Outline: Accessibility - every page in journey hit (Import - Vessel-Mandatory)

    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
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


  Scenario Outline: Accessibility - every page in journey hit (Import - Vessel-Optional)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
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
    Then the user is on the Import CYA page
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects "first" file
    Then the user should be on the file upload confirmation page after uploading 1 document/s
    Then the user selects No to to uploading another file
    Then the user is on the final confirmation page
    And the user should see a case reference number

    Examples:
      | epu | entryNo |requestType | route   | priority      | transport | name       | email          |
      | 123 | 123456A |New         | Route 6 | Human remains | Air       | Abc Testb  | valid@test.com |

  Scenario Outline: Accessibility - every page in journey hit (Import - Vessel-Mandatory)
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
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