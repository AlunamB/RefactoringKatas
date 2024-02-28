package main.java.com.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

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
    return (howManyplayerList() >= 2);
  }

  public boolean add(String playerName) {
    playerList.add(new Player(playerName));
    if (playerList.size() == 1) {
      playerList.get(0).setCurrentPlayer(true);
    }

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + playerList.size());
    return true;
  }

  public int howManyplayerList() {
    return playerList.size();
  }

  public void roll(int roll) {
    Player currentPlayer = getCurrentPlayer();
    System.out.println(currentPlayer.getName() + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (currentPlayer.isInPenaltyBox()) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
        currentPlayer.movePlayer(roll);

        System.out.println(
            currentPlayer.getName() + "'s new location is " + currentPlayer.getPositionOnBoard());
        System.out.println("The category is " + currentCategory(currentPlayer));
        askQuestion(currentPlayer);
      } else {
        System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }

    } else {

      currentPlayer.movePlayer(roll);

      System.out.println(
          currentPlayer.getName() + "'s new location is " + currentPlayer.getPositionOnBoard());
      System.out.println("The category is " + currentCategory(currentPlayer));
      askQuestion(currentPlayer);
    }
  }

  private void askQuestion(Player player) {
    if (currentCategory(player).equals("Pop")) System.out.println(popQuestions.removeFirst());
    if (currentCategory(player).equals("Science"))
      System.out.println(scienceQuestions.removeFirst());
    if (currentCategory(player).equals("Sports")) System.out.println(sportsQuestions.removeFirst());
    if (currentCategory(player).equals("Rock")) System.out.println(rockQuestions.removeFirst());
  }

  private String currentCategory(Player player) {
    if (player.getPositionOnBoard() == 0) return "Pop";
    if (player.getPositionOnBoard() == 4) return "Pop";
    if (player.getPositionOnBoard() == 8) return "Pop";
    if (player.getPositionOnBoard() == 1) return "Science";
    if (player.getPositionOnBoard() == 5) return "Science";
    if (player.getPositionOnBoard() == 9) return "Science";
    if (player.getPositionOnBoard() == 2) return "Sports";
    if (player.getPositionOnBoard() == 6) return "Sports";
    if (player.getPositionOnBoard() == 10) return "Sports";
    return "Rock";
  }

  public boolean wasCorrectlyAnswered() {
    if (getCurrentPlayer().isInPenaltyBox()) {
      if (isGettingOutOfPenaltyBox) {
        System.out.println("Answer was correct!!!!");
        getCurrentPlayer().addCoin();

        System.out.println(
            getCurrentPlayer().getName()
                + " now has "
                + getCurrentPlayer().getAmountOfCoins()
                + " Gold Coins.");

        boolean winner = getCurrentPlayer().isWinner();
        switchToNextPlayer();
        return winner;
      } else {
        switchToNextPlayer();
        return true;
      }

    } else {

      System.out.println("Answer was correct!!!!");

      getCurrentPlayer().addCoin();

      System.out.println(
          getCurrentPlayer().getName()
              + " now has "
              + getCurrentPlayer().getAmountOfCoins()
              + " Gold Coins.");

      boolean winner = getCurrentPlayer().isWinner();
      switchToNextPlayer();
      return winner;
    }
  }

  public boolean wrongAnswer() {
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
}