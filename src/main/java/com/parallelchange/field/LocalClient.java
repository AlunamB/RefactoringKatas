package main.java.com.parallelchange.field;

import java.util.Arrays;

public class LocalClient {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(Arrays.asList(10));
        System.out.println("shoppingCart.numberOfProducts() = " + shoppingCart.numberOfProducts());
        System.out.println("shoppingCart.calculateTotalPrice() = " + shoppingCart.calculateTotalPrice());
        System.out.println("shoppingCart.hasDiscount() = " + shoppingCart.hasDiscount());
    }

}