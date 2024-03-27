package main.java.com.uglytrivia;

public class AdultPlayer extends Player {

  public AdultPlayer(String name) {
    this.name = name;
    setAmountOfCoins(0);
    setPositionOnBoard(0);
    setInPenaltyBox(false);
  }

  public void addCoin() {
    System.out.println("Answer was correct!!!!");
    setAmountOfCoins(getAmountOfCoins() + 1);
    System.out.println(getName() + " now has " + getAmountOfCoins() + " Gold Coins.");
  }
}