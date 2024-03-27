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
    if (!aGame.isPlayable()) {
      throw new InstantiationException(
          "The valid amount of players is from 2 up to 6. The minimum amount of coins for winning is 3. The game had "
              + aGame.getAmountOfPlayers()
              + " players and "
              + aGame.getAmountOfCoinsForWinning()
              + " coins for winning.");
    }

    do {
      aGame.playNextRound(rand);
    } while (aGame.noPlayerHasWon());
    System.out.println(aGame.getUsedQuestionSummary());
  }

  private static Game initGame() {
    Game aGame = new Game(6);

    aGame.addAdultPlayer("Chet");
    aGame.addAdultPlayer("Pat");
    aGame.addAdultPlayer("Sue");
    return aGame;
  }
}