package main.java.com.uglytrivia;

import java.util.Arrays;
import java.util.List;

public enum QuestionCategory {
  POP("Pop", Arrays.asList(new Integer[] {0, 4, 8})),
  SCIENCE("Science", Arrays.asList(new Integer[] {1, 5, 9})),
  SPORTS("Sports", Arrays.asList(new Integer[] {2, 6, 10})),
  ROCK("Rock", Arrays.asList(new Integer[] {3, 7, 11}));

  public String name;
  public List<Integer> positions;

  private QuestionCategory(String name, List positions) {
    this.name = name;
    this.positions = positions;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getPositions() {
    return positions;
  }
}