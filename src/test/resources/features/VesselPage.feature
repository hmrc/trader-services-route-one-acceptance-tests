@TraderServiceErrors
Feature: Vessel page validation

#  Import
#    All blank fields
  Scenario: Mandatory (Import) Vessel Page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "123" and "012345B"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects New
    Then the user is on the Import Route Type Page and selects Hold
    Then the user is on the Import YesNo Priority Page and selects No
    When the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects Air
    Then the user is on the Import-Mandatory Vessel Page

    When the user enters "" for vessel name
    When the user enters a Date of Arrival for the vessel "" "" ""
    When the user enters a Time of Arrival for the vessel "" ""
    When the user clicks Continue
    Then the user should see "Error:Enter the ship, vehicle or airline name" error message for "vesselName"
    Then the user should see "Error:Enter the date of arrival" error message for "dateOfArrival"
    Then the user should see "Error:Enter the estimated time of arrival" error message for "timeOfArrival"
    When the user clicks the error link for "vesselName" it should link to the vesselName field
    When the user clicks the error link for "dateOfArrival" it should link to the dateOfArrival.day field
    When the user clicks the error link for "timeOfArrival" it should link to the timeOfArrival.hour field

  Scenario: Optional Vessel Page (Import)
    Then the user navigates to the declaration details page
    When the user enters declaration details "123" and "012345B"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects New
    Then the user is on the Import Route Type Page and selects Route 1
    Then the user is on the Import YesNo Priority Page and selects No
    When the user is on the ALVS Page and selects No
    Then the user is on the Import Transport Type Page and selects Air
    Then the user is on the Import-Optional Vessel Page

#    Incomplete fields (time and date must be whole)
    Then the user enters "a-b-c/de&f\1_1+2'" for vessel name
    When the user enters a Date of Arrival for the vessel "" "2" "2021"
    When the user enters a Time of Arrival for the vessel "" "59"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a day" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must include an hour" error message for "timeOfArrival"

    When the user enters a Date of Arrival for the vessel "01" "" "2021"
    When the user enters a Time of Arrival for the vessel "12" ""
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a month" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must include minutes" error message for "timeOfArrival"

    When the user enters a Date of Arrival for the vessel "01" "02" ""
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a year" error message for "dateOfArrival"

#    Invalid - outside bounds
#    Invalid day & hour field
    When the user enters a Date of Arrival for the vessel "32" "2" "2021"
    When the user enters a Time of Arrival for the vessel "24" "50"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Hours must be between 0 and 23" error message for "timeOfArrival"

#    Invalid month & minutes field
    When the user enters a Date of Arrival for the vessel "01" "13" "2021"
    When the user enters a Time of Arrival for the vessel "9" "61"
    Then the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Minutes must be between 00 and 59" error message for "timeOfArrival"

    Then the user enters "ab:" for vessel name
    When the user enters a Date of Arrival for the vessel "ab" "2" "2021"
    When the user enters a Time of Arrival for the vessel "ab" "45"
    And the user clicks Continue
    Then the user should see "Error:Name must only include letters a to z, numbers, spaces, hyphens, ampersands, apostrophes and full stops" error message for "vesselName"
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Hour of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters too many characters for vesselName
    When the user enters a Date of Arrival for the vessel "01" "2x" "2021"
    When the user enters a Time of Arrival for the vessel "10" "!a"
    And the user clicks Continue
    Then the user should see "Error:Name must be 128 characters or fewer" error message for "vesselName"
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Minutes of arrival must only contain numbers" error message for "timeOfArrival"

    When the user enters "Valid vessel name" for vessel name
    When the user enters a Date of Arrival for the vessel "01" "02" "abcd"
    When the user enters a Time of Arrival for the vessel "01" "10"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"

#  Invalid date/time (too far in past or future)
    When the user enters a Date of Arrival for the vessel "01" "12" "2022"
    When the user enters a Time of Arrival for the vessel "01" "15"
    And the user clicks Continue
    Then the user should see the invalid arrival date range error message for "dateOfArrival" field

    When the user enters a Date of Arrival for the vessel "01" "01" "2020"
    When the user enters a Time of Arrival for the vessel "09" "45"
    And the user clicks Continue
    Then the user should see the invalid arrival date range error message for "dateOfArrival" field

    When the user enters a Date of Arrival for the vessel "333" "02" "2021"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"

    When the user enters a Date of Arrival for the vessel "01" "243" "2021"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"

    When the user enters a Date of Arrival for the vessel "01" "02" "20215"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user navigates to the landing page for trader services

