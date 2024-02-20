Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking foo
    Given The item as "bar" with a quality of 5 and 2 days left to sell
    When I update the quality
    Then I should get item as "foo"