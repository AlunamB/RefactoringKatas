package main.java.com.greedgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PatternScore {
  SINGLE_ONE(List.of(1), 100, false),
  SINGLE_FIVE(List.of(5), 50, false),

  TRIPLE_ONE(Arrays.asList(1, 1, 1), 1000, true),
  TRIPLE_TWO(Arrays.asList(2, 2, 2), 200, true),
  TRIPLE_THREE(Arrays.asList(3, 3, 3), 300, true),
  TRIPLE_FOUR(Arrays.asList(4, 4, 4), 400, true),
  TRIPLE_FIVE(Arrays.asList(5, 5, 5), 500, true),
  TRIPLE_SIX(Arrays.asList(6, 6, 6), 600, true),

  QUADRUPLET_ONE(Arrays.asList(1, 1, 1, 1), 2000, true),
  QUADRUPLET_TWO(Arrays.asList(2, 2, 2, 2), 400, true),
  QUADRUPLET_THREE(Arrays.asList(3, 3, 3, 3), 600, true),
  QUADRUPLET_FOUR(Arrays.asList(4, 4, 4, 4), 800, true),
  QUADRUPLET_FIVE(Arrays.asList(5, 5, 5, 5), 1000, true),
  QUADRUPLET_SIX(Arrays.asList(6, 6, 6, 6), 1200, true),

  QUINTUPLET_ONE(Arrays.asList(1, 1, 1, 1, 1), 4000, true),
  QUINTUPLET_TWO(Arrays.asList(2, 2, 2, 2, 2), 800, true),
  QUINTUPLET_THREE(Arrays.asList(3, 3, 3, 3, 3), 1200, true),
  QUINTUPLET_FOUR(Arrays.asList(4, 4, 4, 4, 4), 1600, true),
  QUINTUPLET_FIVE(Arrays.asList(5, 5, 5, 5, 5), 2000, true),
  QUINTUPLET_SIX(Arrays.asList(6, 6, 6, 6, 6), 2400, true),

  SEXTUPLET_ONE(Arrays.asList(1, 1, 1, 1, 1, 1), 8000, true),
  SEXTUPLET_TWO(Arrays.asList(2, 2, 2, 2, 2, 2), 1600, true),
  SEXTUPLET_THREE(Arrays.asList(3, 3, 3, 3, 3, 3), 2400, true),
  SEXTUPLET_FOUR(Arrays.asList(4, 4, 4, 4, 4, 4), 3200, true),
  SEXTUPLET_FIVE(Arrays.asList(5, 5, 5, 5, 5, 5), 4000, true),
  SEXTUPLET_SIX(Arrays.asList(6, 6, 6, 6, 6, 6), 4800, true);

  private final List<Integer> pattern;
  private final int score;
  private final boolean multiples;

  PatternScore(List<Integer> pattern, int score, boolean multiples) {
    this.pattern = pattern;
    this.score = score;
    this.multiples = multiples;
  }

  public static List<PatternScore> getMultiplesPatterns(int multipleFactor) {
    List<PatternScore> multiplePatternList = new ArrayList<>();
    for (PatternScore ps : PatternScore.values()) {
      if (ps.getPattern().size() == multipleFactor && ps.isMultiple()) {
        multiplePatternList.add(ps);
      }
    }
    return multiplePatternList;
  }

  public List<Integer> getPattern() {
    return pattern;
  }

  public int getScore() {
    return score;
  }

  public boolean isMultiple() {
    return multiples;
  }
}
