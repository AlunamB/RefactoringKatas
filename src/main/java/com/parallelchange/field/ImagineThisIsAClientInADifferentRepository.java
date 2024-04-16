package main.java.com.parallelchange.field;

import java.util.List;

public class ImagineThisIsAClientInADifferentRepository {

    public String formattedTotalPrice(List<Integer> priceList) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(priceList);
        return String.format("Total price is %d euro", shoppingCart.calculateTotalPrice());
    }
}