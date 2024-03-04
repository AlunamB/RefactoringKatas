package com.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;
import main.java.com.uglytrivia.Game;
import main.java.com.uglytrivia.QuestionCategory;
import main.java.com.uglytrivia.QuestionStack;
import org.junit.Test;

public class QuestionStackTest {

  @Test
  public void shouldInitQuestionStackForNewGameWithEveryQuestionCategory() {

    QuestionCategory[] categories = QuestionCategory.values();
    Game aGame = new Game();

    Map<QuestionCategory, Integer> amounts = aGame.getAmountsOfQuestions();
    assertTrue(amounts.keySet().containsAll(Set.of(categories)));
  }

  @Test
  public void shouldInitQuestionStackForNewGameWithFixedAmountsOfQuestionsPerCategory() {
    Game aGame = new Game();

    Map<QuestionCategory, Integer> amounts = aGame.getAmountsOfQuestions();
    for (QuestionCategory q : amounts.keySet()) {
      assertEquals(QuestionStack.AMOUNT_QUESTIONS_PER_CATEGORY, amounts.get(q).intValue());
    }
  }
}