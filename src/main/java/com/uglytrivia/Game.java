package main.java.com.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
  ArrayList<Player> playerList = new ArrayList<Player>();
  int[] places = new int[6];
  int[] amountOfCoins = new int[6];
  boolean[] inPenaltyBox = new boolean[6];

  LinkedList popQuestions = new LinkedList();
  LinkedList scienceQuestions = new LinkedList();
  LinkedList sportsQuestions = new LinkedList();
  LinkedList rockQuestions = new LinkedList();

  int currentPlayer = 0;
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

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + playerList.size());
    return true;
  }

  public int howManyplayerList() {
    return playerList.size();
  }

  public void roll(int roll) {
    System.out.println(playerList.get(currentPlayer).getName() + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (inPenaltyBox[currentPlayer]) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(
            playerList.get(currentPlayer).getName() + " is getting out of the penalty box");
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(
            playerList.get(currentPlayer).getName()
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
      } else {
        System.out.println(
            playerList.get(currentPlayer).getName() + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }

    } else {

      places[currentPlayer] = places[currentPlayer] + roll;
      if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

      System.out.println(
          playerList.get(currentPlayer).getName() + "'s new location is " + places[currentPlayer]);
      System.out.println("The category is " + currentCategory());
      askQuestion();
    }
  }

  private void askQuestion() {
    if (currentCategory() == "Pop") System.out.println(popQuestions.removeFirst());
    if (currentCategory() == "Science") System.out.println(scienceQuestions.removeFirst());
    if (currentCategory() == "Sports") System.out.println(sportsQuestions.removeFirst());
    if (currentCategory() == "Rock") System.out.println(rockQuestions.removeFirst());
  }

  private String currentCategory() {
    if (places[currentPlayer] == 0) return "Pop";
    if (places[currentPlayer] == 4) return "Pop";
    if (places[currentPlayer] == 8) return "Pop";
    if (places[currentPlayer] == 1) return "Science";
    if (places[currentPlayer] == 5) return "Science";
    if (places[currentPlayer] == 9) return "Science";
    if (places[currentPlayer] == 2) return "Sports";
    if (places[currentPlayer] == 6) return "Sports";
    if (places[currentPlayer] == 10) return "Sports";
    return "Rock";
  }

  public boolean wasCorrectlyAnswered() {
    if (inPenaltyBox[currentPlayer]) {
      if (isGettingOutOfPenaltyBox) {
        System.out.println("Answer was correct!!!!");
        amountOfCoins[currentPlayer]++;
        System.out.println(
            playerList.get(currentPlayer).getName()
                + " now has "
                + amountOfCoins[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == playerList.size()) currentPlayer = 0;

        return winner;
      } else {
        currentPlayer++;
        if (currentPlayer == playerList.size()) currentPlayer = 0;
        return true;
      }

    } else {

      System.out.println("Answer was correct!!!!");
      amountOfCoins[currentPlayer]++;
      System.out.println(
          playerList.get(currentPlayer).getName()
              + " now has "
              + amountOfCoins[currentPlayer]
              + " Gold Coins.");

      boolean winner = didPlayerWin();
      currentPlayer++;
      if (currentPlayer == playerList.size()) currentPlayer = 0;

      return winner;
    }
  }

  public boolean wrongAnswer() {
    System.out.println("Question was incorrectly answered");
    System.out.println(playerList.get(currentPlayer).getName() + " was sent to the penalty box");
    inPenaltyBox[currentPlayer] = true;

    currentPlayer++;
    if (currentPlayer == playerList.size()) currentPlayer = 0;
    return true;
  }

  private boolean didPlayerWin() {
    return !(amountOfCoins[currentPlayer] == 6);
  }
}