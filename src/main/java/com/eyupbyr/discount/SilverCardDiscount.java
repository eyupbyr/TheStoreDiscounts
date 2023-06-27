package com.eyupbyr.discount;

public class SilverCardDiscount implements Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.20;


    @Override
    public double calculateDiscountAmount(double productAmount) {
        return productAmount * DISCOUNT_PERCENTAGE;
    }

}
