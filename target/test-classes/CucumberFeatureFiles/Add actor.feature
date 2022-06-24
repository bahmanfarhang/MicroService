Feature: Actor controller
  the client should be able to add an actor by
  the actor first name and last name in the actor controller class

  Scenario: add an actor using actor first and last name
    Given I want to add an actor by entering actor first name
    And by entering actor last name
    When I request to add the actor by the actor first and last name
    Then I should now see the added actor

