@TraderService
Feature: Signing In
  Scenario: A user wants to sign in and reach the trader services landing page

    Given the user logs in
    Then the user is on the landing page for trader services
