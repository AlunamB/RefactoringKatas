package main.java.com.uglytrivia.questionstack;

import java.util.LinkedList;
import main.java.com.uglytrivia.QuestionCard;

public class UsedQuestionStack extends QuestionStack {

  public void addCardToStack(QuestionCard card) {
    LinkedList<QuestionCard> list = questionStack.get(card.getCategory());
    list.addLast(card);
  }
}