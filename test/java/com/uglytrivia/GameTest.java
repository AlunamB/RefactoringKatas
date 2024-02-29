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

    Exception exception1 =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String name1 = "Manu";
    Player playerOne = new Player(name1);
    playerOne.setCurrentPlayer(true);
    aGame.add(name1);

    Exception exception2 =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String expectedMessage1 =
        "The valid amount of players is from 2 up to 6. The game had 0 players.";
    String expectedMessage2 =
        "The valid amount of players is from 2 up to 6. The game had 1 players.";
    assertEquals(expectedMessage1, exception1.getMessage());
    assertEquals(expectedMessage2, exception2.getMessage());
  }

  @Test
  public void shouldThrowExceptionWithMoreThanSixPlayers() {
    Game aGame = new Game();

    aGame.add("Manu1");
    aGame.add("Manu2");
    aGame.add("Manu3");
    aGame.add("Manu4");
    aGame.add("Manu5");
    aGame.add("Manu6");
    aGame.add("Manu7");

    Exception exception =
        assertThrows(InstantiationException.class, () -> GameRunner.playGame(new Random(), aGame));

    String expectedMessage =
        "The valid amount of players is from 2 up to 6. The game had 7 players.";
    assertEquals(expectedMessage, exception.getMessage());
  }
}