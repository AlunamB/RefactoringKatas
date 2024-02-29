package main.java.com.uglytrivia;

import java.util.Random;

public class GameRunner {

  public static void main(String[] args) {
    Random rand = new Random();
    try {
      playGame(rand);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    }
  }

  public static void playGame(Random rand) throws InstantiationException {
    Game aGame = initGame();
    playGame(rand, aGame);
  }

  public static void playGame(Random rand, Game aGame) throws InstantiationException {
    do {
      if (!aGame.isPlayable()) {
        throw new InstantiationException(
            "The valid amount of players is from 2 up to 6. The game had "
                + aGame.getAmountOfPlayers()
                + " players.");
      }
      aGame.playNextRound(rand);

    } while (aGame.noPlayerHasWon());
  }

  private static Game initGame() {
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");
    return aGame;
  }
}