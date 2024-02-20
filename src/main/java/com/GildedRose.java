package main.java.com;

public class GildedRose {
    public Item[] items;

    public static final int MAX_ITEM_QUALITY_NON_LEGENDARY = 50;
    public static final int MIN_ITEM_QUALITY = 0;
    public static final int NORMAL_ITEM_QUALITY_INCREASE = 1;
    public static final int NORMAL_ITEM_QUALITY_DECREASE = -1;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isLegendaryItem(i)) {
                decreaseSellInValue(i);
            }


            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (hasPositiveQualityValue(i)) {
                    if (!isLegendaryItem(i)) {
                        changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE);
                    }
                }
            } else {
                if (items[i].quality < MAX_ITEM_QUALITY_NON_LEGENDARY) {
                    changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 10) {
                            if (items[i].quality < MAX_ITEM_QUALITY_NON_LEGENDARY) {
                                changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE);
                            }
                        }

                        if (items[i].sellIn < 5) {
                            if (items[i].quality < MAX_ITEM_QUALITY_NON_LEGENDARY) {
                                       changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE);
                            }
                        }
                    }
                }
            }



            if (hasPassedSellIn(i)) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (hasPositiveQualityValue(i)) {
                            if (!isLegendaryItem(i)) {
                                changeItemQualityBy(i, NORMAL_ITEM_QUALITY_DECREASE);
                            }
                        }
                    } else {
                        items[i].quality = MIN_ITEM_QUALITY;
                    }
                } else {
                    if (items[i].quality < MAX_ITEM_QUALITY_NON_LEGENDARY) {
                        changeItemQualityBy(i, NORMAL_ITEM_QUALITY_INCREASE);
                    }
                }
            }
        }
    }

    private void decreaseSellInValue(int itemIndex) {
        items[itemIndex].sellIn = items[itemIndex].sellIn - 1;
    }

    private boolean isLegendaryItem(int itemIndex) {
        return items[itemIndex].name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void changeItemQualityBy(int itemIndex, int addedToCurrentQuality) {
        items[itemIndex].quality = items[itemIndex].quality + addedToCurrentQuality;
    }

    private boolean hasPassedSellIn(int itemIndex) {
        return items[itemIndex].sellIn < 0;
    }

    private boolean hasPositiveQualityValue(int itemIndex) {
        return items[itemIndex].quality > 0;
    }
}