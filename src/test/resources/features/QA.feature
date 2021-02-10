@TraderServiceQA

Feature: Customs check - Export Journey

  Scenario Outline: A user wants to complete a New Export RouteOne journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
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
    And the user enters a time for the vessel "12" "25"
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks Continue
    Then the user is on the First upload page
    When the user clicks the button to upload and selects the "pdf" file
    Then the user should be on the new file upload confirmation page after uploading 1 document/s

#    Then the user selects Yes to uploading another file
#    Then the user is on the Another upload page
#    When the user clicks the button to upload and selects the "jpeg" file
#    Then the user should be on the new file upload confirmation page after uploading 2 document/s
#
#    Then the user selects Yes to uploading another file
#    Then the user is on the Another upload page
#    When the user clicks the button to upload and selects the "ods" file
#    Then the user should be on the new file upload confirmation page after uploading 3 document/s

    Then the user selects No to uploading another file
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    And the user should see 2 Hour SLA
    Then the user copies the case reference number
    Then the user waits

Examples:
| epu | entryNo | requestType | route   | priority      | transport | vesselName  | name  | email   | phone |
| 509 | X12451H | New         | Route 1 | Human remains | Maritime  | Test/Vessel | a. a. smith-smith & smith | log-abc-i@itwRWx.net | 0177 111 1111      |



  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    When the user is on the how to respond page and selects writeAndupload
    Then the user is on the write response page
    And the user enters a response with valid characters
    Then the user is on the Amend upload page
    Then the user clicks the button to upload and selects the "png" file
    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
    Then the user selects No to uploading another file
    When the user clicks Submit on the CYA page
    Then the user waits

#  Scenario Outline: A user wants to complete a New Import journey
#    Given the user logs into QA
#    Then the user is on the start page for trader services and selects New
#    Then the user is on the declaration details page
#    When the user enters declaration details "<epu>" and "<entryNo>"
#    And the user enters today's date for entryDate
#    Then the user clicks Continue
#    When the user is on the Import Request Type page and selects <requestType>
#    Then the user is on the Import Route Type Page and selects <route>
#    When the user is on the Import YesNo Priority Page and selects Yes
#    Then the user is on the Import Priority Options Page and selects <priority>
#    When the user is on the ALVS Page and selects Yes
#    Then the user is on the Import Transport Type Page and selects <transport>
#    Then the user is on the Import-Optional Vessel Page
#    Then the user enters "<vesselName>" for vessel name
#    And the user enters today's date for vesselDate
#    And the user enters a time for the vessel "12" "25"
#    And the user clicks Continue
#    Then the user enters a name "<name>"
#    And the user enters an email address "<email>"
#    And the user enters a phone number "<phone>"
#    And the user clicks Continue
#    Then the user is on the First upload page
#    When the user clicks the button to upload and selects the "pdf" file
#    Then the user should be on the new file upload confirmation page after uploading 1 document/s
#    Then the user selects No to uploading another file
#    Then the user is on the Import CYA page
#    And the user clicks Submit on the CYA page
#    Then the user copies the case reference number
#    Then the user waits
#
#
#    Examples:
#      | epu | entryNo |requestType | route   | priority      | transport | vesselName | name   | email          | phone |
#      | 333 | 333456A |New         | Route 6 | Human remains | Air       | aeroplane 1 | Mr. F  | valid@test.com | 01256888999|
#
#  Scenario: Amend: A user adds a message and a document to a case (upload only)
#    Given the user is on the start page for trader services and selects Amend
#    Then the user is on the case ref number page
#    When the user is on the how to respond page and selects uploadOnly
#    Then the user is on the Amend upload page
#    Then the user clicks the button to upload and selects the "xlsx" file
#    Then the user should be on the amend file upload confirmation page after uploading 1 document/s
#    Then the user selects No to uploading another file
#    When the user clicks Submit on the CYA page
#    Then the user waits

  #Legit EPUS
#    410
#    516
#    515
#    011
#    033
#    048
#    060
#    245
#    436
#    071
#    120
#    080
#    191
#    470
#    084
#    110
#    155
#    223
#    191
#    065
#    182
#    295
#    218
#    511
#    077
#    221
#    240
#    250
#    291
#    292
#    443
#    270
#    430
#    293
#    290
#    121
#    219
#    150
