@TraderServiceQA

Feature: Customs check - Export journey

  Scenario Outline: A user wants to complete an Export RouteOne journey
    Given the user logs into QA
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    Then the user is on the YesNo Priority page, selects Yes and continues
    When the user is on the Priority Goods page, selects <priority> and continues
    Then the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Export-Optional Transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "15" "59"
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user will be on the multi-file upload pages for New
    When the user clicks the button to upload file "1" and selects "testPdf.pdf"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Export CYA page
    Then the user clicks submit on the CYA page
    Then output the case reference number
#    And the user should see 2 Hour SLA
#    Then the user will see text to give-feedback
#    Then the user waits 10000
#    Then the user clicks the button to submit another case on the confirmation page they will go back to the start
#    When the user clicks the deskpro link they will be redirected to the appropriate page
#    When the user clicks the UR banner link they will be redirected to the appropriate page

    Examples:
      | epu       | entryNo        | requestType | route   | priority      | transport    | transportName | name  | email     | phone         |
      | randomEPU | randomExportEN | New         | Route 6 | Human remains | RoadRoRoRail | TestVessel    | smith | testEmail | 0177 111 1111 |

  Scenario Outline: A user wants to complete a New Import journey
    Given the user logs into QA
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    Then the user clicks continue
    When the user is on the Request type page, selects <requestType> and continues
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    Then the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateArrival
    And the user enters a time of Arrival for their transportation "12" "30"
    And the user clicks continue
    Then the user enters a name "<name>"
    And the user enters an email address "<email>"
    And the user enters a phone number "<phone>"
    And the user clicks continue
    Then the user will be on the multi-file upload pages for New
    When the user clicks the button to upload file "1" and selects "testJpg.jpg"
    Then the user clicks continue when files have finished uploading
    Then the user will be on the Import CYA page
    And the user clicks submit on the CYA page
    And the user should see Maritime-Import SLA
    Then the user will see text to give-feedback
    Then output the case reference number
    Then the user waits 10000
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start
    When the user clicks the banner feedback link they will be redirected to the appropriate page


    Examples:
      | epu       | entryNo        | requestType | route   | priority      | transport | transportName | name  | email     | phone       |
      | randomEPU | randomImportEN | New         | Route 1 | Human remains | Maritime  | train 1x      | agent | testEmail | 01256888999 |

  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services, selects Amend and continues
    Then the user will be on the Case Reference number page
    Then the user enters "PCI21040921252PZVD43D4" characters for case reference number and continues
    When the user will be on the Amendment type page
    Then the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user will be on the write response page
    When the user enters "valid" characters in the write response field and continues
    Then the user will be on the multi-file upload pages for Amend
    When the user clicks the button to upload file "1" and selects "testDocx.docx"
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    When the user clicks the button to upload the third file and selects the "docx" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the fourth file and selects the "odt" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the fifth file and selects the "ppt" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the sixth file and selects the "pptx" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the seventh file and selects the "odp" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the eighth file and selects the "xls" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    * the user clicks the button to upload the ninth file and selects the "xlsx" file
#    Then the user clicks the button to add another document
#    When the user clicks the button to upload file "<fileOrder>" and selects "<file>"
#    Then the user waits 50000
#    Then the user clicks MFU continue
#    Then the user clicks continue when files have finished uploading
    When the user clicks submit on the CYA page
    Then the user will be on the Amend confirmation page
    Then the user waits 10000
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start

  Scenario: Amend: A user adds a message and a document to a case (write response only)
    Given the user logs into QA
    When the user is on the temp start page and enters the journey then they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user will be on the Case Reference number page
    Then the user enters "PCI21040921252PZVD43D4" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects writeOnly and continues
    And the user enters "valid" characters in the write response field and continues
    When the user clicks submit on the CYA page
    Then the user will be on the Amend confirmation page
    Then the user waits 10000
#    When the user signs out they will be on the give feedback page

