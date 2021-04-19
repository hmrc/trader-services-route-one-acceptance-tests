@TraderService
Feature: Back Links & Change Links

  Scenario Outline: Import: Set up journey
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    * the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects No and continues
    Then the user will be on the ALVS page
    When the user is on the ALVS page, selects Yes and continues
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    * the user clicks continue
    Then the user will be on the <journey> Contact details page
    * the user enters an email address "<email>"
    * the user clicks continue
    Then the user is on the multi-file upload pages for New
    * the user clicks the button to upload file "1" and selects "testPdf.pdf"
    * the user clicks continue when files have finished uploading
    Then the user will be on the <journey> CYA page

    Examples:
      | journey | epu | entryNo | requestType  | route   | transport | email      |
      | Import  | 113 | 993456A | Cancellation | Route 1 | Air       | a@test.com |


# After continuing the user will be back on the CYA page unless otherwise stated
# Step not included as if they can click change link they will be on CYA page....

  Scenario Outline: Change links, including switch from optional transport details to mandatory (Route-Hold)
    Given the user will be on the <journey> CYA page
    When the user answered NoToPriority then they should see the correct responses for the Import journey "", "<ALVS>" & "<transport>"
    When the user clicks the change link for Documents
    Then the user is on the multi-file upload pages for New
    When the user clicks the button to upload file "2" and selects "testOds.ods"
    Then the user clicks continue when files have finished uploading

    When the user clicks the change link for ContactDetails
    * the user will be on the <journey> Contact details page
    * the user clicks continue

    When the user clicks the change link for Transport
    When the user is on the Transport type page, selects <transport> and continues

    When the user clicks the change link for TransportDetails
    * the user will be on the Import-Optional Transport details page
    * the user clicks continue

    When the user clicks the change link for ALVS
    * the user will be on the ALVS page
    * the user clicks continue

    When the user clicks the change link for PriorityYN
    Then the user is on the YesNo Priority page, selects Yes and continues
    Then the user is on the Priority Goods page, selects <priority> and continues
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for Route
    Then the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user clicks continue
    Then the user will be on the <journey> Priority Goods page
    When the user clicks continue
    Then the user will be on the ALVS page
    When the user clicks continue
    Then the user will be on the <journey> Transport type page
    And the user clicks continue
    Then the user will be on the Import-Mandatory Transport details page
    * the user enters "<transportName>" for transport name
    * the user enters today's date for transportDateArrival
    * the user enters a time of Arrival for their transportation "11" "15"
    When the user clicks continue
    Then the user will be on the <journey> CYA page

    When the user clicks the change link for Request
    Then the user is on the Request type page, selects <requestType> and continues

    Then the user clicks the change link for Entry
    Then the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    When the user clicks continue
    Then the user will be on the <journey> CYA page

    Examples:
      | journey | epu | entryNo | requestType  | route | priority      | ALVS | transport | transportName |
      | Import  | 113 | 993456A | Cancellation | Hold  | Human remains | Yes  | Air       | TestShip      |

  Scenario Outline: Import: A user goes back through the journey
    Given the user will be on the <journey> CYA page
    When the user clicks back
    Then the user is on the multi-file upload pages for New
    When the user clicks back
    Then the user will be on the <journey> Contact details page
    And the details entered for name, email and phone number should be pre-filled with "", "<email>" & ""

    When the user clicks back
    Then the user will be on the Import-Optional Transport details page
    And the details entered for transport name should be pre filled with "<transportName>"
    And the details entered for transportDateArrival should be pre filled with today's date
    And the details entered for Time of Arrival should be pre filled with "11" & "15"

    When the user clicks back
    Then the user will be on the <journey> Transport type page
    And the last selected option for Transport type should be pre filled with <transport>

    When the user clicks back
    Then the user will be on the ALVS page
    And the last selected option for ALVS should be pre filled with Yes

    When the user clicks back
    Then the user will be on the <journey> Priority Goods page
    And the last selected option for Priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user will be on the <journey> YN Priority page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user will be on the <journey> Route type page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user will be on the <journey> Request type page
    And the last selected option for <journey> Request should be pre filled with <requestType>

    When the user clicks back
    Then the user will be on the entry details page
    * the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    * the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with New
    When the user clicks continue
    Then the user enters entry details "<epu>" and "X00000H"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the last selected option for Export Request should be pre filled with Nothing

    When the user clicks the service name link they will be redirected to the appropriate page
    * the user will be on the start page for trader services
    * the last selected option for journey type should be pre filled with Nothing

    When the user clicks back
    Then the user will be on the temporary start page

    Examples:
      | journey | epu | entryNo | requestType  | route | priority      | transport | transportName | email      |
      | Import  | 113 | 993456A | Cancellation | Hold  | Human remains | Air       | TestShip      | a@test.com |

# Amend
  Scenario Outline: Amend: Set up....
    Given the user is on the temp start page and enters the journey then they will be on the landing page
    When the user is on the start page for trader services, selects <journey> and continues
    Then the user will be on the Case Reference number page
    When the user enters "<caseRef>" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    Then the user is on the multi-file upload pages for <journey>
    * the user clicks the button to upload file "1" and selects "<file>"
    * the user clicks continue when files have finished uploading
    Then the user is on the Amend <amendType> review page and should see their responses

    Examples:
      | journey | caseRef | amendType      | message          | file     |
      | Amend   | valid   | writeAndUpload | Hello Caseworker | testPptx.pptx |

  Scenario Outline: Amend: Change links
    Given the user is on the Amend <amendType> review page and should see their responses

    When the user clicks the change link on the amend review page for caseRef
    Then the user will be on the Case Reference number page

    When the user enters "valid" characters for case reference number and continues
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects uploadOnly and continues
    Then the user is on the multi-file upload pages for <journey>
    And the user clicks MFU continue

    When the user clicks the change link on the amend review page for amendment
    Then the user will be on the Amendment type page
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses
    When the user clicks the change link on the amend review page for message
    Then the user will be on the write response page
    When the user enters "<message>" characters in the write response field and continues
    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses
    When the user clicks the change link on the amend review page for documents
    Then the user is on the multi-file upload pages for <journey>
    When the user clicks MFU continue
    Then the user is on the Amend <amendType> review page and should see their responses

    Examples:
      | journey | amendType      | message          |
      | Amend   | writeAndUpload | Hello Caseworker |

  Scenario Outline: Amend Back links - A user wants to go back to the start
    Given the user is on the Amend <amendType> review page and should see their responses
    Then the user clicks back
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
