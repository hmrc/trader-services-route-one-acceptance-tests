@TraderServiceQA

Feature: Customs check - Export journey

  Scenario Outline: A user wants to complete an Export RouteOne journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
#    And the user waits 7000
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request Type page and selects <requestType>
    Then the user is on the Export Route Type page and selects <route>
    Then the user is on the Export YesNo Priority page and selects Yes
    When the user is on the Export Priority Goods page and selects <priority>
    Then the user is on the Export transport type page and selects <transport>
    Then the user is on the Export-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "15" "59"
    Then the user clicks continue
    Then the user is on the Export contact details page
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
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
    When the user clicks the button to upload the ninth file and selects the "odt" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the tenth file and selects the "ods" file
    Then the user waits 50000
    Then the user clicks MFU continue
#    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    Then the user clicks submit on the CYA page
    Then the user waits 7000
    Then output the case reference number
    And the user should see 2 Hour SLA
    Then the user will see text to give-feedback
    Then the user waits 5000
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport    | transportName | name  | email     | phone         |
      | 008 | D55816G | New         | Route 6 | Human remains | RoadRoRoRail | TestVessel    | smith | testEmail | 0177 111 1111 |

  Scenario Outline: A user wants to complete a New Import journey
    Given the user logs into QA
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type page and selects <route>
    When the user is on the Import YesNo Priority page and selects Yes
    Then the user is on the Import Priority Goods page and selects <priority>
    When the user is on the ALVS page and selects Yes
    Then the user is on the Import transport type page and selects <transport>
    Then the user is on the Import-Optional transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateArrival
    And the user enters a time of Arrival for their transportation "12" "30"
    And the user clicks continue
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "txt" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    And the user waits 7000
    And the user clicks submit on the CYA page
    And the user should see Maritime-Import SLA
    Then the user will see text to give-feedback
    Then output the case reference number
    Then the user waits 5000
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start

    Examples:
      | epu | entryNo | requestType | route   | priority      | transport | transportName | name  | email     | phone       |
      | 008 | 908196Q | New         | Route 1 | Human remains | Maritime  | train 1x      | agent | testEmail | 01256888999 |

  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    Then the user enters a real case reference number PCI21040921252PZVD43D4
    When the user is on the how to respond page and selects writeAndUpload
    Then the user is on the write response page
    And the user enters a response "ABCDEFHIJKLMNOPQRSTUVWXYZ abcdefhijklmnopqrstuvwxyz 1234567890 œ∑´´†¥¨^^πåß∂ƒ©˙∆˚¬Ω≈ç√∫~~" and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "pdf" file

    When the user clicks the button to upload the second file and selects the "doc" file
    When the user clicks the button to upload the third file and selects the "docx" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the fourth file and selects the "odt" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the fifth file and selects the "ppt" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the sixth file and selects the "pptx" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the seventh file and selects the "odp" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the eighth file and selects the "xls" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the ninth file and selects the "xlsx" file
    Then the user clicks the button to add another document
    When the user clicks the button to upload the tenth file and selects the "ods" file
    Then the user waits 50000
    Then the user clicks MFU continue
#    Then the user clicks continue when files have finished uploading
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page
    Then the user waits 5000
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start

  Scenario: Amend: A user adds a message and a document to a case (write response only)
    Given the user logs into QA
    When the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects Amend
    Then the user is on the case ref number page
    Then the user enters a real case reference number PCI21040921252PZVD43D4
    When the user is on the how to respond page and selects writeOnly
    And the user enters a response "!@£$%^&*()_+¡€#¢∞§¶•ªº–≠§±-=[];'\,./{}:"|<>?“‘…æ«≤≥æ`~" and continues
    When the user clicks submit on the CYA page
    Then the user waits 6000
#    When the user signs out they will be on the give feedback page
#
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
