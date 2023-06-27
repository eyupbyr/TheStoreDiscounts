package com.eyupbyr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGetPrice() {
        double expectedPrice = 10.0;
        Product product = new Product(expectedPrice, true);

        double actualPrice = product.getPrice();

        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testIsDiscountable() {
        boolean expectedDiscountable = true;
        Product product = new Product(10.0, expectedDiscountable);

        boolean actualDiscountable = product.isDiscountable();

        Assertions.assertEquals(expectedDiscountable, actualDiscountable);
    }

    @Test
    public void testSetPrice() {
        double newPrice = 15.0;
        Product product = new Product(10.0, true);

        product.setPrice(newPrice);

        Assertions.assertEquals(newPrice, product.getPrice());
    }

    @Test
    public void testSetDiscountable() {
        boolean newDiscountable = false;
        Product product = new Product(10.0, true);

        product.setDiscountable(newDiscountable);

        Assertions.assertEquals(newDiscountable, product.isDiscountable());
    }
}

