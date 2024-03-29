package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.Item;

public class StepDefinitions {

  private final Item[] items = new Item[1];
  private GildedRose app;

  @Given("The item as {string} with a quality of {int} and {int} days left to sell")
  public void theItemAsWithAQualityOfAndDaysLeftToSell(
      String name, Integer quality, Integer sellIn) {
    items[0] = new Item(name, sellIn, quality);
    app = new GildedRose(items);
  }

  @When("I update the quality")
  public void iUpdateTheQuality() {
    app.updateItem();
  }

  @Then("I should get item as {string} and quality {int} and sellIn is {int}")
  public void iShouldGetItemAsAndQualityAndSellInIs(String name, Integer expectedQuality, Integer expectedSellIn) {
    assertEquals(name, app.items[0].name);
    assertEquals(expectedQuality.intValue(), app.items[0].quality);
    assertEquals(expectedSellIn.intValue(), app.items[0].sellIn);
  }
}