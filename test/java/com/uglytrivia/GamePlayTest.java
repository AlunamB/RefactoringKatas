package com.uglytrivia;

import static org.junit.Assert.*;

import java.util.Random;
import main.java.com.uglytrivia.Game;
import main.java.com.uglytrivia.GameRunner;
import main.java.com.uglytrivia.Player;
import org.junit.Test;

public class GamePlayTest {

  @Test
  public void shouldGoToPenaltyBoxAfterWrongAnswer() {
    Game aGame = new Game();

    String name1 = "Manu";
    Player playerOne = new Player(name1);
    playerOne.setCurrentPlayer(true);

    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player playerWithWrongAnswer = aGame.getCurrentPlayer();
    assertEquals(
        "Player one is currentPlayer and not in penalty box",
        playerOne.toString(),
        playerWithWrongAnswer.toString());
    aGame.playerAnswersQuestion(7);
    assertTrue(playerWithWrongAnswer.isInPenaltyBox());
  }

  @Test
  public void shouldSwitchPlayerAfterWrongAnswer() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    aGame.playerAnswersQuestion(7);
    assertEquals(name2, aGame.getCurrentPlayer().getName());
  }

  @Test
  public void shouldSwitchPlayerAfterCorrectAnswer() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    aGame.playerAnswersQuestion(1);
    assertEquals(name2, aGame.getCurrentPlayer().getName());
  }

  @Test
  public void shouldAddCoinAfterCorrectAnswerAndWasNotInPenaltyBox() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player player = aGame.getCurrentPlayer();

    assertEquals(0, player.getAmountOfCoins());
    aGame.playerAnswersQuestion(1);
    assertEquals(1, player.getAmountOfCoins());
  }

  @Test
  public void shouldNotAddCoinWhenInPenaltyBoxAndNotGettingOut() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player player = aGame.getCurrentPlayer();
    player.setInPenaltyBox(true);
    player.setGettingOutOfPenaltyBox(false);

    assertEquals(0, player.getAmountOfCoins());
    aGame.playerAnswersQuestion(1);
    assertEquals(0, player.getAmountOfCoins());
  }

  @Test
  public void shouldAddCoinWhenInPenaltyBoxAndGettingOut() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player player = aGame.getCurrentPlayer();
    player.setInPenaltyBox(true);
    player.setGettingOutOfPenaltyBox(true);

    assertEquals(0, player.getAmountOfCoins());
    aGame.playerAnswersQuestion(1);
    assertEquals(1, player.getAmountOfCoins());
  }

  @Test
  public void shouldEndGameWhenPlayerWins() throws InstantiationException {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);
    Random randomizer = new Random(123455);

    GameRunner.playGame(randomizer, aGame);
    assertFalse(aGame.noPlayerHasWon());
  }

  @Test
  public void shouldGetUsedQuestionCardSummaryAfterAWinnerWasFound() throws InstantiationException {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);
    Random randomizer = new Random(123455);

    GameRunner.playGame(randomizer, aGame);

    String expectedSummaryString =
        "This is the summary of the used question cards:Pop:4 Rock:1 Science:4 Sports:2 ";

    assertEquals(expectedSummaryString, aGame.getUsedQuestionSummary());
  }

  @Test
  public void shouldFindWinnerWhenPlayerHasMaxCoins() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player player = aGame.getCurrentPlayer();
    player.setAmountOfCoins(Player.MAX_AMOUNT_OF_COINS);
    assertFalse(aGame.noPlayerHasWon());
  }
  @Test
  public void shouldNotFindWinnerWhenPlayerHasLessThanMaxCoins() {
    Game aGame = new Game();

    String name1 = "Manu";
    String name2 = "Pat";

    aGame.add(name1);
    aGame.add(name2);

    Player player1 = aGame.getCurrentPlayer();
    player1.setAmountOfCoins(0);

    Player player2 = aGame.getNextPlayer();
    player2.setAmountOfCoins(5);

    assertTrue(aGame.noPlayerHasWon());
  }




}