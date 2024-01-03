@JsDisabledTraderService
Feature: Back Links & Change Links - Amend

  Background: Set up Amend journey
    Given the user is on the start page for trader services, selects Amend and continues
    Then the user will be on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user will be on the write response page
    When the user enters "Hello Caseworker" characters in the write response field and continues
    Then the user navigates to the single file Amend upload page
    * the user clicks the button to upload and selects the "pdf" file
    * the user should be on the amend file verification page
    * the user selects No to uploading another file
    Then the user will be on the Amend writeAndUpload review page and should see their responses

  Scenario Outline: Amend: Change links (continue)
    When the user clicks the change link on the amend review page for CaseRef
    Then the user will be on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues

    Then the user will be on the Amendment type page
    When the user clicks continue
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Amendment
    Then the user will be on the Amendment type page
    When the user clicks continue
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Message
    Then the user will be on the write response page
    When the user clicks continue

    Then the user should be on the amend file upload confirmation page
    Then the user selects No to uploading another file
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Documents
    Then the user should be on the amend file upload confirmation page
    Then the user selects No to uploading another file
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | amendType      |
      | Amend   | writeAndUpload |

  Scenario Outline: Amend: Change links (back)
    When the user clicks the change link on the amend review page for CaseRef
    Then the user will be on the Case Reference number page
    When the user clicks back
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Amendment
    Then the user will be on the Amendment type page
    When the user clicks back
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Message
    Then the user will be on the write response page
    When the user clicks back
    Then the user will be on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for Documents
    Then the user navigates to the single file <journey> upload page

    When the user navigates to the following "/add/check-your-answers"
    And the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | amendType      |
      | Amend   | writeAndUpload |
