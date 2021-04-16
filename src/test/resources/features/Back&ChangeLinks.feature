@TraderService
Feature: Back Links & Change Links

#    Import
  Scenario Outline: Import: A user wants to go back through the journey
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request type page, selects <requestType> and continues
    Then the user is on the Import Route type page, selects <route> and continues
    Then the user is on the Import YesNo Priority page, selects Yes and continues
    When the user is on the Import Priority Goods page, selects <priority> and continues
    Then the user is on the ALVS page, selects Yes and continues
    When the user is on the Import Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional transport details page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateArrival
    And the user enters a time of Arrival for their transportation "23" "15"
    And the user clicks continue
    Then the user will be on the Import Contact details page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "doc" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    When the user clicks back
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks back
    Then the user will be on the Import Contact details page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""

    When the user clicks back
    Then the user will be on the Import-Optional transport details page
    And the details entered for transport name should be pre filled with "<transportName>"
    And the details entered for transportDateArrival should be pre filled with today's date
    And the details entered for Time of Arrival should be pre filled with "23" & "15"

    When the user clicks back
    Then the user will be on the Import Transport type page
    And the last selected option for Transport type should be pre filled with <transport>
    When the user clicks back
    Then the user is on the ALVS page
    And the last selected option for ALVS should be pre filled with Yes

    When the user clicks back
    Then the user is on the Import Priority Goods page
    And the last selected option for Priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user is on the Import YN Priority page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user will be on the Import Route type page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user will be on the Import Request type page
    And the last selected option for Import Request should be pre filled with <requestType>

    When the user clicks back
    Then the user will be on the entry details page
    And the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    And the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with New

    Then the user clicks the service name link they will be redirected to the appropriate page
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with Nothing
    When the user clicks back
    Then the user will be on the temporary start page

    Examples:
      | epu | entryNo | requestType | route   | priority                | transport | transportName | name      | email      |
      | 113 | 993456A | New         | Route 3 | Explosives or fireworks | Maritime  | TestShip      | Abc Testb | a@test.com |

  Scenario Outline: Import: A user wants to change an answer via the CYA page
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Import Request type page, selects New and continues
    Then the user is on the Import Route type page, selects Route 1 and continues
    Then the user is on the Import YesNo Priority page, selects Yes and continues
    When the user is on the Import Priority Goods page, selects <priority> and continues
    Then the user is on the ALVS page, selects No and continues
    When the user is on the Import Transport type page, selects Air and continues
    Then the user will be on the Import-Optional transport details page
    When the user enters "Test Shop" for transport name
    And the user clicks continue
    Then the user will be on the Import Contact details page
    And the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user enters a phone number "<phoneNo>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "TIF" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Import CYA page
    When the user answered YesToPriority then they should see the correct responses for the Import journey "<priority>", "No" & "Air"

    When the user clicks the change link for Documents
    Then the user is on the multi-file upload pages for a/an New journey
    And the user clicks the button to upload the second file and selects the "docx" file
    Then the user clicks continue when files have finished uploading

    When the user clicks the change link for ContactDetails
    Then the user will be on the Import Contact details page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & "<phoneNo>"
    Then the user enters a name ""
    Then the user enters a phone number ""
    Then the user clicks continue

    When the user clicks the change link for Transport
    When the user is on the Import Transport type page, selects <transport> and continues

    When the user clicks the change link for Vessel
    Then the user will be on the Import-Optional transport details page
    And the user enters "<transportName>" for transport name
    When the user clicks continue

    When the user clicks the change link for ALVS
    Then the user is on the ALVS page, selects <ALVS> and continues
    Then the user is on the Import CYA page

    When the user clicks the change link for PriorityYN
    Then the user is on the Import YesNo Priority page, selects No and continues

    When the user clicks the change link for Route
    Then the user is on the Import Route type page, selects <route> and continues
    Then the user is on the Import YN Priority page
    When the user clicks continue
    Then the user is on the ALVS page
    When the user clicks continue
    Then the user will be on the Import Transport type page
    And the user clicks continue
    Then the user will be on the Import-Mandatory transport details page
    And the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateArrival
    And the user enters a time of Arrival for their transportation "11" "15"
    When the user clicks continue
    Then the user is on the Import CYA page

    When the user clicks the change link for Request
    Then the user is on the Import Request type page, selects <requestType> and continues

    Then the user should see the Import Request type row & the correct response <requestType> on the CYA page
    And the user should see the Route row & the correct response Hold (for pre-lodged requests) on the CYA page
    And the user should see the Priority YN row & the correct response No on the CYA page
    When the user answered NoToPriority then they should see the correct responses for the Import journey "", "<ALVS>" & "<transport>"
    And the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    And the user should see the Transport date Arrival row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Transport time Arrival row & the correct response "11:15" on the CYA page
    And the user should see the Mandatory Contact details row & the correct responses "", "<email>" & "" on the CYA page

    Then the user clicks the change link for Entry
    Then the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    Then the user enters entry details "<epu>" and "X00000H"
    And the user enters today's date for entryDate
    When the user clicks continue
    Then the last selected option for Export Request should be pre filled with Nothing


    Examples:
      | epu | entryNo | requestType  | route | priority      | ALVS | transport | transportName | name      | email      | phoneNo     | entryDateCYA |
      | 113 | 993456A | Cancellation | Hold  | Human remains | Yes  | Maritime  | TestShip      | Abc Testb | a@test.com | 01234567891 | Today        |

