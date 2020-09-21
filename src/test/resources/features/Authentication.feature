@TraderService
Feature: signing in
  Scenario: reach home page

    Given the user logs in
    Then the user is on the landing page
