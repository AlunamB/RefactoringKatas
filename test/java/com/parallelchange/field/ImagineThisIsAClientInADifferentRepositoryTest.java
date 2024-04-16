package com.parallelchange.field;

import main.java.com.parallelchange.field.ImagineThisIsAClientInADifferentRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ImagineThisIsAClientInADifferentRepositoryTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();

        Assert.assertEquals("Total price is 50 euro", client.formattedTotalPrice(Arrays.asList(50)));
    }
    @Test
    public void multipleItems_numberOfProductsInTheCart() throws Exception {
        ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();

        Assert.assertEquals("Total price is 70 euro", client.formattedTotalPrice(Arrays.asList(50, 20)));
    }


}