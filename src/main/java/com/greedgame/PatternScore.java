package main.java.com.greedgame;

import java.util.Arrays;
import java.util.List;

public enum PatternScore {
  SINGLE_ONE(List.of(1), 100),
  SINGLE_FIVE(List.of(5), 50),
  TRIPLE_ONE(Arrays.asList(1, 1, 1), 1000);

  private final List<Integer> pattern;
  private final int score;

  PatternScore(List<Integer> pattern, int score) {
    this.pattern = pattern;
    this.score = score;
  }

  public List<Integer> getPattern() {
    return pattern;
  }

  public int getScore() {
    return score;
  }
}
