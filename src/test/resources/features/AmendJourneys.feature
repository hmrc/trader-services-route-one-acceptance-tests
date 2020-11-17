@TraderService
Feature: Amend Journeys

  Scenario: Amend: A user wants to amend their case details

    Given the user enters the amend journey and is on the case ref number page
    When the user enters no characters for case reference number
    Then the user should see "Error:Enter the case reference number" error message for "caseReferenceNumber"

    When the user enters tooFew characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters tooMany characters for case reference number
    Then the user should see "Error:Case reference number must be 22 characters" error message for "caseReferenceNumber"

    When the user enters valid characters for case reference number
    Then the user is on the how to send page


