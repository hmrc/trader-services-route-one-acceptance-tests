@TraderServiceErrors
Feature: User tries to jump ahead in the journey

  Scenario: A user tries to jump ahead in an export journey to the next page
    Given the user is on the temp start page and enters the journey they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
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


#todo
  Scenario Outline: A user tries to jump ahead in an import journey to the next page
    Given the user is on the temp start page and enters the journey they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    And the user navigates to the following "/new/import/route-type"
    When the user is on the Request type page, selects New and continues
    Then the user will be on the <journey> Route type page
    And the user navigates to the following "/new/import/has-priority-goods"
    Then the user is on the Route type page, selects Route 3 and continues
    Then the user will be on the <journey> YN Priority page
    And the user navigates to the following "/new/import/which-priority-goods"
    Then the user is on the YesNo Priority page, selects Yes and continues
    Then the user will be on the <journey> Priority Goods page
    And the user navigates to the following "/new/import/automatic-licence-verification"
    Then the user is on the Priority Goods page, selects Live animals and continues
    Then the user will be on the ALVS page
    And the user navigates to the following "/new/import/transport-type"
    Then the user is on the ALVS page, selects Yes and continues
    Then the user will be on the <journey> Transport type page
    And the user navigates to the following "/new/import/transport-information"
    When the user is on the Transport type page, selects Maritime and continues
    Then the user will be on the Import-Optional Transport details page
    And the user navigates to the following "/new/import/transport-information-required"
    Then the user will be on the Import-Optional Transport details page
    And the user navigates to the following "/new/import/contact-information"
    Then the user will be on the Import-Optional Transport details page
    And the user clicks continue
    Then the user will be on the <journey> Contact details page
#    And the user navigates to the following "/new/upload-files"
#    Can skip to the page but can't get past it without email, can only jump to it from contact details page
    And the user enters an email address "trader_customs.shipping@agency.com"
    When the user clicks continue
    Then the user will be on the multi-file upload pages for New
    And the user navigates to the following "/new/import/check-your-answers"
    Then the user will be on the multi-file upload pages for New
    And the user navigates to the following "/new/confirmation"
    Then the user will be on the start page for trader services

    Examples:
      | journey | epu       | entryNo        |
      | Import  | randomEPU | importEN |


  Scenario: A user tries to jump ahead in an export journey
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/request-type"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/route-type"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/has-priority-goods"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/which-priority-goods"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/transport-type"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/transport-information"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/transport-information-required"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/contact-information"
    Then the user will be on the start page for trader services
    And the user navigates to the following "/new/export/check-your-answers"
    Then the user will be on the start page for trader services

#  order of tests / clear case reference number
#  Scenario: A user tries to jump ahead in an amend journey
#    Given the user is on the temp start page and enters the journey they will be on the landing page
#    Then the user will be on the start page for trader services
#    And the user navigates to the following "/add/case-reference-number"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/type-of-amendment"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/write-response"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/upload-files"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/file-upload"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/file-uploaded"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/check-your-answers"
#    Then the user will be on the Case Reference number page
#    And the user navigates to the following "/add/confirmation"
#    Then the user will be on the Case Reference number page