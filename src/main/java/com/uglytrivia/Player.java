package main.java.com.uglytrivia;

public class Player {

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
}