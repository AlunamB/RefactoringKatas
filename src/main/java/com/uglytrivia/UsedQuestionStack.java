package main.java.com.uglytrivia;

import java.util.LinkedList;

public class UsedQuestionStack extends QuestionStack {

  public void addCardToStack(QuestionCard card) {
    LinkedList<QuestionCard> list = questionStack.get(card.getCategory());
    list.addLast(card);
  }
}