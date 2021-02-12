@TraderServiceErrors
Feature: Contact Details

  Scenario Outline: Contact details - validation test
    Given the user is on the start page for trader services and selects New
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
    Then the user is on the Import-Optional Vessel Page
    Then the user clicks Continue
    When the user is on the Import Contact Details Page
    Then the user clicks Continue
    Then the user should see "Error:Enter an email address" error message for "contactEmail"

    Then the user enters a name "a"
    Then the user enters an email address "abc"
    Then the user enters a phone number "xyz"
    Then the user clicks Continue
    Then the user should see "Error:Full name must be 2 characters or more" error message for "contactName"
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    Then the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"
    When the user clicks the error link for "contactName" it should link to the contactName field
    When the user clicks the error link for "contactEmail" it should link to the contactEmail field
    When the user clicks the error link for "contactNumber" it should link to the contactNumber field

    When the user enters too many characters for fullName
    Then the user enters too many characters for contactEmail
    Then the user enters a phone number "123456789100"
    Then the user clicks Continue
    Then the user should see "Error:Full name must be 128 characters or fewer" error message for "contactName"
    Then the user should see "Error:Email address must be 128 characters or fewer" error message for "contactEmail"
    Then the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

    Then the user enters a name "invalid test name!"
    Then the user enters an email address "a@a.c"
    Then the user enters a phone number "0123456789"
    Then the user clicks Continue
    Then the user should see "Error:Full name must only include letters a to z, numbers, spaces, hyphens, ampersands, apostrophes and full stops" error message for "contactName"
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    Then the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

    Then the user enters a name "!@£$%^&*()"
    Then the user enters an email address "a@a.abcde"
    Then the user enters a phone number "0123-456789"
    Then the user clicks Continue
    Then the user should see "Error:Full name must only include letters a to z, numbers, spaces, hyphens, ampersands, apostrophes and full stops" error message for "contactName"
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    Then the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

    When the user enters a name "a-b-c/de&f\1_1+2'"
    When the user enters an email address "<email>"
    When the user enters a phone number "+447123456789"
    When the user clicks Continue
    Then the user is on the multi-file upload pages for a/an New journey
    When the user clicks the button to upload the first file and selects the "pptx" file
    Then the user clicks only clicks Continue when it's clickable
    Then the user is on the New CYA page
    
    Then the user clicks the change link for ContactDetails
    When the user enters a name "Abc O'Test-Smith"
    Then the user enters a phone number "00447123456789"
    When the user clicks Continue

    Then the user clicks the change link for ContactDetails
    When the user enters a name "Abc’def"
    Then the user enters a phone number "447123456789"
    When the user clicks Continue

    Then the user clicks the change link for ContactDetails
    Then the user enters a phone number "071(234-567)89"
    When the user clicks Continue
    Then the user is on the New CYA page

    Examples:
      | epu | entryNo | day | month | year |requestType  | route   | priority      | transport | email   | phone       |
      | 123 | 123456A | 01  | 10    | 2020 |Cancellation | Route 6 | Human remains | Air       | a@a.com | 07123 456 789 |


