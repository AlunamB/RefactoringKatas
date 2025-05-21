package main.java.com.greedgame;

import java.util.*;

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

  public int score() {
    checkExitCriteriaAndThrowException();

    List<PatternScore> patternList = findPatterns();
    return calculateScore(patternList);
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

  private List<PatternScore> findPatterns() {
    List<PatternScore> patternList = new ArrayList<>();
    HashMap<Integer, Integer> amounts = new HashMap<>();
    for (int i = 1; i < 7; i++) {
      amounts.put(i, Collections.frequency(diceList, i));
    }

    if (amounts.get(1) == 3) {
      patternList.add(PatternScore.TRIPLE_ONE);
      diceList.removeAll(PatternScore.TRIPLE_ONE.getPattern());
    }

    if (diceList.contains(1)) {
      patternList.add(PatternScore.SINGLE_ONE);
      diceList.removeAll(PatternScore.SINGLE_ONE.getPattern());
    } else if (diceList.contains(5)) {
      patternList.add(PatternScore.SINGLE_FIVE);
      diceList.removeAll(PatternScore.SINGLE_FIVE.getPattern());
    }
    return patternList;
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
}
