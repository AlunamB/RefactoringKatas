package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedGame {

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
        }
        return 0;
    }
}
