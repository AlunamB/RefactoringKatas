package com.greedgame;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import main.java.com.greedgame.GreedGame;

public class StepDefinitions {

    private int score;
    private GreedGame greedGame;
    private Exception exception;

    @Given("The dice shows {int}")
    public void theDiceShows(int arg0) {
        greedGame = new GreedGame(arg0);
    }

    @When("I calculate the score")
    public void iCalculateTheScore() {
        try{
            score = greedGame.score();
        }catch (IllegalArgumentException e) {
            this.exception = e;
        }

    }

    @Then("I should get a score of {int}")
    public void iShouldGetAScoreOf(int expectedScore) {
        assertEquals(score, expectedScore);
    }

    @Given("No dice has been rolled")
    public void noDiceHasBeenRolled() {
        greedGame = new GreedGame(new ArrayList<>());
    }

    @Then("I should get an Exception that tells me {string}")
    public void iShouldGetAnExceptionThatTellsMe(String expectedMessage) {
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

  @Given("The dices show:")
  public void theDicesShow(List<Integer> diceRolls) {
    greedGame = new GreedGame(new ArrayList<>(diceRolls));
  }
}