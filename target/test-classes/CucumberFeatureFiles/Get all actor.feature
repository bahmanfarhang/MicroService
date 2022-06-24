Feature: Actor controller

  Scenario: All the actors should be displayed when the all actors function is used
    Given the all actors end point
    When the client calls all actors end point
    Then the client gets valid response

#  Scenario: Update an actor by actor first name and last name
#    Given I want to update an actor on the localhost using postman
#    When I enter actor first name and last name
#    Then I should see the updated actor with new first name and new last name
