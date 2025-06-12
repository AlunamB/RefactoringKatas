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

  Scenario: Checking that an Exception is thrown when more than 6 dices are thrown
    Given The dices show:
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
      | 6 |
      | 7 |
    When I calculate the score
    Then I should get an Exception that tells me "You rolled 7 dices. The maximum amount of dices is 6."
    And I should get a score of 0

  Scenario: Checking the score for a single 1
    Given The dice shows 1
    When I calculate the score
    Then I should get a score of 100

  Scenario: Checking the score for a single 5
    Given The dice shows 5
    When I calculate the score
    Then I should get a score of 50

  Scenario: Checking the score for a triple 1
    Given The dices show:
      | 1 |
      | 1 |
      | 1 |
    When I calculate the score
    Then I should get a score of 1000

  Scenario: Checking the score for a triple 2
    Given The dices show:
      | 2 |
      | 2 |
      | 2 |
    When I calculate the score
    Then I should get a score of 200

  Scenario: Checking the score for a triple 3
    Given The dices show:
      | 3 |
      | 3 |
      | 3 |
    When I calculate the score
    Then I should get a score of 300

  Scenario: Checking the score for a triple 4
    Given The dices show:
      | 4 |
      | 4 |
      | 4 |
    When I calculate the score
    Then I should get a score of 400

  Scenario: Checking the score for a triple 5
    Given The dices show:
      | 5 |
      | 5 |
      | 5 |
    When I calculate the score
    Then I should get a score of 500

  Scenario: Checking the score for a triple 6
    Given The dices show:
      | 6 |
      | 6 |
      | 6 |
    When I calculate the score
    Then I should get a score of 600

  Scenario: Checking the score for a quadruple 1
    Given The dices show:
      | 1 |
      | 1 |
      | 1 |
      | 1 |
    When I calculate the score
    Then I should get a score of 2000

  Scenario: Checking the score for a quadruple 2
    Given The dices show:
      | 2 |
      | 2 |
      | 2 |
      | 2 |
    When I calculate the score
    Then I should get a score of 400

  Scenario: Checking the score for a quadruple 3
    Given The dices show:
      | 3 |
      | 3 |
      | 3 |
      | 3 |
    When I calculate the score
    Then I should get a score of 600

  Scenario: Checking the score for a quadruple 4
    Given The dices show:
      | 4 |
      | 4 |
      | 4 |
      | 4 |
    When I calculate the score
    Then I should get a score of 800

  Scenario: Checking the score for a quadruple 5
    Given The dices show:
      | 5 |
      | 5 |
      | 5 |
      | 5 |
    When I calculate the score
    Then I should get a score of 1000

  Scenario: Checking the score for a quadruple 6
    Given The dices show:
      | 6 |
      | 6 |
      | 6 |
      | 6 |
    When I calculate the score
    Then I should get a score of 1200

  Scenario: Checking the score for a quintuple 1
    Given The dices show:
      | 1 |
      | 1 |
      | 1 |
      | 1 |
      | 1 |
    When I calculate the score
    Then I should get a score of 4000

  Scenario: Checking the score for a quintuple 2
    Given The dices show:
      | 2 |
      | 2 |
      | 2 |
      | 2 |
      | 2 |
    When I calculate the score
    Then I should get a score of 800

  Scenario: Checking the score for a quintuple 3
    Given The dices show:
      | 3 |
      | 3 |
      | 3 |
      | 3 |
      | 3 |
    When I calculate the score
    Then I should get a score of 1200

  Scenario: Checking the score for a quintuple 4
    Given The dices show:
      | 4 |
      | 4 |
      | 4 |
      | 4 |
      | 4 |
    When I calculate the score
    Then I should get a score of 1600

  Scenario: Checking the score for a quintuple 5
    Given The dices show:
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
    When I calculate the score
    Then I should get a score of 2000

  Scenario: Checking the score for a quintuple 6
    Given The dices show:
      | 6 |
      | 6 |
      | 6 |
      | 6 |
      | 6 |
    When I calculate the score
    Then I should get a score of 2400
