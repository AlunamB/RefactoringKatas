package main.java.com.uglytrivia;

import java.util.LinkedList;

public class OpenQuestionStack extends QuestionStack {

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
}