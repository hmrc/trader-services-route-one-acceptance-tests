@TraderService
Feature: RouteOne Journey
  Scenario: A user wants to complete a RouteOne journey

    Given the user logs in
    Then the user is on the landing page for trader services
    When the user clicks the link to enter the route1 journey
    Then the user is on the consignment number page
    When the user enters the following valid consignment details
    And the user clicks Continue
    Then the user signs out