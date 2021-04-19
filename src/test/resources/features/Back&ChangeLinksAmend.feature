@TraderService
Feature: Back Links & Change Links - Amend

  Background: : Amend: Set up
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects Amend and continues
    Then the user will be on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user will be on the write response page
    When the user enters "Hello Caseworker" characters in the write response field and continues
    Then the user is on the multi-file upload pages for Amend
    * the user clicks the button to upload file "1" and selects "testPptx.pptx"
    * the user clicks continue when files have finished uploading
    Then the user is on the Amend writeAndUpload review page and should see their responses


  Scenario Outline: Amend: Change links
    When the user clicks the change link on the amend review page for caseRef
    Then the user will be on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues

    Then the user will be on the Amendment type page
    When the user clicks continue

    Then the user will be on the write response page
    When the user clicks continue

    Then the user is on the multi-file upload pages for <journey>
    And the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for amendment
    Then the user will be on the Amendment type page
    When the user clicks continue

    Then the user will be on the write response page
    When the user clicks continue
    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue

    Then the user is on the Amend <amendType> review page and should see their responses
    When the user clicks the change link on the amend review page for message
    Then the user will be on the write response page
    When the user clicks continue

    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for documents
    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses

    When the user clicks submit on the CYA page
    Then the user will be on the <journey> confirmation page

    Examples:
      | journey | amendType      |
      | Amend   | writeAndUpload |


  Scenario Outline: Amend Back links - A user wants to go back to the start
    Then the user is on the Amend <amendType> review page and should see their responses
    When the user clicks back
    Then the user is on the multi-file upload pages for <journey>

    Then the user clicks back
    Then the user will be on the write response page
    And the details in the text box should be pre-filled with "<message>"

    When the user clicks back
    Then the user will be on the Amendment type page
    And the last selected option for type of amendment should be <amendType>

    When the user clicks back
    Then the user will be on the Case Reference number page
    And the details in the case ref field should be pre-filled with "<caseRef>"

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with Amend

    Then the user clicks the service name link they will be redirected to the appropriate page
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | journey | caseRef                | amendType      | message          |
      | Amend   | PC12010081330XGBNZJO04 | writeAndUpload | Hello Caseworker |
