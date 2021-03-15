@TraderServiceQA

Feature: Customs check - Export Journey

  Scenario Outline: A user wants to complete a New Export RouteOne journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type Page and selects <route>
    Then the user is on the Export YesNo Priority Page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export Transport Type Page and selects <transport>
    Then the user is on the Export-Optional Vessel Page
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDateDeparture
    And the user enters a Time of Departure for the vessel "15" "59"
    Then the user clicks Continue
    Then the user is on the Export Contact Details Page
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey

    When the user clicks the button to upload the first file and selects the "pdf" file
#    When the user clicks the button to upload the second file and selects the "jpeg" file
#    When the user clicks the button to upload the third file and selects the "jpg" file
#
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload the fourth file and selects the "png" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload the fifth file and selects the "tiff" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload the sixth file and selects the "C1602" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload the seventh file and selects the "txt" file
#    Then the user waits 27000
    Then the user clicks Continue when files have finished uploading
#    Then the user clicks MFU Continue
    Then the user is on the Export CYA page
    Then the user clicks Submit on the CYA page
    Then the user waits 5000
    Then the user copies the case reference number
    And the user should see 2 Hour SLA
    Then the user waits 5000

Examples:
| epu | entryNo | requestType | route   | priority      | transport | vesselName  | name  | email              | phone         |
| 601 |C56184T | C1603         | Route 1 | Human remains | RoadRoRoRail  | TestVessel  | smith | aa_kaygcc@test.com | 0177 111 1111 |

# RoadRoRoRail

  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    Then the user enters a real case reference number PCE2103151997ZK93MZD51
    When the user is on the how to respond page and selects writeAndupload
    Then the user is on the write response page
    And the user enters a response "sample message" and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "msg" file
#    When the user clicks the button to upload the second file and selects the "tiff" file
    Then the user clicks Continue when files have finished uploading
    When the user clicks Submit on the CYA page
    Then the user is on the Amend confirmation page
    Then the user waits 4000

  Scenario Outline: A user wants to complete a New Import journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks Continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    When the user is on the Import YesNo Priority Page and selects Yes
    Then the user is on the Import Priority Goods Page and selects <priority>
    When the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import-Optional Vessel Page
    Then the user enters "<vesselName>" for vessel name
    And the user enters today's date for vesselDateArrival
    And the user enters a Time of Arrival for the vessel "12" "30"
    And the user clicks Continue
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "txt" file
    Then the user clicks Continue when files have finished uploading
    Then the user is on the Import CYA page
    And the user clicks Submit on the CYA page
    And the user should see 2 Hour SLA
    Then the user copies the case reference number
    Then the user waits 5000


    Examples:
      | epu | entryNo |requestType | route   | priority      | transport | vesselName | name   | email          | phone |
      | 011 | 100041L |New | Route 6 | Human remains | Air       | train 1x | customs agent | valid@test.com | 01256888999|

  Scenario: Amend: A user adds a message and a document to a case (write response only)
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    Then the user enters a real case reference number PCI2103151788LR2K91HY3
    When the user is on the how to respond page and selects writeOnly
    And the user enters a response "sample message" and continues
    When the user clicks Submit on the CYA page
    Then the user waits 1000

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
