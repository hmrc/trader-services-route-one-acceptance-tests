@TraderService @ZAP
Feature: Pre-clearance - Declaration details validation

  Scenario: Error validation on declaration page (all blank fields)
    Then the user navigates to the declaration details page
    When the user enters declaration details "123" and "A12345B"
    And the user enters a date "10" "10" "2020"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects C1601
    Then the user is on the Export Route Type Page and selects Route2
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects Air
    Then the user is on the Export-Mandatory Vessel Page

    When the user clicks Continue
    Then the user should see "Error:Enter the vessel name" error message for "vesselName"
    Then the user should see "Error:Enter the date of arrival" error message for "dateOfArrival"
    Then the user should see "Error:Enter the time of arrival" error message for "timeOfArrival"
    
    Then the user enters ab: for vessel name
    Then the user enters a date for the vessel "32" "01" "2021"
    Then the user enters a time for the vessel "13" "00"
    And the user clicks Continue
    Then the user should see "Error:Enter the vessel name" error message for "vesselName"
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"


    Then the user enters abc for vessel name
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
    Then the user enters a time for the vessel "12" "60"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a year" error message for "dateOfArrival"
    Then the user should see "Error:Minutes must be between 00 and 59" error message for "timeOfArrival"

    Then the user enters a date for the vessel "ab" "12" "2020"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Day of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters a date for the vessel "01" "ab" "2020"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Month of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters a date for the vessel "01" "01" "abcd"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Year of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

#Test for presence of more than one....

