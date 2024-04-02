package main.java.com.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class QuestionStack {

  public static final int AMOUNT_QUESTIONS_PER_CATEGORY = 50;
  protected final Map<QuestionCategory, LinkedList<QuestionCard>> questionStack = new HashMap<>();

  public QuestionStack() {
    for (QuestionCategory cat : QuestionCategory.values()) {
      questionStack.put(cat, new LinkedList<>());
    }
  }

  public Map<QuestionCategory, Integer> getAmountsOfQuestions() {
    Map<QuestionCategory, Integer> amounts = new HashMap<>();

    for (QuestionCategory category : questionStack.keySet()) {
      amounts.put(category, questionStack.get(category).size());
    }

    return amounts;
  }
}