# Export
  Scenario Outline: Export: A user wants to go back through the journey
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request type page, selects <requestType> and continues
    Then the user is on the Export Route type page, selects <route> and continues
    Then the user is on the Export YesNo Priority page, selects Yes and continues
    When the user is on the Export Priority Goods page, selects <priority> and continues
    Then the user is on the Export Transport type page, selects <transport> and continues
    Then the user will be on the Export-Optional transport details page
    And the user enters today's date for transportDateDeparture
    Then the user clicks continue
    Then the user will be on the Export Contact details page
    When the user enters a name "<name>"
    Then the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "docx" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    When the user clicks back
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks back
    Then the user will be on the Export Contact details page
    And the details entered for name, email and phone number should be pre-filled with "<name>", "<email>" & ""

    When the user clicks back
    Then the user will be on the Export-Optional transport details page
    And the details entered for transport name should be pre filled with ""
    And the details entered for transportDateDeparture should be pre filled with today's date
    And the details entered for Time of Departure should be pre filled with "" & ""

    When the user clicks back
    Then the user will be on the Export Transport type page
    And the last selected option for Transport type should be pre filled with <transport>

    When the user clicks back
    Then the user is on the Export Priority Goods page
    And the last selected option for Priority goods should be pre filled with <priority>

    When the user clicks back
    Then the user is on the Export YN Priority page
    And the last selected option for YN Priority should be pre filled with Yes

    When the user clicks back
    Then the user will be on the Export Route type page
    And the last selected option for Route should be pre filled with <route>

    When the user clicks back
    Then the user will be on the Export Request type page
    And the last selected option for Export Request should be pre filled with <requestType>

    When the user clicks back
    Then the user will be on the entry details page
    And the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    And the details entered for entryDate should be pre filled with today's date

    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with New

    Examples:
      | epu | entryNo | requestType  | route   | priority      | transport | name      | email      |
      | 553 | A33456A | Cancellation | Route 6 | Human remains | Air       | Abc Testb | a@test.com |


  Scenario Outline: Export: A user wants to change an answer via the CYA page
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the user is on the Export Request type page, selects C1601 and continues
    Then the user is on the Export Route type page, selects <route> and continues
    Then the user is on the Export YesNo Priority page, selects No and continues
    Then the user is on the Export Transport type page, selects <transport> and continues
    Then the user will be on the Export-Mandatory transport details page
    When the user enters "<transportName>" for transport name
    And the user enters today's date for transportDateDeparture
    And the user enters a time of Departure for their transportation "12" "34"
    And the user clicks continue
    Then the user will be on the Export Contact details page
    And the user enters a name "<name>"
    When the user enters an email address "<email>"
    And the user clicks continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Export CYA page
    When the user answered NoToPriority then they should see the correct responses for the Export journey "" & "<transport>"

    When the user clicks the change link for Request
    Then the user is on the Export Request type page, selects <requestType> and continues

    When the user clicks the change link for Route
    Then the user is on the Export Route type page, selects <route> and continues

    When the user clicks the change link for PriorityYN
    Then the user is on the Export YesNo Priority page, selects Yes and continues
    Then the user is on the Export Priority Goods page, selects <priority> and continues

    When the user clicks the change link for PriorityGoods
    And the last selected option for Priority goods should be pre filled with <priority>
    And the user clicks continue

    When the user clicks the change link for Vessel
    And the user will be on the Export-Optional transport details page
    And the details entered for transport name should be pre filled with "<transportName>"
    And the details entered for transportDateDeparture should be pre filled with today's date
    And the details entered for Time of Departure should be pre filled with "12" & "34"
    Then the user clicks continue

    When the user clicks the change link for Transport
    And the user is on the Export Transport type page, selects <transport> and continues

    When the user clicks the change link for ContactDetails
    Then the user will be on the Export Contact details page
    And the user enters a phone number "<phoneNo>"
    When the user clicks continue

    Then the user should see the Export Request type row & the correct response <requestType> on the CYA page
    Then the user should see the Route row & the correct response <route> on the CYA page
    Then the user should see the Priority YN row & the correct response Yes on the CYA page
    When the user answered YesToPriority then they should see the correct responses for the Export journey "<priority>" & "<transport>"
    And the user should see the Transport name row & the correct response "<transportName>" on the CYA page
    And the user should see the Transport date Departure row & the correct response "<entryDateCYA>" on the CYA page
    And the user should see the Transport time Departure row & the correct response "12:34" on the CYA page
    And the user should see the Full Contact details row & the correct responses "<name>", "<email>" & "<phoneNo>" on the CYA page

    Then the user clicks the change link for Entry
    Then the details entered for EPU & EntryNo should be pre filled with <epu> & <entryNo>
    Then the user enters entry details "<epu>" and "000000H"
    And the user enters today's date for entryDate
    And the user clicks continue
    Then the last selected option for Import Request should be pre filled with Nothing

    Examples:
      | epu | entryNo | requestType | route   | priority     | transport | transportName | name     | email        | phoneNo       | entryDateCYA |
      | 669 | X12088M | New         | Route 2 | Live animals | Air       | Ship Test     | Ms. Test | xyz@test.com | 07712 345 671 | Today        |

