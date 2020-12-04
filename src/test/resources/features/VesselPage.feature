@TraderService
Feature: Vessel page validation

#    All blank fields
  Scenario: Mandatory (Export) Vessel Page
    Given the user is on the start page for trader services and selects New
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
    When the user enters a date for the vessel "" "" ""
    When the user enters a time for the vessel "" ""
    When the user clicks Continue
    Then the user should see "Error:Enter the ship, plane or vehicle name" error message for "vesselName"
    Then the user should see "Error:Enter the date of arrival" error message for "dateOfArrival"
    Then the user should see "Error:Enter the estimated time of arrival" error message for "timeOfArrival"
    When the user clicks the error link for "vesselName" it should link to the vesselName field
    When the user clicks the error link for "dateOfArrival" it should link to the dateOfArrival.day field
    When the user clicks the error link for "timeOfArrival" it should link to the timeOfArrival.hour field

#    The below validation is carried out on all pages (ie mandatory/optional, import/export)
  Scenario: Optional Vessel Page (Export)
    Then the user navigates to the declaration details page
    When the user enters declaration details "123" and "A12345B"
    And the user enters a date "10" "10" "2020"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects New
    Then the user is on the Export Route Type Page and selects Route 1
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects Air
    Then the user is on the Export-Optional Vessel Page

#    Incomplete fields (time and date must be whole)
    Then the user enters "a-b-c/de&f\1_1+2'" for vessel name
    Then the user enters a date for the vessel "" "01" "2021"
    Then the user enters a time for the vessel "" "59"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a day" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must include an hour" error message for "timeOfArrival"

    Then the user enters a date for the vessel "01" "" "2021"
    Then the user enters a time for the vessel "1" ""
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a month" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must include minutes" error message for "timeOfArrival"

    Then the user enters a date for the vessel "01" "01" ""
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a year" error message for "dateOfArrival"

#    Invalid - outside bounds
#    Invalid day & hour field
    Then the user enters a date for the vessel "32" "01" "2021"
    Then the user enters a time for the vessel "59" "59"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Hours must be between 0 and 23" error message for "timeOfArrival"

#    Invalid month & minutes field
    Then the user enters a date for the vessel "01" "13" "2021"
    Then the user enters a time for the vessel "9" "61"
    Then the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Minutes must be between 00 and 59" error message for "timeOfArrival"

    Then the user enters "ab:" for vessel name
    Then the user enters a date for the vessel "ab" "12" "2020"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Name must only include letters a to z, numbers, spaces, hyphens, ampersands, apostrophes and full stops" error message for "vesselName"
    Then the user should see "Error:Day of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Hour of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters too many characters for vesselName
    Then the user enters a date for the vessel "01" "ab" "2020"
    Then the user enters a time for the vessel "10" "!1"
    And the user clicks Continue
    Then the user should see "Error:Name must be 128 characters or fewer" error message for "vesselName"
    Then the user should see "Error:Month of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Minutes of arrival must only contain numbers" error message for "timeOfArrival"

#    CONTENT FOR ABOVE TO BE UPDATED

    When the user enters "Valid vessel name" for vessel name
    Then the user enters a date for the vessel "01" "01" "abcd"
    Then the user enters a time for the vessel "01" "10"
    And the user clicks Continue
    Then the user should see "Error:Year of arrival must only contain numbers" error message for "dateOfArrival"

#  Invalid date/time (too far in past or future)
    Then the user enters a date for the vessel "01" "01" "2022"
    Then the user enters a time for the vessel "01" "01"
    And the user clicks Continue
    Then the user should see the invalid date range error message for "dateOfArrival" field

#  Then the user should see "Error:Date of arrival must be between 22 April 2020 and 22 April 2021" error message for "dateOfArrival"
#  Error message: Date of arrival must be between [6 months past from today] or [6 months future of today]

    Then the user enters a date for the vessel "01" "01" "2020"
    Then the user enters a time for the vessel "01" "01"
    And the user clicks Continue
    Then the user should see the invalid date range error message for "dateOfArrival" field

    Then the user enters a date for the vessel "321" "11" "2020"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"

    Then the user enters a date for the vessel "01" "321" "2020"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"

    Then the user enters a date for the vessel "01" "11" "202055"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user navigates to the landing page for trader services
