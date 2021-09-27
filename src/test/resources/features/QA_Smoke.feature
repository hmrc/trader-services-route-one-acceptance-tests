@TraderServiceQA

Feature: Customs check - Export journey

  Scenario Outline: A user wants to complete an Export RouteOne journey
    Given the user logs into QA
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue

    When the user is on the Request type page, selects <requestType> and continues
    * the user is on the Route type page, selects <route> and continues

    Then the user will be on the <journey> Reason page
    When the user enters "!@£$%^&*()_+{}:"|<>?`~¡€#¢∞§¶•ªº–≠“‘…æ«≤≥æ234567890-" characters in the reason field and continues
    Then the user will be on the <journey> YN Priority page

    * the user is on the YesNo Priority page, selects Yes and continues
    * the user is on the Priority Goods page, selects <priority> and continues
    * the user is on the Transport type page, selects <transport> and continues

    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user enters a name "<name>"
    * the user enters a phone number "<phone>"
    * the user clicks continue

    Then the user will be on the multi-file upload pages for New
    When the user clicks the button to upload file "1" and selects "testPdf.pdf"
    And the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    * outputs the case reference number
    When the user clicks the button to submit another case on the confirmation page they will go back to the start

    Examples:
      | journey | epu       | entryNo  | requestType | route   | priority      | transport    | name  | email     | phone         |
      | Export  | randomEPU | exportEN | Withdrawal  | Route 1 | Human remains | RoadRoRoRail | smith | testEmail | 0177 111 1111 |

  Scenario Outline: A user wants to complete a New Import journey
    Given the user logs into QA
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue

    When the user is on the Request type page, selects <requestType> and continues
    * the user is on the Route type page, selects <route> and continues

    Then the user will be on the <journey> Reason page
    When the user enters "abc" characters in the reason field and continues
    Then the user will be on the <journey> YN Priority page

    * the user is on the YesNo Priority page, selects Yes and continues
    * the user is on the Priority Goods page, selects <priority> and continues
    * the user is on the ALVS page, selects Yes and continues
    * the user is on the Transport type page, selects <transport> and continues

    * the user will be on the <journey> Transport details page
    When the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateArrival
    * the user enters a time of Arrival for their transportation "12" "30"
    * the user clicks continue

    Then the user will be on the <journey> Contact details page
    * the user enters a name "<name>"
    * the user enters an email address "<email>"
    * the user enters a phone number "<phone>"
    * the user clicks continue

    Then the user will be on the multi-file upload pages for New
    When the user clicks the button to upload file "1" and selects "testDocx.docx"
    And the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    * outputs the case reference number

    Examples:
      | journey | epu       | entryNo  | requestType  | route | priority      | transport | transportName | name  | email     | phone       |
      | Import  | randomEPU | importEN | Cancellation | Hold  | Human remains | Air       | train 1x      | agent | testEmail | 01256888999 |

  Scenario Outline: Amend: A user adds a message to a case (write response only)
    Given the user logs into QA
    When the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters " PCI2108194409LWEAKJL00" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    When the user enters "valid" characters in the write response field and continues
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | amendType |
      | Amend   | writeOnly |


  Scenario Outline: Amend: A user adds a document to a case
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "PCE21081947  93OA0VOO303" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues

    Then the user will be on the multi-file upload pages for <journey>
    When the user clicks the button to upload file "1" and selects "testJpg.jpg"
    And the user clicks continue when files have finished uploading

    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | amendType  |
      | Amend   | uploadOnly |


  Scenario Outline: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user logs into QA
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "PCE2108194793OA0VOO303 " characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    When the user enters "valid" characters in the write response field and continues

    Then the user will be on the multi-file upload pages for <journey>
    When the user clicks the button to upload file "1" and selects "testDocx.docx"
    And the user clicks continue when files have finished uploading

    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page
    Then the user clicks the button to submit another case on the confirmation page they will go back to the start

    Examples:
      | journey | amendType      |
      | Amend   | writeAndUpload |


