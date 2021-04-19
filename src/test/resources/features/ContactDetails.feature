@TraderServiceErrors
Feature: Contact Details

  Scenario Outline: Contact details - validation test
    Given the user navigates to the <journey> Contact details page
    Given the user is on the start page for trader services, selects New and continues
    Then the user will be on the entry details page
    When the user enters entry details "<epu>" and "<entryNo>"
    * the user enters today's date for entryDate
    * the user clicks continue
    Then the user will be on the <journey> Request type page
    When the user is on the Request type page, selects <requestType> and continues
    Then the user will be on the <journey> Route type page
    When the user is on the Route type page, selects <route> and continues
    Then the user will be on the <journey> YN Priority page
    When the user is on the YesNo Priority page, selects Yes and continues
    Then the user will be on the <journey> Priority Goods page
    When the user is on the Priority Goods page, selects <priority> and continues
    Then the user will be on the ALVS page
    When the user is on the ALVS page, selects Yes and continues
    Then the user will be on the <journey> Transport type page
    When the user is on the Transport type page, selects <transport> and continues
    Then the user will be on the Import-Optional Transport details page
    Then the user clicks continue

    Then the user will be on the <journey> Contact details page
    * the user clicks continue
    * the user should see "Error:Enter an email address" error message for "contactEmail"

    When the user enters a name "a"
    * the user enters an email address "abc"
    * the user enters a phone number "xyz"
    * the user clicks continue
    Then the user should see "Error:Full name must be 2 characters or more" error message for "contactName"
    * the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    * the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"
    When the user clicks the error link for "contactName" it should link to the contactName field
    * the user clicks the error link for "contactEmail" it should link to the contactEmail field
    * the user clicks the error link for "contactNumber" it should link to the contactNumber field

    When the user enters too many characters for fullName
    * the user enters too many characters for contactEmail
    * the user enters a phone number "123456789100"
    * the user clicks continue
    Then the user should see "Error:Full name must be 128 characters or fewer" error message for "contactName"
    * the user should see "Error:Email address must be 128 characters or fewer" error message for "contactEmail"
    * the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

    * the user enters an email address "a@a.c"
    * the user enters a phone number "0123456789"
    * the user clicks continue
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    * the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

    When the user enters an email address "a@a.abcde"
    * the user enters a phone number "0123-456789"
    * the user clicks continue
    Then the user should see "Error:Enter an email address in the correct format, like name@example.com" error message for "contactEmail"
    * the user should see "Error:Enter a telephone number in the correct format" error message for "contactNumber"

#    When the user enters an email address "customs_agent@traders.co.uk"
#    When the user enters a phone number "+447123456789"
#    When the user clicks continue
#    Then the user is on the multi-file upload pages for New
#    When the user clicks the button to upload file "1" and selects "<file>"
#    Then the user clicks continue when files have finished uploading
#    Then the user will be on the <journey> CYA page


#  todo  valid numbers - add to other tests to check FORMATTED
#    Then the user clicks the change link for ContactDetails
#    Then the user enters a phone number "00447123456789"
#    When the user clicks continue
#    Then the user will be on the Import CYA page
#
#    Then the user clicks the change link for ContactDetails
#    Then the user enters a phone number "447123456789"
#    When the user clicks continue
#    Then the user will be on the Import CYA page
#
#    Then the user clicks the change link for ContactDetails
#    Then the user enters a phone number "071(234-567)89"
#    When the user clicks continue
#    Then the user will be on the Import CYA page

    Examples:
      | journey | epu       | entryNo        | requestType | route   | priority      | transport |
      | Import  | randomEPU | randomImportEN | New         | Route 1 | Human remains | Air       |



