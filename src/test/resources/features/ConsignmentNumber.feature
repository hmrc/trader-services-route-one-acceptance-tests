@TraderService @ZAP
Feature: Pre-clearance - Consignment validation

  Scenario: Error validation on declaration page (all blank fields)
    Then the user navigates to the declaration details page
    When the user clicks Continue
    Then the user should see "Error:Enter an EPU number" error message for "epu" on the page
    And the user should see "Error:Enter an entry number" error message for "entryNumber" on the page
    Then the user should see "Error:Enter the entry date" error message for "entryDate" on the page


  Scenario: Error validation on declaration page - EPU
    When the user navigates to the declaration details page
    And the user enters consignment details "1234" and "123456A"
    And the user enters a date "01" "09" "2020"
    Then the user clicks Continue
    Then the user should see "Error:EPU number must be 3 characters" error message for "epu" on the page

    When the user enters consignment details "12" and "123456A"
    Then the user clicks Continue
    Then the user should see "Error:EPU number must be 3 characters" error message for "epu" on the page

    When the user enters consignment details "abc" and "123456A"
    Then the user clicks Continue
    Then the user should see "Error:EPU number must only contain numbers 0 to 9" error message for "epu" on the page

    When the user enters consignment details "701" and "123456A"
    Then the user clicks Continue
    Then the user should see "Error:EPU number must be 700 or less" error message for "epu" on the page


  Scenario: Error validation on declaration page - Entry number
    Given the user navigates to the declaration details page
    And the user enters consignment details "123" and "1"
    And the user enters a date "01" "09" "2020"
    Then the user clicks Continue
    Then the user should see "Error:Entry number must be 7 characters" error message for "entryNumber" on the page

    When the user enters consignment details "123" and "12345678"
    Then the user clicks Continue
    And the user should see "Error:Entry number must be 7 characters" error message for "entryNumber" on the page

    When the user enters consignment details "123" and "abcdefg"
    Then the user clicks Continue
    Then the user should see "Error:Entry number must have letters before and after the number only" error message for "entryNumber" on the page

    When the user enters consignment details "123" and "A!2345B"
    Then the user clicks Continue
    Then the user should see "Error:Entry number must only contain numbers 0 to 9 and letters" error message for "entryNumber" on the page

    When the user enters consignment details "123" and "A123456"
    Then the user clicks Continue
    Then the user should see "Error:Entry number must have a letter at the end" error message for "entryNumber" on the page


  Scenario: Error validation on declaration page - Date (Each one blank in turn)
    When the user navigates to the declaration details page
    And the user enters consignment details "123" and "123456A"
    And the user enters a date "" "09" "2020"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must include a day" error message for "entryDate" on the page
    Then the user enters a date "01" "" "2020"
    And the user clicks Continue
    Then the user should see "Error:Entry date must include a month" error message for "entryDate" on the page
    Then the user enters a date "01" "09" ""
    And the user clicks Continue
    Then the user should see "Error:Entry date must include a year" error message for "entryDate" on the page

  Scenario: Error validation on declaration page - Date (Invalid dates)
    When the user navigates to the declaration details page
    And the user enters consignment details "123" and "123456A"
    And the user enters a date "31" "09" "2020"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate" on the page
    And the user enters a date "01" "13" "2020"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate" on the page
    And the user enters a date "01" "13" "20202"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must be a real date" error message for "entryDate" on the page
    And the user enters a date "01" "09" "2019"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must be within the past 6 months" error message for "entryDate" on the page
    And the user enters a date "01" "09" "2021"
    Then the user clicks Continue
    Then the user should see "Error:Entry date must be today or in the past" error message for "entryDate" on the page