#    Export
#    All blank fields
  Scenario: Mandatory (Export) Vessel Page
    Given the user navigates to the temporary start page for trader services and clicks start
    Then the user is on the start page for trader services and selects New
    Then the user is on the declaration details page
    When the user enters declaration details "123" and "A12345B"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects C1601
    Then the user is on the Export Route Type Page and selects Route 2
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects Air
    Then the user is on the Export-Mandatory Vessel Page

    When the user enters "" for vessel name
    When the user enters a Date of Departure for the vessel "" "" ""
    When the user enters a Time of Departure for the vessel "" ""
    When the user clicks Continue
    Then the user should see "Error:Enter the ship, vehicle or airline name" error message for "vesselName"
    Then the user should see "Error:Enter the date of departure" error message for "dateOfDeparture"
    Then the user should see "Error:Enter the estimated time of departure" error message for "timeOfDeparture"
    When the user clicks the error link for "vesselName" it should link to the vesselName field
    When the user clicks the error link for "dateOfDeparture" it should link to the dateOfDeparture.day field
    When the user clicks the error link for "timeOfDeparture" it should link to the timeOfDeparture.hour field

  Scenario: Optional Vessel Page (Export)
    Then the user navigates to the declaration details page
    When the user enters declaration details "123" and "A12345B"
    And the user enters today's date for entryDate
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects New
    Then the user is on the Export Route Type Page and selects Route 1
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects Air
    Then the user is on the Export-Optional Vessel Page

#    Incomplete fields (time and date must be whole)
    Then the user enters "a-b-c/de&f\1_1+2'" for vessel name
    When the user enters a Date of Departure for the vessel "" "2" "2021"
    When the user enters a Time of Departure for the vessel "" "59"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must include a day" error message for "dateOfDeparture"
    Then the user should see "Error:Time of departure must include an hour" error message for "timeOfDeparture"

    When the user enters a Date of Departure for the vessel "01" "" "2021"
    When the user enters a Time of Departure for the vessel "12" ""
    And the user clicks Continue
    Then the user should see "Error:Date of departure must include a month" error message for "dateOfDeparture"
    Then the user should see "Error:Time of departure must include minutes" error message for "timeOfDeparture"

    When the user enters a Date of Departure for the vessel "01" "02" ""
    And the user clicks Continue
    Then the user should see "Error:Date of departure must include a year" error message for "dateOfDeparture"

#    Invalid - outside bounds
#    Invalid day & hour field
    When the user enters a Date of Departure for the vessel "32" "2" "2021"
    When the user enters a Time of Departure for the vessel "24" "50"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"
    Then the user should see "Error:Hours must be between 0 and 23" error message for "timeOfDeparture"

#    Invalid month & minutes field
    When the user enters a Date of Departure for the vessel "01" "13" "2021"
    When the user enters a Time of Departure for the vessel "9" "61"
    Then the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"
    Then the user should see "Error:Minutes must be between 00 and 59" error message for "timeOfDeparture"

    Then the user enters "ab:" for vessel name
    When the user enters a Date of Departure for the vessel "ab" "2" "2021"
    When the user enters a Time of Departure for the vessel "ab" "45"
    And the user clicks Continue
    Then the user should see "Error:Name must only include letters a to z, numbers, spaces, hyphens, ampersands, apostrophes and full stops" error message for "vesselName"
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"
    Then the user should see "Error:Hour of departure must only contain numbers" error message for "timeOfDeparture"

    Then the user enters too many characters for vesselName
    When the user enters a Date of Departure for the vessel "01" "2x" "2021"
    When the user enters a Time of Departure for the vessel "10" "!a"
    And the user clicks Continue
    Then the user should see "Error:Name must be 128 characters or fewer" error message for "vesselName"
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"
    Then the user should see "Error:Minutes of departure must only contain numbers" error message for "timeOfDeparture"

    When the user enters "Valid vessel name" for vessel name
    When the user enters a Date of Departure for the vessel "01" "02" "abcd"
    When the user enters a Time of Departure for the vessel "01" "10"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"

#  Invalid date/time (too far in past or future)
    When the user enters a Date of Departure for the vessel "01" "12" "2022"
    When the user enters a Time of Departure for the vessel "01" "15"
    And the user clicks Continue
    Then the user should see the invalid departure date range error message for "dateOfDeparture" field

    When the user enters a Date of Departure for the vessel "01" "01" "2020"
    When the user enters a Time of Departure for the vessel "09" "45"
    And the user clicks Continue
    Then the user should see the invalid departure date range error message for "dateOfDeparture" field

    When the user enters a Date of Departure for the vessel "333" "02" "2021"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"

    When the user enters a Date of Departure for the vessel "01" "243" "2021"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"

    When the user enters a Date of Departure for the vessel "01" "02" "20215"
    And the user clicks Continue
    Then the user should see "Error:Date of departure must be a real date" error message for "dateOfDeparture"
    Then the user navigates to the landing page for trader services