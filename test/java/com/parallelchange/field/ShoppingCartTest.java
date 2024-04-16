package com.parallelchange.field;

import java.util.Arrays;
import java.util.List;
import main.java.com.parallelchange.field.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        Assert.assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void multipleItems_numberOfProductsInTheCart() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Integer> prices = Arrays.asList(10, 15);
        shoppingCart.add(prices);

        Assert.assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        Assert.assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void multipleItems_totalPrice() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Integer> prices = Arrays.asList(10, 15);
        shoppingCart.add(prices);

        Assert.assertEquals(25, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void multipleItems_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Integer> prices = Arrays.asList(100, 15);
        shoppingCart.add(prices);

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }
    @Test
    public void multipleItems_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Integer> prices = Arrays.asList(99, 15);
        shoppingCart.add(prices);

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

}