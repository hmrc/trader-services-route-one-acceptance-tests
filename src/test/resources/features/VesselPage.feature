@TraderService @ZAP
Feature: Pre-clearance - Declaration details validation

#  Scenario: Optional Vessel Page (Import)
#    Then the user navigates to the declaration details page
#    When the user enters declaration details "123" and "012345B"
#    And the user enters a date "10" "10" "2020"
#    And the user clicks Continue
#    Then the user is on the Import Request Type page and selects Hold
#    Then the user is on the Import YesNo Priority Page and selects No
#    Then the user is on the ALVS Page and selects Yes
#    Then the user is on the Import Transport Type Page and selects Air
#    Then the user is on the Import Vessel Page


#    All blank fields
  Scenario: Mandatory (Export) Vessel Page
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

#    The below validation is carried out on all pages (ie mandatory/optional, import/export)

  Scenario: Optional Vessel Page (Export)
    Then the user navigates to the declaration details page
    When the user enters declaration details "123" and "A12345B"
    And the user enters a date "10" "10" "2020"
    And the user clicks Continue
    Then the user is on the Export Request Type page and selects New
    Then the user is on the Export Route Type Page and selects Route1
    Then the user is on the Export YesNo Priority Page and selects No
    Then the user is on the Export Transport Type Page and selects Air
    Then the user is on the Export Vessel Page

#    Incomplete fields (time and date must be whole)
    Then the user enters a-b-c/de&f\1_1+2' for vessel name
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
    Then the user enters a time for the vessel "12" "15"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must include a year" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must include period" error message for "timeOfArrival"
  # Will be switching to 24hr time...


#    Invalid - outside bounds
#    Invalid day & hour field
    Then the user enters a date for the vessel "32" "01" "2021"
    Then the user enters a time for the vessel "59" "59"
    And the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Hours must be between 1 and 12" error message for "timeOfArrival"

#    Invalid month & minutes field
    Then the user enters a date for the vessel "01" "13" "2021"
    Then the user enters a time for the vessel "9" "61"
    Then the user clicks Continue
    Then the user should see "Error:Date of arrival must be a real date" error message for "dateOfArrival"
    Then the user should see "Error:Minutes must be between 00 and 59" error message for "timeOfArrival"

#     Invalid - name invalid & date/time contains characters other than numbers
#     Content for the Enter vessel name to be updated with specific error, pending confirmation on validation done on vessel name
    Then the user enters ab: for vessel name
    Then the user enters a date for the vessel "ab" "12" "2020"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Enter the vessel name" error message for "vesselName"
    Then the user should see "Error:Day of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters 1234567 for vessel name
    Then the user enters a date for the vessel "01" "ab" "2020"
    Then the user enters a time for the vessel "ab" "01"
    And the user clicks Continue
    Then the user should see "Error:Month of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

    Then the user enters a date for the vessel "01" "01" "abcd"
    Then the user enters a time for the vessel "!1" "01"
    And the user clicks Continue
    Then the user should see "Error:Year of arrival must only contain numbers" error message for "dateOfArrival"
    Then the user should see "Error:Time of arrival must only contain numbers" error message for "timeOfArrival"

#  Invalid date/time (too far in past or future)
    Then the user enters a date for the vessel "01" "01" "2022"
    Then the user enters a time for the vessel "01" "01"
    And the user clicks Continue
#    Then the user should see "Error:Date of arrival must be today or in the next 6 months" error message for ""

#    Then the user enters a date for the vessel "01" "01" "2022"
#    Then the user enters a time for the vessel "01" "01"
#    And the user clicks Continue
#    Then the user should see "Error:Date of arrival must be today or in the next 6 months" error message for "dateOfArrival"
#    Then the user should see "Error:Date of arrival must be today or in the next 6 months" error message for "timeOfArrival"

#  At present no field error, time and date need to be analysed together, what is solution?
# Will need to implement logic for 6months in past to be acceptable


#Test for presence of more than one....
