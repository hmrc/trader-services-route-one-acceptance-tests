@TraderServiceErrors
Feature: User tries to jump ahead in the journey

  Scenario: A user tries to jump ahead in an import journey from the start page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/entry-details"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/request-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/request-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/route-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/has-priority-goods"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/which-priority-goods"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/automatic-licence-verification"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/transport-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/transport-information"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/transport-information-required"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/contact-information"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/upload-files"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/file-upload"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/file-uploaded"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/import/check-your-answers"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/confirmation"
    Then the user is on the start page for trader services


  Scenario: A user tries to jump ahead in an import journey to the next page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/request-type"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/request-type"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/route-type"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/has-priority-goods"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/which-priority-goods"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/automatic-licence-verification"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/transport-type"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/transport-information"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/transport-information-required"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/contact-information"
    Then the user is on the entry details page
    And the user navigates to the following "/new/upload-files"
    Then the user is on the entry details page
    And the user navigates to the following "/new/file-upload"
    Then the user is on the entry details page
    And the user navigates to the following "/new/file-uploaded"
    Then the user is on the entry details page
    And the user navigates to the following "/new/import/check-your-answers"
    Then the user is on the entry details page
    And the user navigates to the following "/new/confirmation"
    Then the user is on the start page for trader services

  Scenario: A user tries to jump ahead in an import journey to the next page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    When the user enters entry details "110" and "123456S"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page
    And the user navigates to the following "/new/import/route-type"
    Then the user is on the Import Request Type page and selects New
    Then the user is on the Import Route Type page
    And the user navigates to the following "/new/import/has-priority-goods"
    Then the user is on the Import Route Type page and selects Route 3
    Then the user is on the Import YN Priority page
    And the user navigates to the following "/new/import/which-priority-goods"
    Then the user is on the Import YesNo Priority page and selects Yes
    Then the user is on the Import Priority Goods page
    And the user navigates to the following "/new/import/automatic-licence-verification"
    Then the user is on the Import Priority Goods page and selects Live animals
    Then the user is on the ALVS page
    And the user navigates to the following "/new/import/transport-type"
    Then the user is on the ALVS page and selects Yes
    Then the user is on the Import Transport page
    And the user navigates to the following "/new/import/transport-information"
    Then the user is on the Import Transport type page and selects Maritime
    Then the user is on the Import-Optional Transport page
    And the user navigates to the following "/new/import/transport-information-required"
    Then the user is on the Import-Optional Transport page
    And the user navigates to the following "/new/import/contact-information"
    Then the user is on the Import-Optional Transport page
    And the user clicks Continue
    Then the user is on the Import contact details page
#    And the user navigates to the following "/new/upload-files"
#    Can skip to the page but can't get past it without email, can only jump to it from contact details page
    And the user enters an email address "trader_customs.shipping@agency.com"
    When the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    And the user navigates to the following "/new/import/check-your-answers"
    Then the user is on the multi-file upload pages for a/an New journey
    And the user navigates to the following "/new/confirmation"
    Then the user is on the start page for trader services

  Scenario: A user tries to jump ahead in an export journey
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/request-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/route-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/has-priority-goods"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/which-priority-goods"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/transport-type"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/transport-information"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/transport-information-required"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/contact-information"
    Then the user is on the start page for trader services
    And the user navigates to the following "/new/export/check-your-answers"
    Then the user is on the start page for trader services

  Scenario: A user tries to jump ahead in an amend journey
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services
    And the user navigates to the following "/add/case-reference-number"
    Then the user is on the case ref number page
    And the user navigates to the following "/add/type-of-amendment"
    Then the user is on the case ref number page
    And the user navigates to the following "/add/write-response"
    Then the user is on the case ref number page
#    And the user navigates to the following "/add/upload-files"
#    Then the user is on the case ref number page
#    And the user navigates to the following "/add/file-upload"
#    Then the user is on the case ref number page
#    And the user navigates to the following "/add/file-uploaded"
#    Then the user is on the case ref number page
    And the user navigates to the following "/add/check-your-answers"
    Then the user is on the case ref number page
    And the user navigates to the following "/add/confirmation"
    Then the user is on the case ref number page