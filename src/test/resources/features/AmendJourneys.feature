@TraderService
Feature: Amend journeys

#    Write Response
  Scenario: A user wants to add a message to their case (write response only)
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    Then  the user is on the Amendment type page, selects writeOnly and continues
    Then the user is on the write response page
    When the user enters "Test message" characters in the write response field and continues
    Then the user is on the Amend writeOnly review page and should see their responses
    And the user should see what they entered as their message "Test message"
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page

#    Upload Only
  Scenario: A user wants to add another document to a case (upload only)
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    Then the user is on the Amendment type page, selects uploadOnly and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload the first file and selects the "xls" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend uploadOnly review page and should see their responses
    And the user should see what the files they uploaded "testXls.xls"
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page

#    Write Response & Upload
  @accessibility @ZAP
  Scenario: Amend: A user adds a message and a document to a case (write response + upload)
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user is on the write response page
    And the user enters "valid" characters in the write response field and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    And the user will only see inset text for Request type N/A
    When the user clicks the button to upload the first file and selects the "xlsx" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend writeAndUpload review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    Then the user clicks the amend NCH link they will be redirected to the appropriate page
