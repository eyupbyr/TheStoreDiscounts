package com.eyupbyr.discount;

public class BillAmountDiscount implements Discount {
    private static final double DISCOUNT_THRESHOLD = 200.00;
    private static final double DISCOUNT_AMOUNT = 5.00;

    @Override
    public double calculateDiscountAmount(double billAmount) {
        return (int) (billAmount / DISCOUNT_THRESHOLD) * DISCOUNT_AMOUNT;
    }
}
