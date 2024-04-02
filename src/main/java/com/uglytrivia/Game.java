package main.java.com.uglytrivia;

import java.util.*;
import main.java.com.uglytrivia.player.AdultPlayer;
import main.java.com.uglytrivia.player.ChildPlayer;
import main.java.com.uglytrivia.player.Player;
import main.java.com.uglytrivia.questionstack.OpenQuestionStack;
import main.java.com.uglytrivia.questionstack.UsedQuestionStack;

public class Game {
  public static final int AMOUNT_OF_BOARD_POSITIONS = 12;
  ArrayList<Player> playerList = new ArrayList<>();

  private final int amountOfCoinsForWinning;

  private final OpenQuestionStack stackOfOpenQuestions = new OpenQuestionStack();
  private final UsedQuestionStack stackOfUsedQuestions = new UsedQuestionStack();

  public Game(int amountOfCoinsForWinning) {
    stackOfOpenQuestions.fillStack();
    this.amountOfCoinsForWinning = amountOfCoinsForWinning;
  }

  public boolean isPlayable() {
    return checkAmountOfPlayers() && checkAmountOfCoinsForWinning();
  }

  private boolean checkAmountOfPlayers() {
    return getAmountOfPlayers() >= 2 && getAmountOfPlayers() <= 6;
  }

  private boolean checkAmountOfCoinsForWinning() {
    return amountOfCoinsForWinning >= 3;
  }

  public void addAdultPlayer(String playerName) {
    playerList.add(new AdultPlayer(playerName));
    initFirstPlayer();
    logAddedPlayer(playerName);
  }

  public void addChildPlayer(String playerName) {
    playerList.add(new ChildPlayer(playerName));
    initFirstPlayer();
    logAddedPlayer(playerName);
  }

  private void logAddedPlayer(String playerName) {
    System.out.println(playerName + " was added");
    System.out.println("They are player number " + playerList.size());
  }

  private void initFirstPlayer() {
    if (playerList.size() == 1) {
      playerList.get(0).setCurrentPlayer(true);
    }
  }

  public int getAmountOfPlayers() {
    return playerList.size();
  }

  public void playNextRound(Random rand) {
    roll(rand.nextInt(5) + 1);
    playerAnswersQuestion(rand.nextInt(9));
  }

  public void playerAnswersQuestion(int randomNumber) {
    if (randomNumber == 7) {
      playerAnsweredWrong();
    } else {
      playerAnsweredCorrect();
    }
    switchToNextPlayer();
  }

  public void roll(int roll) {
    Player currentPlayer = getCurrentPlayer();
    System.out.println(currentPlayer.getName() + " is the current player");
    System.out.println("They have rolled a " + roll);
    currentPlayer.setGettingOutOfPenaltyBox(false);

    if (currentPlayer.isInPenaltyBox()) {
      if (isOddNumber(roll)) {
        currentPlayer.setGettingOutOfPenaltyBox(true);
        System.out.println(currentPlayer.getName() + " is getting out of the penalty box");

        currentPlayer.movePlayer(roll);
        askQuestion(currentPlayer);
      } else {
        System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
      }

    } else {
      currentPlayer.movePlayer(roll);
      askQuestion(currentPlayer);
    }
  }

  private void askQuestion(Player player) {
    QuestionCategory category = getCurrentCategoryForPosition(player);
    System.out.println("The category is " + category.name);

    QuestionCard pulledCard = stackOfOpenQuestions.pullCardFromStack(category);
    System.out.println(pulledCard.getQuestionText());
    stackOfUsedQuestions.addCardToStack(pulledCard);
  }

  private QuestionCategory getCurrentCategoryForPosition(Player player) {
    QuestionCategory category = null;
    for (QuestionCategory q : QuestionCategory.values()) {
      if (q.getPositions().contains(player.getPositionOnBoard())) {
        category = q;
        break;
      }
    }
    return category;
  }

  private void playerAnsweredCorrect() {
    Player currentPlayer = getCurrentPlayer();
    if (currentPlayer.isInPenaltyBox()) {
      if (currentPlayer.isGettingOutOfPenaltyBox()) {
        getCurrentPlayer().addCoin();
      }

    } else {
      getCurrentPlayer().addCoin();
    }
  }

  private void playerAnsweredWrong() {
    System.out.println("Question was incorrectly answered");
    System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
    getCurrentPlayer().setInPenaltyBox(true);
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

  public boolean noPlayerHasWon() {
    for (Player p : playerList) {
      if (p.hasEnoughCoinsToWin(6)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isOddNumber(int roll) {
    return roll % 2 != 0;
  }

  public Map<QuestionCategory, Integer> getAmountsOfOpenQuestions() {
    return stackOfOpenQuestions.getAmountsOfQuestions();
  }

  public Map<QuestionCategory, Integer> getAmountsOfUsedQuestions() {
    return stackOfUsedQuestions.getAmountsOfQuestions();
  }

  public String getUsedQuestionSummary() {
    StringBuilder builder = new StringBuilder("This is the summary of the used question cards:");
    Map<QuestionCategory, Integer> amounts = getAmountsOfUsedQuestions();
    List<QuestionCategory> sortedCategories =
        amounts.keySet().stream().sorted(Comparator.comparing(QuestionCategory::getName)).toList();
    for (QuestionCategory category : sortedCategories) {
      builder.append(category.getName());
      builder.append(":");
      builder.append(amounts.get(category));
      builder.append(" ");
    }
    return builder.toString();
  }

  public int getAmountOfCoinsForWinning() {
    return amountOfCoinsForWinning;
  }
}