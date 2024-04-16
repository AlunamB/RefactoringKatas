package main.java.com.parallelchange.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  private List<Integer> priceList = new ArrayList<>();

  public void add(int price) {
    this.priceList.add(price);
  }

  public void add(List<Integer> prices) {
    this.priceList.addAll(prices);
  }

  public int calculateTotalPrice() {
    return priceList.stream().reduce(0, Integer::sum);
  }

  public boolean hasDiscount() {
    return priceList.stream().anyMatch(x -> x >= 100);
  }

  public int numberOfProducts() {
    return priceList.size();
  }
}