# Amend
  Scenario: Amend: A user wants to change their answers
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    When the user is on the Amendment type page, selects writeAndUpload and continues
    Then the user is on the write response page
    And the user enters "valid" characters in the write response field and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "pdf" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend writeAndUpload review page and should see their responses

    When the user clicks the change link on the amend review page for caseRef
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    When the user is on the Amendment type page, selects writeOnly and continues
    And the user enters "Sample message" characters in the write response field and continues
    Then the user is on the Amend writeOnly review page and should see their responses

    When the user clicks the change link on the amend review page for message
    Then the user is on the write response page
    And the user enters "Hello caseworker" characters in the write response field and continues

    When the user clicks the change link on the amend review page for amendment
    Then the user is on the Amendment type page, selects uploadOnly and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "TIF" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend uploadOnly review page and should see their responses
    When the user clicks the change link on the amend review page for documents
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the second file and selects the "png" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend uploadOnly review page and should see their responses
    When the user clicks submit on the CYA page
    Then the user is on the Amend confirmation page

  Scenario Outline: Amend Back links - A user wants to go back to the start
    Given the user is on the temp start page and enters the journey they will be on the landing page
    Then the user is on the start page for trader services, selects Amend and continues
    Then the user is on the Case Reference number page
    When the user enters "valid" characters for case reference number and continues
    When the user is on the Amendment type page, selects <amendType> and continues
    Then the user is on the write response page
    And the user enters "<text>" characters in the write response field and continues
    Then the user is on the multi-file upload pages for a/an Amend journey
    When the user clicks the button to upload the first file and selects the "jpg" file
    Then the user clicks continue when files have finished uploading
    Then the user is on the Amend writeAndUpload review page and should see their responses
    Then the user clicks back
    Then the user is on the multi-file upload pages for a/an Amend journey

    Then the user clicks back
    Then the user is on the write response page
    And the details in the text box should be pre-filled with "<text>"
    When the user clicks back
    Then the user is on the Amendment type page
    And the last selected option for type of amendment should be <amendType>
    When the user clicks back
    Then the user is on the Case Reference number page
    And the details in the case ref field should be pre-filled with "<caseRef>"
    When the user clicks back
    Then the user will be on the start page for trader services
    And the last selected option for journey type should be pre filled with Amend
    Then the user clicks the service name link they will be redirected to the appropriate page
    And the last selected option for journey type should be pre filled with Nothing

    Examples:
      | caseRef                | amendType      | text      |
      | PC12010081330XGBNZJO04 | writeAndUpload | test text |
