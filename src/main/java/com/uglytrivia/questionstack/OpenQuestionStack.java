package main.java.com.uglytrivia.questionstack;

import java.util.LinkedList;
import main.java.com.uglytrivia.QuestionCard;
import main.java.com.uglytrivia.QuestionCategory;

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