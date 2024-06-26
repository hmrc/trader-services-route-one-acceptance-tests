@TraderService
Feature: User can navigate to pages within each journey after inputting entry details

  Scenario: A user tries to jump ahead from entry details in an export journey to the next page
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/request-type"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/request-type"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/route-type"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/has-priority-goods"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/which-priority-goods"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/import/automatic-licence-verification"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/transport-type"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/transport-information"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/transport-information-required"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/contact-information"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/upload-files"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/file-upload"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/file-uploaded"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/export/check-your-answers"
    Then the user will be on the entry details page
    When the user navigates to the following "/new/confirmation"
    Then the user will be on the start page for trader services


  Scenario Outline: A user tries to jump ahead to the next pages after inputting <journey> entry details
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    And the user navigates to the following "/new/<journeyUrl>/route-type"
    Then the user will be on the <journey> Route type page

    And the user navigates to the following "/new/<journeyUrl>/has-priority-goods"
    Then the user will be on the <journey> YN Priority page

    And the user navigates to the following "/new/<journeyUrl>/which-priority-goods"
    Then the user will be on the <journey> Priority Goods page and navigates to ALVS in import journey

    And the user navigates to the following "/new/<journeyUrl>/transport-type"
    Then the user will be on the <journey> Transport type page

    And the user navigates to the following "/new/<journeyUrl>/transport-information"
    Then the user will be on the following url "/new/<journeyUrl>/transport-information"

    And the user navigates to the following "/new/<journeyUrl>/contact-information"
    Then the user will be on the <journey> Contact details page

    When the user navigates to the following "/new/upload-files"
    Then the user will be on the multi-file upload pages for New

    And the user navigates to the following "/new/<journeyUrl>/check-your-answers"
    Then the user will be on the <journey> CYA page
    When the user clicks submit on the CYA page
    Then the user will be on the <journey> Missing information page
    When the user clicks the button on the Missing information page they will return to entry details

    When the user navigates to the following "/new/confirmation"
    Then the user will be on the start page for trader services

    Examples:
      | journey | epu       | entryNo  | journeyUrl |
      | Import  | randomEPU | importEN |   import   |
      | Export  | randomEPU | exportEN |   export   |
