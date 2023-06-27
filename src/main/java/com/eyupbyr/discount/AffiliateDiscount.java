package com.eyupbyr.discount;

public class AffiliateDiscount implements Discount {
    private static final double DISCOUNT_PERCENTAGE = 0.10;

    @Override
    public double calculateDiscountAmount(double productAmount) {
        return productAmount * DISCOUNT_PERCENTAGE;
    }

}
