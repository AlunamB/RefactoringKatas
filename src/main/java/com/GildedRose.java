package main.java.com;

public class GildedRose {
  public Item[] items;

  public static final int MAX_ITEM_QUALITY_NON_LEGENDARY = 50;
  public static final int MIN_ITEM_QUALITY = 0;
  public static final int NORMAL_ITEM_QUALITY_INCREASE = 1;
  public static final int NORMAL_ITEM_QUALITY_DECREASE = -1;
  public static final int SELLIN_PASSED_QUALITY_CHANGE_FACTOR = 2;
  public static final int BACKSTAGE_PASS_DOUBLE_QUALITY_INCREASE = 2;
  public static final int BACKSTAGE_PASS_TRIPLE_QUALITY_INCREASE = 3;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (isLegendaryItem(i)) {
        continue;
      }

      decreaseSellInValue(i);

      if (isNormalItem(i)) {
        updateItemQualityOfNormalItem(i);
      } else if (isBackstagePass(i)) {
        updateItemQualityOfBackstagePass(i);
      } else if (isAgedBrie(i)) {
        updateItemQualityOfAgedBrie(i);
      }
    }
  }

  private void updateItemQualityOfNormalItem(int i) {
    if (hasPassedSellIn(i)) {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE * SELLIN_PASSED_QUALITY_CHANGE_FACTOR);
    } else {
      changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE);
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

  private boolean isNormalItem(int i) {
    return !isAgedBrie(i) && !isBackstagePass(i);
  }

  private boolean isAgedBrie(int i) {
    return items[i].name.equals("Aged Brie");
  }

  private boolean isBackstagePass(int itemIndex) {
    return items[itemIndex].name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private void decreaseSellInValue(int itemIndex) {
    items[itemIndex].sellIn = items[itemIndex].sellIn - 1;
  }

  private boolean isLegendaryItem(int itemIndex) {
    return items[itemIndex].name.equals("Sulfuras, Hand of Ragnaros");
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
    return items[itemIndex].quality > 50;
  }

  private boolean hasPassedSellIn(int itemIndex) {
    return items[itemIndex].sellIn < 0;
  }

  private boolean hasNegativeQualityValue(int itemIndex) {
    return items[itemIndex].quality < 0;
  }
}