package main.java.com.uglytrivia;

import java.util.Arrays;
import java.util.List;

public enum QuestionCategory {
  POP("Pop", Arrays.asList(0, 4, 8)),
  SCIENCE("Science", Arrays.asList(1, 5, 9)),
  SPORTS("Sports", Arrays.asList(2, 6, 10)),
  ROCK("Rock", Arrays.asList(3, 7, 11));

  public final String name;
  public final List<Integer> positions;

  QuestionCategory(String name, List<Integer> positions) {
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