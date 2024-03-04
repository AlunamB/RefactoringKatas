package main.java.com.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuestionStack {

  public static final int AMOUNT_QUESTIONS_PER_CATEGORY = 50;
  private final Map<QuestionCategory, LinkedList<QuestionCard>> questionStack = new HashMap<>();

  public QuestionStack() {
    for (QuestionCategory cat : QuestionCategory.values()) {
      questionStack.put(cat, new LinkedList<>());
    }
  }

  public void fillStack() {

    for (QuestionCategory category : QuestionCategory.values()) {
      for (int i = 0; i < AMOUNT_QUESTIONS_PER_CATEGORY; i++) {
        LinkedList<QuestionCard> list = questionStack.get(category);
        list.addLast(new QuestionCard(category, i));
        questionStack.put(category, list);
      }
    }
  }

  public QuestionCard pullCardFromStack(QuestionCategory category) {
    LinkedList<QuestionCard> list = questionStack.get(category);
    return list.removeFirst();
  }

  public void addCardToStack(QuestionCard card) {
    LinkedList<QuestionCard> list = questionStack.get(card.getCategory());
    list.addLast(card);
  }

  public Map<QuestionCategory, Integer> getAmountsOfQuestions() {
    Map<QuestionCategory, Integer> amounts = new HashMap<>();

    for (QuestionCategory category : questionStack.keySet()) {
      amounts.put(category, questionStack.get(category).size());
    }

    return amounts;
  }
}