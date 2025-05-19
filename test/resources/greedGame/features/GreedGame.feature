Feature: Greed game quality
  I want to know if the score is calculated correctly

  Scenario: Checking that score is returned
    Given The dice shows 2
    When I calculate the score
    Then I should get a score of 0

  Scenario: Checking that a dice is rolled
    Given No dice has been rolled
    When I calculate the score
    Then I should get an Exception that tells me "No dice has been rolled"
    And I should get a score of 0

  Scenario: Checking that multiple dices can be rolled
    Given The dices show:
      | 2 |
      | 2 |
    When I calculate the score
    Then I should get a score of 0


