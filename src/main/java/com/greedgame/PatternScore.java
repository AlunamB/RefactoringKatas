package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PatternScore {
  SINGLE_ONE(List.of(1), 100),
  SINGLE_FIVE(List.of(5), 50),
  TRIPLE_ONE(Arrays.asList(1, 1, 1), 1000),
  TRIPLE_TWO(Arrays.asList(2, 2, 2), 200),
  TRIPLE_THREE(Arrays.asList(3, 3, 3), 300),
  TRIPLE_FOUR(Arrays.asList(4, 4, 4), 400),
  TRIPLE_FIVE(Arrays.asList(5, 5, 5), 500),
  TRIPLE_SIX(Arrays.asList(6, 6, 6), 600);

  private final List<Integer> pattern;
  private final int score;

  PatternScore(List<Integer> pattern, int score) {
    this.pattern = pattern;
    this.score = score;
  }

  public static List<PatternScore> getTriplePatterns() {
    List<PatternScore> tripleList = new ArrayList<>();
    for (PatternScore ps : PatternScore.values()) {
      if (ps.getPattern().size() == 3) {
        tripleList.add(ps);
      }
    }
    return tripleList;
  }

  public List<Integer> getPattern() {
    return pattern;
  }

  public int getScore() {
    return score;
  }
}
