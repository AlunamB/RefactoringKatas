package main.java.com.gildedrose;

public class GildedRose {
  public Item[] items;

  public static final int MAX_ITEM_QUALITY_NON_LEGENDARY = 50;
  public static final int MIN_ITEM_QUALITY = 0;
  public static final int NORMAL_ITEM_QUALITY_INCREASE = 1;
  public static final int NORMAL_ITEM_QUALITY_DECREASE = -1;
  public static final int SELLIN_PASSED_QUALITY_CHANGE_FACTOR = 2;
  public static final int CONJURED_ITEM_CHANGE_FACTOR = 2;
  public static final int BACKSTAGE_PASS_DOUBLE_QUALITY_INCREASE = 2;
  public static final int BACKSTAGE_PASS_TRIPLE_QUALITY_INCREASE = 3;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateItem() {
    for (int i = 0; i < items.length; i++) {
      if (isLegendaryItem(i)) {
        continue;
      }

      decreaseSellInValue(i);
      updateItemQuality(i);
    }
  }

  private void updateItemQuality(int i) {
    if (isNormalItem(i)) {
      updateItemQualityOfNormalItem(i);
    } else if (isBackstagePass(i)) {
      updateItemQualityOfBackstagePass(i);
    } else if (isAgedBrie(i)) {
      updateItemQualityOfAgedBrie(i);
    } else if (isConjuredItem(i)) {
      updateItemQualityOfConjuredItem(i);
    }
  }

  private void updateItemQualityOfNormalItem(int i) {
    if (hasPassedSellIn(i)) {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE * SELLIN_PASSED_QUALITY_CHANGE_FACTOR);
    } else {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE);
    }
  }

  private void updateItemQualityOfConjuredItem(int i) {
    if (hasPassedSellIn(i)) {
      changeItemQualityBy(
          i,
          NORMAL_ITEM_QUALITY_DECREASE
              * SELLIN_PASSED_QUALITY_CHANGE_FACTOR
              * CONJURED_ITEM_CHANGE_FACTOR);
    } else {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE * CONJURED_ITEM_CHANGE_FACTOR);
    }
  }

  private void updateItemQualityOfAgedBrie(int i) {

    if (hasPassedSellIn(i)) {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE * SELLIN_PASSED_QUALITY_CHANGE_FACTOR);
    } else {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE);
    }
  }

  private void updateItemQualityOfBackstagePass(int itemIndex) {
    if (hasPassedSellIn(itemIndex)) {
      setQualityToMinimum(itemIndex);
    } else {
      if (items[itemIndex].sellIn >= 10) {
        changeItemQualityBy(itemIndex, NORMAL_ITEM_QUALITY_INCREASE);
      } else if (items[itemIndex].sellIn <= 9 && items[itemIndex].sellIn >= 5) {
        changeItemQualityBy(itemIndex, BACKSTAGE_PASS_DOUBLE_QUALITY_INCREASE);
      } else if (items[itemIndex].sellIn < 5) {
        changeItemQualityBy(itemIndex, BACKSTAGE_PASS_TRIPLE_QUALITY_INCREASE);
      }
    }
  }

  private void setQualityToMinimum(int itemIndex) {
    items[itemIndex].quality = MIN_ITEM_QUALITY;
  }

  private void setQualityToMaximum(int itemIndex) {
    items[itemIndex].quality = MAX_ITEM_QUALITY_NON_LEGENDARY;
  }

  private boolean isNormalItem(int itemIndex) {
    return !isAgedBrie(itemIndex) && !isBackstagePass(itemIndex) && !isConjuredItem(itemIndex);
  }

  private boolean isAgedBrie(int itemIndex) {
    return items[itemIndex].name.equals("Aged Brie");
  }

  private boolean isBackstagePass(int itemIndex) {
    return items[itemIndex].name.startsWith("Backstage passes");
  }

  private boolean isConjuredItem(int itemIndex) {
    return items[itemIndex].name.startsWith("Conjured");
  }

  private void decreaseSellInValue(int itemIndex) {
    items[itemIndex].sellIn = items[itemIndex].sellIn - 1;
  }

  private boolean isLegendaryItem(int itemIndex) {
    return items[itemIndex].name.startsWith("Sulfuras");
  }

  private void changeItemQualityBy(int itemIndex, int addedToCurrentQuality) {
    if (items[itemIndex].quality < MAX_ITEM_QUALITY_NON_LEGENDARY) {
      items[itemIndex].quality = items[itemIndex].quality + addedToCurrentQuality;
    }
    if (hasExceededMaxQuality(itemIndex)) {
      setQualityToMaximum(itemIndex);
    }

    if (hasNegativeQualityValue(itemIndex)) {
      setQualityToMinimum(itemIndex);
    }
  }

  private boolean hasExceededMaxQuality(int itemIndex) {
    return items[itemIndex].quality > MAX_ITEM_QUALITY_NON_LEGENDARY;
  }

  private boolean hasPassedSellIn(int itemIndex) {
    return items[itemIndex].sellIn < 0;
  }

  private boolean hasNegativeQualityValue(int itemIndex) {
    return items[itemIndex].quality < 0;
  }
}