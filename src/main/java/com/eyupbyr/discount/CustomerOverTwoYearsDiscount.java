package com.eyupbyr.discount;

public class CustomerOverTwoYearsDiscount implements Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.05;

    @Override
    public double calculateDiscountAmount(double productAmount) {
        return productAmount * DISCOUNT_PERCENTAGE;
    }

}
