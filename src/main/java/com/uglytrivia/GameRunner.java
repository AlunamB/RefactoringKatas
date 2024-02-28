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
    boolean notAWinner;
    do {
      if (!aGame.isPlayable()) {
        throw new InstantiationException("A Game needs at least two players.");
      }
      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }

    } while (notAWinner);
  }

  private static Game initGame() {
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");
    return aGame;
  }
}