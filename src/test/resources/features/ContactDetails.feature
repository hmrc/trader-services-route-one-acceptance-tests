@TraderService
Feature: Contact Details

  Scenario Outline: Contact details - validation test
    Given the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the declaration details page
    When the user enters declaration details "<epu>" and "<entryNo>"
    And the user enters a date "<day>" "<month>" "<year>"
    And the user clicks Continue
    Then the user is on the Import Request Type page and selects <requestType>
    Then the user is on the Import Route Type Page and selects <route>
    Then the user is on the Import YesNo Priority Page and selects Yes
    When the user is on the Import Priority Options Page and selects <priority>
    Then the user is on the ALVS Page and selects Yes
    Then the user is on the Import Transport Type Page and selects <transport>
    Then the user is on the Import Vessel Page
    Then the user clicks Continue
    When the user is on the Import Contact Details Page
#    Then the user clicks Continue
#    Then the user should see "Error:Enter your full name" error message for "name"
#    Then the user should see "Error:Enter an email address" error message for "email"


#    Then the user enters a name "INVALID_NAME?!()_"
    Then the user enters an email address "abc"
    Then the user enters a phone number "xyz"
    Then the user clicks Continue
##    Then the user should see "Error:Enter your full name" error message for "name"
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    Then the user should see "Error:Enter a valid phone number" error message for "contactNumber"


    Then the user enters an email address "abctest.com"
    Then the user enters a phone number "123456789100"
    Then the user clicks Continue
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    Then the user should see "Error:Enter a valid phone number" error message for "contactNumber"

#    email address may need to contain more validation? currently accepts abc@test
#    will also need to be mandatory
#    Phone number must contain numbers only - needs to be 11 digits?

    Then the user enters an email address "abc@test.com"
    Then the user enters a phone number "123456789"
    Then the user clicks Continue
    Then the user should see "Error:Enter a valid phone number" error message for "contactNumber"


    Examples:
      | epu | entryNo | day | month | year |requestType | route  | priority     | transport |
      | 123 | 123456A | 01  | 10    | 2020 |Cancel      | Route6 | HumanRemains | Air       |