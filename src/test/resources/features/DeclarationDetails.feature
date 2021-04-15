@TraderServiceErrors
Feature: Entry details validation

  Scenario: Error validation on entry page (all blank fields)
    Given the user is on the start page for trader services and selects New
    Then the user is on the entry details page
    Then the user enters entry details "" and ""
    And the user enters a date "" "" ""
    When the user clicks continue
    Then the user should see "Error:Enter an EPU number" error message for "epu"
    And the user should see "Error:Enter an entry number" error message for "entryNumber"
    And the user should see "Error:Enter the entry date" error message for "entryDate"
    When the user clicks the error link for "epu" it should link to the epu field
    When the user clicks the error link for "entryNumber" it should link to the entryNumber field
    When the user clicks the error link for "entryDate" it should link to the entryDate.day field

  Scenario: Error validation on entry page - EPU
    Given the user navigates to the entry details page

    When the user enters entry details "12" and "123456A"
    And the user clicks continue
    Then the user should see "Error:EPU number must be 3 characters" error message for "epu"

    When the user enters entry details "1234" and "123456A"
    And the user clicks continue
    Then the user should see "Error:EPU number must be 3 characters" error message for "epu"

    When the user enters entry details "abc" and "123456A"
    And the user clicks continue
    Then the user should see "Error:EPU number must only contain numbers" error message for "epu"

    When the user enters entry details "670" and "123456A"
    And the user clicks continue
    Then the user should see "Error:EPU number must be between 001 and 669" error message for "epu"

    When the user enters entry details "000" and "123456A"
    And the user clicks continue
    Then the user should see "Error:EPU number must be between 001 and 669" error message for "epu"


  Scenario: Error validation on entry page - Entry number
    Given the user navigates to the entry details page

    When the user enters entry details "randomEPU" and "1"
    And the user clicks continue
    Then the user should see "Error:Entry number must be 7 characters" error message for "entryNumber"

    When the user enters entry details "randomEPU" and "1234567N"
    And the user clicks continue
    Then the user should see "Error:Entry number must be 7 characters" error message for "entryNumber"

    When the user enters entry details "randomEPU" and "abcdefg"
    And the user clicks continue
    Then the user should see "Error:Entry number must have letters before and after the number only" error message for "entryNumber"

    When the user enters entry details "randomEPU" and "A!2345B"
    And the user clicks continue
    Then the user should see "Error:Entry number must only contain numbers and letters" error message for "entryNumber"

    When the user enters entry details "randomEPU" and "A123456"
    And the user clicks continue
    Then the user should see "Error:Entry number must have a letter at the end" error message for "entryNumber"


  Scenario: Error validation on entry page - Date (Each one blank in turn)
    Given the user navigates to the entry details page

    When the user enters entry details "randomEPU" and "123456A"
    Then the user enters a date "" "01" "2021"
    And the user clicks continue
    Then the user should see "Error:Entry date must include a day" error message for "entryDate"

    When the user enters a date "01" "" "2021"
    And the user clicks continue
    Then the user should see "Error:Entry date must include a month" error message for "entryDate"

    When the user enters a date "01" "01" ""
    And the user clicks continue
    Then the user should see "Error:Entry date must include a year" error message for "entryDate"

  Scenario: Error validation on entry page - Date (Invalid dates)
    Given the user navigates to the entry details page

    When the user enters entry details "randomEPU" and "randomImportEN"
    Then the user enters a date "31" "09" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "13" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "01" "202"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters an invalid past date for entryDate
    And the user clicks continue
    Then the user should see "Error:Entry date must be within the past 6 months" error message for "entryDate"

    When the user enters an invalid future date for entryDate
    And the user clicks continue
    Then the user should see "Error:Entry date must be today or in the past" error message for "entryDate"

    When the user enters a date "dd" "09" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "mm" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "10" "yyyy"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    Then the user enters a date "132" "09" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "123" "2020"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

    When the user enters a date "01" "13" "20202"
    And the user clicks continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate"

