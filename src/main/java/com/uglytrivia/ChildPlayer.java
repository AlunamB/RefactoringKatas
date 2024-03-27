package main.java.com.uglytrivia;

public class ChildPlayer extends Player {

  public ChildPlayer(String name) {
    this.name = name;
    setAmountOfCoins(0);
    setPositionOnBoard(0);
    setInPenaltyBox(false);
  }

  public void addCoin() {
    System.out.println("Answer was correct!!!!");
    setAmountOfCoins(getAmountOfCoins() + 2);
    System.out.println(getName() + " now has " + getAmountOfCoins() + " Gold Coins.");
  }
}