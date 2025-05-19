Feature: Greed game quality
  I want to know if the score is calculated correctly

  Scenario: Checking that score is returned
    Given The dice shows 2
    When I calculate the score
    Then I should get a score of 0