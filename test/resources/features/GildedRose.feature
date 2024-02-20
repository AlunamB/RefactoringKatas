Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking Aged Brie BEFORE SellIn passed
    Given The item as "Aged Brie" with a quality of 5 and 2 days left to sell
    When I update the quality
    Then I should get item as "Aged Brie" and quality 6 and sellIn is 1

  Scenario: Checking Aged Brie SellIn PASSED
    Given The item as "Aged Brie" with a quality of 5 and 0 days left to sell
    When I update the quality
    Then I should get item as "Aged Brie" and quality 7 and sellIn is -1

  Scenario: Checking Sulfuras and SellIn PASSED
    Given The item as "Sulfuras, Hand of Ragnaros" with a quality of 80 and 5 days left to sell
    When I update the quality
    Then I should get item as "Sulfuras, Hand of Ragnaros" and quality 80 and sellIn is 5

  Scenario: Checking Sulfuras BEFORE SellIn passed
    Given The item as "Sulfuras, Hand of Ragnaros" with a quality of 80 and -1 days left to sell
    When I update the quality
    Then I should get item as "Sulfuras, Hand of Ragnaros" and quality 80 and sellIn is -1

  Scenario: Checking Backstage passes more than 10 days BEFORE SellIn passed
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with a quality of 20 and 15 days left to sell
    When I update the quality
    Then I should get item as "Backstage passes to a TAFKAL80ETC concert" and quality 21 and sellIn is 14

  Scenario: Checking Backstage passes more exact 10 days BEFORE SellIn passed
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with a quality of 20 and 10 days left to sell
    When I update the quality
    Then I should get item as "Backstage passes to a TAFKAL80ETC concert" and quality 22 and sellIn is 9

  Scenario: Checking Backstage passes more exact 5 days BEFORE SellIn passed
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with a quality of 20 and 5 days left to sell
    When I update the quality
    Then I should get item as "Backstage passes to a TAFKAL80ETC concert" and quality 23 and sellIn is 4

  Scenario: Checking Backstage passes SellIn PASSED
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with a quality of 20 and 0 days left to sell
    When I update the quality
    Then I should get item as "Backstage passes to a TAFKAL80ETC concert" and quality 0 and sellIn is -1

  Scenario: Checking normal item elixir BEFORE SellIn passed
    Given The item as "Elixir of the Mongoose" with a quality of 7 and 5 days left to sell
    When I update the quality
    Then I should get item as "Elixir of the Mongoose" and quality 6 and sellIn is 4

  Scenario: Checking normal item elixir and SellIn PASSED
    Given The item as "Elixir of the Mongoose" with a quality of 7 and 0 days left to sell
    When I update the quality
    Then I should get item as "Elixir of the Mongoose" and quality 5 and sellIn is -1