package main.java.com.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuestionStack {

  private Map<QuestionCategory, LinkedList<QuestionCard>> questionStack = new HashMap<>();

  public QuestionStack() {
    for (QuestionCategory cat : QuestionCategory.values()) {
      questionStack.put(cat, new LinkedList<QuestionCard>());
    }
  }

  public void fillStack() {

    for (QuestionCategory category : QuestionCategory.values()) {
      for (int i = 0; i < 50; i++) {
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
}