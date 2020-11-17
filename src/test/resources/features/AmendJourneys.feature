@TraderService
Feature: Amend Journeys

  Scenario: Amend case (error validation)
    Given the user enters the amend journey and is on the case ref number page
    When the user enters no characters for case reference number
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters tooFew characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters tooMany characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects noOption
    Then the user should see "Error:Select how you want to send us more information" error message for "typeOfAmendment"


  Scenario: Amend: A user wants to amend their case details (write response + upload)
    Given the user enters the amend journey and is on the case ref number page
    When the user enters valid characters for case reference number
    When the user is on the how to respond page and selects write&Upload
#    Then the user is on the write response page
#    and they write a response click continue

#    Then the user is on the <any> upload page??
#Then the user is on the final confirmation page - rework??


Scenario: A user wants to amend their case details (upload only)
    Given the user enters the amend journey and is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects uploadOnly
#    Then the user is on the <any> upload page??
#Then the user is on the final confirmation page - rework??

  Scenario: A user wants to amend their case details (write response only)
    Given the user enters the amend journey and is on the case ref number page
    When the user enters valid characters for case reference number
    Then the user is on the how to respond page and selects writeOnly
#    Then the user is on the write response page
