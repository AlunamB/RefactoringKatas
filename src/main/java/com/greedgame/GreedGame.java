package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedGame {

  private final int MAX_AMOUNT_DICES = 6;

    private List diceList = new ArrayList<Integer>();
    public GreedGame(int diceRoll){
        this.diceList = new ArrayList(Arrays.asList(diceRoll));
    }

    public GreedGame(ArrayList<Integer> diceRolls){
        this.diceList = diceRolls;
    }

    public int score(){

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
        return 0;
    }
}
