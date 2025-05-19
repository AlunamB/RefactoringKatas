package com.greedgame;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.Item;
import main.java.com.greedgame.GreedGame;

public class StepDefinitions {

    private int score;
    private GreedGame greedGame;

    @Given("The dice shows {int}")
    public void theDiceShows(int arg0) {
        greedGame = new GreedGame(arg0);
    }

    @When("I calculate the score")
    public void iCalculateTheScore() {
        score = greedGame.score();
    }

    @Then("I should get a score of {int}")
    public void iShouldGetAScoreOf(int expectedScore) {
        assertEquals(score, expectedScore);
    }
}