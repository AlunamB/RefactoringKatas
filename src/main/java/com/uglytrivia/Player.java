package main.java.com.uglytrivia;

public class Player {

  public static final int MAX_AMOUNT_OF_COINS = 6;

  public Player(String name) {
    this.name = name;
    setAmountOfCoins(0);
    setPositionOnBoard(0);
    setInPenaltyBox(false);
  }

  private final String name;

  private int amountOfCoins;

  private int positionOnBoard;

  private boolean inPenaltyBox;

  private boolean isCurrentPlayer;

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

  public boolean hasMaxAmountOfCoins() {
    return this.amountOfCoins == MAX_AMOUNT_OF_COINS;
  }

  public boolean isWinner() {
    return !hasMaxAmountOfCoins();
  }

  public void addCoin() {
    System.out.println("Answer was correct!!!!");
    setAmountOfCoins(getAmountOfCoins() + 1);
    System.out.println(getName() + " now has " + getAmountOfCoins() + " Gold Coins.");
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

  public boolean isCurrentPlayer() {
    return isCurrentPlayer;
  }

  public void setCurrentPlayer(boolean currentPlayer) {
    isCurrentPlayer = currentPlayer;
  }
}