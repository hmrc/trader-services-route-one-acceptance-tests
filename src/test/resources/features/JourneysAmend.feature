
Feature: Amend journeys

#    Write Response
  @TraderService @JsDisabledTraderService
  Scenario Outline: A user wants to add a message to their case (write response only)
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    Then the user will be on the Amend <amendType> review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | caseNo | amendType | message   |
      | Amend   | valid  | writeOnly | Test Text |

  @TraderService
#    Upload Only
  Scenario Outline: A user wants to add another document to a case (upload only)
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the multi-file upload pages for <journey>
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Amend <amendType> review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | caseNo | amendType  | file        |
      | Amend   | valid  | uploadOnly | testXls.xls |

    #    Upload Only
  @JsDisabledTraderService
  Scenario Outline: A user wants to add another document to a case (upload only)
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user navigates to the single file Amend upload page
    * the user clicks the button to upload and selects the "pdf" file
    * the user should be on the amend file upload confirmation page
    * the user selects No to uploading another file
    Then the user will be on the Amend <amendType> review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | caseNo | amendType  |
      | Amend   | valid  | uploadOnly |

#    Write Response & Upload
  @accessibility
  Scenario Outline: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    And the user enters "<message>" characters in the write response field and continues
    Then the user will be on the multi-file upload pages for <journey>
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user will be on the Amend <amendType> review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    Then the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    Then the user clicks the amend NCH link they will be redirected to the appropriate page

    Examples:
      | journey | caseNo | amendType      | message | file        |
      | Amend   | valid  | writeAndUpload | valid   | testXls.xls |
