@TraderService
Feature: Start Journey
  Scenario: A user wants to start a RouteOne journey

    Given the user logs in
    Then the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the consignment number page