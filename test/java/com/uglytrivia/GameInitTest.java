package com.uglytrivia;

import static org.junit.Assert.*;

import java.util.Random;
import main.java.com.uglytrivia.AdultPlayer;
import main.java.com.uglytrivia.Game;
import main.java.com.uglytrivia.GameRunner;
import main.java.com.uglytrivia.Player;
import org.junit.Test;

public class GameInitTest {
  @Test
  public void shouldInitFirstPlayerAsCurrentPlayer() {

    Game aGame = new Game(6);
    String name = "Manu";
    AdultPlayer expectedPlayerOne = new AdultPlayer(name);
    expectedPlayerOne.setCurrentPlayer(true);

    aGame.addAdultPlayer(name);

    assertEquals(expectedPlayerOne.toString(), aGame.getCurrentPlayer().toString());
  }

  @Test
  public void shouldInitPlayerTwoAttributes() {

    Game aGame = new Game(6);
    String name1 = "Manu";
    Player expectedPlayerOne = new AdultPlayer(name1);
    expectedPlayerOne.setCurrentPlayer(true);

    String name2 = "Bob";
    Player expectedPlayerTwo = new AdultPlayer(name2);

    aGame.addAdultPlayer(name1);
    aGame.addAdultPlayer(name2);

    assertEquals(expectedPlayerTwo.toString(), aGame.getNextPlayer().toString());
  }

  @Test
  public void shouldThrowExceptionWithLessThanTwoPlayers() {
    Game aGame = new Game(6);

    Exception exception1 =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String name1 = "Manu";
    Player playerOne = new AdultPlayer(name1);
    playerOne.setCurrentPlayer(true);
    aGame.addAdultPlayer(name1);

    Exception exception2 =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String expectedMessage1 =
        "The valid amount of players is from 2 up to 6. The minimum amount of coins for winning is 3. The game had 0 players and 6 coins for winning.";
    String expectedMessage2 =
        "The valid amount of players is from 2 up to 6. The minimum amount of coins for winning is 3. The game had 1 players and 6 coins for winning.";
    assertEquals(expectedMessage1, exception1.getMessage());
    assertEquals(expectedMessage2, exception2.getMessage());
  }

  @Test
  public void shouldThrowExceptionWithMoreThanSixPlayers() {
    Game aGame = new Game(6);

    aGame.addAdultPlayer("Manu1");
    aGame.addAdultPlayer("Manu2");
    aGame.addAdultPlayer("Manu3");
    aGame.addAdultPlayer("Manu4");
    aGame.addAdultPlayer("Manu5");
    aGame.addAdultPlayer("Manu6");
    aGame.addAdultPlayer("Manu7");

    Exception exception =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String expectedMessage =
        "The valid amount of players is from 2 up to 6. The minimum amount of coins for winning is 3. The game had 7 players and 6 coins for winning.";
    assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  public void shouldInitGameWithMinimumAmountOfCoinsForWinningAndMinimumAmountOfPlayers() {
    Game aGame = new Game(3);
    aGame.addAdultPlayer("Manu1");
    aGame.addAdultPlayer("Manu2");

    assertTrue(aGame.isPlayable());
  }

  @Test
  public void shouldThrowExceptionWhenAmountOfCoinsForWinningIsUnderMinimum() {
    Game aGame = new Game(2);

    aGame.addAdultPlayer("Manu1");
    aGame.addAdultPlayer("Manu2");

    Exception exception =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String expectedMessage =
        "The valid amount of players is from 2 up to 6. The minimum amount of coins for winning is 3. The game had 2 players and 2 coins for winning.";
    assertEquals(expectedMessage, exception.getMessage());
  }
}