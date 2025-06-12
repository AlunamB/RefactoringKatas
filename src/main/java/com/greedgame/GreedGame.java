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

    findAndRemoveSextuplets(amounts, patternList);
    findAndRemoveQuintuplets(amounts, patternList);
    findAndRemoveQuadruplets(amounts, patternList);
    findAndRemoveTriples(amounts, patternList);

    if (diceList.contains(1)) {
      addPatternAndRemoveFromDiceList(patternList, PatternScore.SINGLE_ONE);
    }
    if (diceList.contains(5)) {
      addPatternAndRemoveFromDiceList(patternList, PatternScore.SINGLE_FIVE);
    }
    return patternList;
  }

  private void findAndRemoveSextuplets(
      HashMap<Integer, Integer> amounts, List<PatternScore> patternList) {
    findAndRemoveMultipleOfSize(6, amounts, patternList);
  }

  private void findAndRemoveQuintuplets(
      HashMap<Integer, Integer> amounts, List<PatternScore> patternList) {
    findAndRemoveMultipleOfSize(5, amounts, patternList);
  }

  private void findAndRemoveQuadruplets(
      HashMap<Integer, Integer> amounts, List<PatternScore> patternList) {
    findAndRemoveMultipleOfSize(4, amounts, patternList);
  }

  private void findAndRemoveTriples(
      HashMap<Integer, Integer> amounts, List<PatternScore> patternList) {
    findAndRemoveMultipleOfSize(3, amounts, patternList);
  }

  private void findAndRemoveMultipleOfSize(
      int multipleFactor, HashMap<Integer, Integer> amounts, List<PatternScore> patternList) {
    for (PatternScore ps : PatternScore.getMultiplesPatterns(multipleFactor)) {
      if (amounts.get(ps.getPattern().getFirst()) == multipleFactor) {
        addPatternAndRemoveFromDiceList(patternList, ps);
      }
    }
  }

  private void addPatternAndRemoveFromDiceList(
      List<PatternScore> patternList, PatternScore pattern) {
    patternList.add(pattern);
    diceList.removeAll(pattern.getPattern());
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
