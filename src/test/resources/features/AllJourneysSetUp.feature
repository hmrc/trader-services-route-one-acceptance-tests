#@TraderService @TraderServiceErrors
#Feature: Back Links & Change Links
#
#  Scenario Outline: Import: Set up journey
#    Given the user is on the temp start page and enters the journey then they will be on the landing page
#    When the user is on the start page for trader services, selects New and continues
#    Then the user will be on the entry details page
#    * the user enters entry details "<epu>" and "<entryNo>"
#    * the user enters today's date for entryDate
#    * the user clicks continue
#    Then the user will be on the <journey> Request type page
#    When the user is on the Request type page, selects <requestType> and continues
#    Then the user will be on the <journey> Route type page
#    When the user is on the Route type page, selects <route> and continues
#    Then the user will be on the <journey> YN Priority page
#    When the user is on the YesNo Priority page, selects No and continues
#    Then the user will be on the ALVS page
#    When the user is on the ALVS page, selects Yes and continues
#    When the user is on the Transport type page, selects <transport> and continues
#    Then the user will be on the Import-Optional transport details page
#    * the user clicks continue
#    Then the user will be on the <journey> Contact details page
#    * the user enters an email address "<email>"
#    * the user clicks continue
#    Then the user is on the multi-file upload pages for New
#    * the user clicks the button to upload file "1" and selects "testPdf.pdf"
#    * the user clicks continue when files have finished uploading
#    Then the user will be on the <journey> CYA page
#
#    Examples:
#      | journey | epu | entryNo | requestType  | route   | transport | email      |
#      | Import  | 113 | 993456A | Cancellation | Route 1 | Air       | a@test.com |
#
#  Scenario Outline: Export: Set up journey
#    Given the user is on the temp start page and enters the journey then they will be on the landing page
#    When the user is on the start page for trader services, selects New and continues
#    Then the user will be on the entry details page
#    * the user enters entry details "<epu>" and "<entryNo>"
#    * the user enters today's date for entryDate
#    * the user clicks continue
#    Then the user will be on the <journey> Request type page
#    When the user is on the Request type page, selects <requestType> and continues
#    Then the user will be on the <journey> Route type page
#    When the user is on the Route type page, selects <route> and continues
#    Then the user will be on the <journey> YN Priority page
#    When the user is on the YesNo Priority page, selects No and continues
#    Then the user will be on the <journey> Transport type page
#    When the user is on the Transport type page, selects <transport> and continues
#    Then the user will be on the Export-Optional transport details page
#    * the user clicks continue
#    Then the user will be on the <journey> Contact details page
#    * the user enters an email address "<email>"
#    * the user clicks continue
#    Then the user is on the multi-file upload pages for New
#    * the user clicks the button to upload file "1" and selects "testPdf.pdf"
#    * the user clicks continue when files have finished uploading
#    Then the user will be on the <journey> CYA page
#
#    Examples:
#      | journey | epu | entryNo | requestType | route   | transport | email      |
#      | Export  | 113 | A93456A | New         | Route 1 | Air       | a@test.com |
#
#
#  Scenario Outline: Amend: Set up Journey
#    Given the user is on the temp start page and enters the journey then they will be on the landing page
#    When the user is on the start page for trader services, selects <journey> and continues
#    Then the user will be on the Case Reference number page
#    When the user enters "<caseRef>" characters for case reference number and continues
#    Then the user will be on the Amendment type page
#    When the user is on the Amendment type page, selects <amendType> and continues
#    Then the user will be on the write response page
#    When the user enters "<message>" characters in the write response field and continues
#    Then the user is on the multi-file upload pages for <journey>
#    * the user clicks the button to upload file "1" and selects "<file>"
#    * the user clicks continue when files have finished uploading
#    Then the user is on the Amend <amendType> review page and should see their responses
#
#    Examples:
#      | journey | caseRef | amendType      | message          | file      |
#      | Amend   | valid   | writeAndUpload | Hello Caseworker | testPptx.pptx |
