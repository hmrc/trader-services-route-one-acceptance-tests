@TraderService  @accessibility

Feature: Customs check - Import journey

  Scenario Outline: A user wants to complete a New Import journey and review their answers

    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    Then the user is on the Route type page, selects <route> and continues
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    When the user is on the ALVS page, selects <ALVS> and continues
    When the user is on the Transport type page, selects <transport> and continues


    Then the user will be on the <journey> Transport details page
    * the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateArrival
    * the user enters a time of Arrival for their transportation "01" "37"
    * the user clicks continue

    Then the user will be on the <journey> Contact details page
    * the user enters a name "<name>"
    * the user enters an email address "<email>"
    * the user enters a phone number "071(234-567)89"
    When the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    When the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page

    Then the user should see the EPU & Entry No Rows & the correct responses <epu> & <entryNo> on the CYA page
    * the user should see the Entry Date row & the date Today on the CYA page
    * the user should see the <journey> Request type row & the correct response <requestType> on the CYA page
    * the user should see the Route row & the correct response <route> on the CYA page
    * the user should see the Priority YN row & the correct response Yes on the CYA page
    * the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "<ALVS>" & "<transport>"
    * the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    * the user should see the Transport date Arrival row & the correct response "Today" on the CYA page
    * the user should see the Transport time Arrival row & the correct response "01:37" on the CYA page
    * the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "07123 456 789" on the CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page
    And the user should see Hold SLA
    When the user clicks the button to submit another case on the confirmation page they will go back to the start
    And the last selected option for journey type should be pre filled with Nothing

    When the user clicks the cy toggle it should translate the page
    When the user clicks the en toggle it should translate the page

    Examples:
      | journey | epu | entryNo | requestType | route | priority      | ALVS | transport | transportName | name | email      | file        |
      | Import  | 123 | 123456A | New         | Hold  | Human remains | Yes  | Air       | S.S.E Alpha   | Abc  | ab@abc.com | testPdf.pdf |


  Scenario Outline: A user wants to complete a Cancellation Import journey (reason input)

    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page

    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    
    Then the user will be on the <journey> Reason page
    When the user enters "valid" characters in the reason field and continues
    Then the user will be on the <journey> YN Priority page
    
    When the user is on the YesNo Priority page, selects No and continues
    When the user is on the ALVS page, selects <ALVS> and continues
    When the user is on the Transport type page, selects <transport> and continues

    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    When the user clicks continue
    Then the user will be on the multi-file upload pages for New
    * the user will only see inset text for Request type N/A
    * the user clicks the button to upload file "1" and selects "<file>"
    When the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page

    When the user clicks submit on the CYA page
    Then the user will be on the New confirmation page

    Examples:
      | journey | epu | entryNo | requestType  | route   | ALVS | transport | email      | file        |
      | Import  | 023 | 023456A | Cancellation | Route 1 | Yes  | Air       | ab@abc.com | testPdf.pdf |