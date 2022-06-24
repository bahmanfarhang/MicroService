Feature: Actor controller
  the client should be able to delete a actor by
  the actor id in the actor controller class

  Scenario: delete a actor using actor id
    Given I want to delete an actor by entering the actor id
    When I request to delete an actor by the actor id
    Then I should no longer see the deleted actor

