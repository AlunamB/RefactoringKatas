package main.java.com.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Game {
  public static final int AMOUNT_OF_BOARD_POSITIONS = 12;
  ArrayList<Player> playerList = new ArrayList<Player>();

  LinkedList popQuestions = new LinkedList();
  LinkedList scienceQuestions = new LinkedList();
  LinkedList sportsQuestions = new LinkedList();
  LinkedList rockQuestions = new LinkedList();
  boolean isGettingOutOfPenaltyBox;

  public Game() {
    for (int i = 0; i < 50; i++) {
      popQuestions.addLast("Pop Question " + i);
      scienceQuestions.addLast(("Science Question " + i));
      sportsQuestions.addLast(("Sports Question " + i));
      rockQuestions.addLast("Rock Question " + i);
    }
  }

  public boolean isPlayable() {
    return (getAmountOfPlayers() >= 2 && getAmountOfPlayers() <= 6);
  }

  public void add(String playerName) {
    playerList.add(new Player(playerName));
    if (playerList.size() == 1) {
      playerList.get(0).setCurrentPlayer(true);
    }

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + playerList.size());
  }

  public int getAmountOfPlayers() {
    return playerList.size();
  }

  public boolean playNextRound(Random rand) {
    roll(rand.nextInt(5) + 1);
    return getPlayerAnswer(rand.nextInt(9));
  }

  public boolean getPlayerAnswer(int randomNumber) {
    if (randomNumber == 7) {
      return playerAnsweredWrong();
    } else {
      return playerAnsweredCorrect();
    }
  }

  public void roll(int roll) {
    Player currentPlayer = getCurrentPlayer();
    System.out.println(currentPlayer.getName() + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (currentPlayer.isInPenaltyBox()) {
      if (isOddNumber(roll)) {
        isGettingOutOfPenaltyBox = true;
        System.out.println(currentPlayer.getName() + " is getting out of the penalty box");

        currentPlayer.movePlayer(roll);
        askQuestion(currentPlayer);
      } else {
        System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }

    } else {
      currentPlayer.movePlayer(roll);
      askQuestion(currentPlayer);
    }
  }

  private void askQuestion(Player player) {
    QuestionCategory category = currentCategory(player);
    System.out.println("The category is " + category.name);

    if (QuestionCategory.POP.equals(category)) System.out.println(popQuestions.removeFirst());
    if (QuestionCategory.SCIENCE.equals(category))
      System.out.println(scienceQuestions.removeFirst());
    if (QuestionCategory.SPORTS.equals(category)) System.out.println(sportsQuestions.removeFirst());
    if (QuestionCategory.ROCK.equals(category)) System.out.println(rockQuestions.removeFirst());
  }

  private QuestionCategory currentCategory(Player player) {
    QuestionCategory category = null;
    for (QuestionCategory q : QuestionCategory.values()) {
      if (q.getPositions().contains(player.getPositionOnBoard())) {
        category = q;
        break;
      }
    }
    return category;
  }

  private boolean playerAnsweredCorrect() {
    if (getCurrentPlayer().isInPenaltyBox()) {
      if (isGettingOutOfPenaltyBox) {
        getCurrentPlayer().addCoin();

        boolean winner = getCurrentPlayer().isWinner();
        switchToNextPlayer();
        return winner;
      } else {
        switchToNextPlayer();
        return true;
      }

    } else {

      getCurrentPlayer().addCoin();

      boolean winner = getCurrentPlayer().isWinner();
      switchToNextPlayer();
      return winner;
    }
  }

  private boolean playerAnsweredWrong() {
    System.out.println("Question was incorrectly answered");
    System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
    getCurrentPlayer().setInPenaltyBox(true);

    switchToNextPlayer();
    return true;
  }

  private void switchToNextPlayer() {
    Player currentP = getCurrentPlayer();
    Player nextPlayer = getNextPlayer();
    currentP.setCurrentPlayer(false);
    nextPlayer.setCurrentPlayer(true);
  }

  public Player getCurrentPlayer() {
    Player currentPlayer = null;
    for (Player p : playerList) {
      if (p.isCurrentPlayer()) {
        currentPlayer = p;
        break;
      }
    }
    return currentPlayer;
  }

  public Player getNextPlayer() {
    Player currentPlayer = getCurrentPlayer();
    int indexOfCurrPlayer = playerList.indexOf(currentPlayer);
    if (indexOfCurrPlayer < playerList.size() - 1) {
      return playerList.get(indexOfCurrPlayer + 1);
    } else {
      return playerList.get(0);
    }
  }

  private static boolean isOddNumber(int roll) {
    return roll % 2 != 0;
  }
}