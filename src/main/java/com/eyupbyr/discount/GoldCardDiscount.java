package com.eyupbyr.discount;

public class GoldCardDiscount implements Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.30;

    @Override
    public double calculateDiscountAmount(double productAmount) {
        return productAmount * DISCOUNT_PERCENTAGE;
    }

}
