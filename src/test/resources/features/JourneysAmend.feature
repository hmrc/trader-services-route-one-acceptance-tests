@TraderService
Feature: Amend journeys

#    Write Response
  Scenario Outline: A user wants to add a message to their case (write response only)
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendmentType> and continues
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    Then the user is on the Amend <amendmentType> review page and should see their responses
    And the user should see what they entered as their message "<message>"
    When the user clicks submit on the CYA page
    Then the user is on the <journey> confirmation page
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    Then the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    Then the user clicks the amend NCH link they will be redirected to the appropriate page

    Examples:
      | journey | caseNo | amendmentType | message   |
      | Amend   | valid  | writeOnly     | Test Text |


#    Upload Only
  Scenario Outline: A user wants to add another document to a case (upload only)
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendmentType> and continues
    Then the user is on the multi-file upload pages for <journey>
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "<fileOrder>" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user is on the Amend <amendmentType> review page and should see their responses
    * the user should see what the files they uploaded "<file>"
    When the user clicks submit on the CYA page
    Then the user is on the <journey> confirmation page

    Examples:
      | journey | caseNo | amendmentType | fileOrder | file        |
      | Amend   | valid  | uploadOnly    | 1         | testXls.xls |


#    Write Response & Upload
  @accessibility @ZAP
  Scenario Outline: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseNo>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendmentType> and continues
    Then the user will be on the write response page
    And the user enters "<message>" characters in the write response field and continues
    Then the user is on the multi-file upload pages for <journey>
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "<fileOrder>" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user is on the Amend <amendmentType> review page and should see their responses
    * the user should see what the files they uploaded "<file>"
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page

    Examples:
      | journey | caseNo | amendmentType  | message | fileOrder | file        |
      | Amend   | valid  | writeAndUpload | valid   | 1         | testXls.xls |
