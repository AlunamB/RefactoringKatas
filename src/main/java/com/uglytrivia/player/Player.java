package main.java.com.uglytrivia.player;

import main.java.com.uglytrivia.Game;

public abstract class Player {

  protected String name;

  private int amountOfCoins;

  private int positionOnBoard;

  private boolean inPenaltyBox;

  private boolean isGettingOutOfPenaltyBox;

  private boolean isCurrentPlayer;

  public abstract void addCoin();

  public String toString() {
    return "name:"
        + getName()
        + " amountOfCoins "
        + getAmountOfCoins()
        + " positionOnBoard:"
        + getPositionOnBoard()
        + " inPenaltyBox:"
        + isInPenaltyBox()
        + " isCurrentPlayer:"
        + isCurrentPlayer();
  }

  public boolean hasEnoughCoinsToWin(int amountOfCoinsForWinning) {
    return this.amountOfCoins == amountOfCoinsForWinning;
  }



  public void movePlayer(int rolledNumber) {
    setPositionOnBoard(getPositionOnBoard() + rolledNumber);
    if (getPositionOnBoard() > 11) {
      setPositionOnBoard(getPositionOnBoard() - Game.AMOUNT_OF_BOARD_POSITIONS);
    }
    System.out.println(getName() + "'s new location is " + getPositionOnBoard());
  }

  public String getName() {
    return name;
  }

  public int getAmountOfCoins() {
    return amountOfCoins;
  }

  public void setAmountOfCoins(int amountOfCoins) {
    this.amountOfCoins = amountOfCoins;
  }

  public int getPositionOnBoard() {
    return positionOnBoard;
  }

  public void setPositionOnBoard(int positionOnBoard) {
    this.positionOnBoard = positionOnBoard;
  }

  public boolean isInPenaltyBox() {
    return inPenaltyBox;
  }

  public void setInPenaltyBox(boolean inPenaltyBox) {
    this.inPenaltyBox = inPenaltyBox;
  }

  public boolean isGettingOutOfPenaltyBox() {
    return isGettingOutOfPenaltyBox;
  }

  public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
    isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
  }

  public boolean isCurrentPlayer() {
    return isCurrentPlayer;
  }

  public void setCurrentPlayer(boolean currentPlayer) {
    isCurrentPlayer = currentPlayer;
  }
}