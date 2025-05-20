package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.List;

public class GreedGame {

  private static final int MAX_AMOUNT_DICES = 6;
  private static final int INITIAL_SCORE = 0;

  private List<Integer> diceList;

  public GreedGame(int diceRoll) {
    this.diceList = new ArrayList<>(List.of(diceRoll));
  }

  public GreedGame(ArrayList<Integer> diceRolls) {
    this.diceList = diceRolls;
  }

  private static int calculateScore(List<PatternScore> patternList) {
    int score = INITIAL_SCORE;
    if (!patternList.isEmpty()) {
      for (PatternScore ps : patternList) {
        score = score + ps.getScore();
      }
    }
    return score;
  }

  public int score() {
    checkExitCriteriaAndThrowException();

    List<PatternScore> patternList = findPatterns();
    return calculateScore(patternList);
  }

  private List<PatternScore> findPatterns() {
    List<PatternScore> patternList = new ArrayList<>();
    if (diceList.contains(1)) {
      patternList.add(PatternScore.SINGLE_ONE);
      diceList.remove(Integer.valueOf(1));
    } else if (diceList.contains(5)) {
      patternList.add(PatternScore.SINGLE_FIVE);
      diceList.remove(Integer.valueOf(5));
    }
    return patternList;
  }

  private void checkExitCriteriaAndThrowException() {
    if (diceList.isEmpty()) {
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
