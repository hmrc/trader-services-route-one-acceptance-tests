#@TraderService @ZAP
#Feature: Pre-clearance - Import Journey
#
#  Scenario: Error validation on declaration page
#
#Given the user is on the consignment number page
#    And the user enters consignment details 1234 and 123456A
#    And the user enters a date 01 09 2020
#    Then the user should see "Please enter a valid EPU number" error message for "epu" on the page
#
