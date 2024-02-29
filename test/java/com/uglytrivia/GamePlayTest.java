package com.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import main.java.com.uglytrivia.Game;
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
    Player playerTwo = new Player(name2);

    aGame.add(name1);
    aGame.add(name2);

    Player playerWithWrongAnswer = aGame.getCurrentPlayer();
    assertEquals(
        "Player one is currentPlayer and not in penalty box",
        playerOne.toString(),
        playerWithWrongAnswer.toString());
    aGame.getPlayerAnswer(7);
    assertTrue(playerWithWrongAnswer.isInPenaltyBox());
  }

  @Test
  public void shouldSwitchPlayerAfterWrongAnswer() {
    Game aGame = new Game();

    String name1 = "Manu";
    Player playerOne = new Player(name1);
    playerOne.setCurrentPlayer(true);

    String name2 = "Pat";
    Player playerTwo = new Player(name2);

    aGame.add(name1);
    aGame.add(name2);

    aGame.getPlayerAnswer(7);
    assertEquals(name2, aGame.getCurrentPlayer().getName());
  }
}