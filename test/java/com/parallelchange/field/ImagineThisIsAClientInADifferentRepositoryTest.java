package com.parallelchange.field;

import main.java.com.parallelchange.field.ImagineThisIsAClientInADifferentRepository;
import org.junit.Assert;
import org.junit.Test;

public class ImagineThisIsAClientInADifferentRepositoryTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();

        Assert.assertEquals("Total price is 50 euro", client.formattedTotalPrice(50));
    }

}