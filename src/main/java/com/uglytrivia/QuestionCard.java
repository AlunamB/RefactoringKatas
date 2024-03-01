package main.java.com.uglytrivia;

public class QuestionCard {

  private final QuestionCategory category;
  private final int index;

  public QuestionCard(QuestionCategory category, int index) {
    this.category = category;
    this.index = index;
  }

  public String getQuestionText() {
    return this.category.getName() + " Question " + this.index;
  }

  public QuestionCategory getCategory() {
    return category;
  }

}