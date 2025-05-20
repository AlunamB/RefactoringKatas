package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedGame {

  private static final int MAX_AMOUNT_DICES = 6;
  private static final int INITIAL_SCORE = 0;
  private static final int SINGLE_ONE_SCORE = 100;
  private static final int SINGLE_FIVE_SCORE = 50;

    private List diceList = new ArrayList<Integer>();
    public GreedGame(int diceRoll){
        this.diceList = new ArrayList(Arrays.asList(diceRoll));
    }

    public GreedGame(ArrayList<Integer> diceRolls){
        this.diceList = diceRolls;
    }

    public int score(){
    checkExitCriteriaAndThrowException();
    int score = INITIAL_SCORE;
    if (diceList.contains(1)) {
      score = SINGLE_ONE_SCORE;
    } else if (diceList.contains(5)) {
      score = SINGLE_FIVE_SCORE;
    }
    return score;
  }

  private void checkExitCriteriaAndThrowException() {
        if (diceList.isEmpty()){
            throw new IllegalArgumentException("No dice has been rolled");
    } else if (diceList.size() > MAX_AMOUNT_DICES) {
      throw new IllegalArgumentException(
          "You rolled "
              + diceList.size()
              + " dices. The maximum amount of dices is "
              + MAX_AMOUNT_DICES
              + ".");
        }
    }
}
