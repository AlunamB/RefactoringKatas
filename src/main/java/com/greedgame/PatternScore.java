package main.java.com.greedgame;

public enum PatternScore {
  SINGLE_ONE(100),
  SINGLE_FIVE(50),
  TRIPLE_ONE(1000);

  private final int patternScore;

  PatternScore(int score) {
    this.patternScore = score;
  }

  public int getScore() {
    return patternScore;
  }
}
