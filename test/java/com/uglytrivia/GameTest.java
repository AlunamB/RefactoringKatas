package com.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Random;
import main.java.com.uglytrivia.Game;
import main.java.com.uglytrivia.GameRunner;
import main.java.com.uglytrivia.Player;
import org.junit.Test;

public class GameTest {
  @Test
  public void shouldInitFirstPlayerAsCurrentPlayer() {

    Game aGame = new Game();
    String name = "Manu";
    Player expectedPlayerOne = new Player(name);
    expectedPlayerOne.setCurrentPlayer(true);

    aGame.add(name);

    assertEquals(expectedPlayerOne.toString(), aGame.getCurrentPlayer().toString());
  }

  @Test
  public void shouldInitPlayerTwoAttributes() {

    Game aGame = new Game();
    String name1 = "Manu";
    Player expectedPlayerOne = new Player(name1);
    expectedPlayerOne.setCurrentPlayer(true);

    String name2 = "Bob";
    Player expectedPlayerTwo = new Player(name2);

    aGame.add(name1);
    aGame.add(name2);

    assertEquals(expectedPlayerTwo.toString(), aGame.getNextPlayer().toString());
  }

  @Test
  public void shouldThrowExceptionWithLessThanTwoPlayers() {
    Game aGame = new Game();
    String name1 = "Manu";
    Player playerOne = new Player(name1);
    playerOne.setCurrentPlayer(true);
    aGame.add(name1);

    Exception exception =
        assertThrows(
            InstantiationException.class,
            () -> {
              GameRunner.playGame(new Random(), aGame);
            });

    String expectedMessage = "A Game needs at least two players.";
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
  }
}