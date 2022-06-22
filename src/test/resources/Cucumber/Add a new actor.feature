Feature: Adding a new actor
  as a user i would like to add a new actor in my table

  Scenario: i successfully added an actor to the table
    Given i have actor info
    When i the users first name equals "john"
    And the last name equals "smith"
    Then the system returns "success"
