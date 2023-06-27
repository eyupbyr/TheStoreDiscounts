package com.eyupbyr;

import com.eyupbyr.discount.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BillCalculator {

    public double calculateNetPayableAmount(User user, Bill bill) {
        double totalAmount = calculateTotalAmount(bill);
        double percentageBasedDiscountAmount = calculatePercentageBasedDiscountAmount(user, bill);
        return applyBillAmountDiscount(totalAmount - percentageBasedDiscountAmount);
    }

    private double calculateTotalAmount(Bill bill) {
        double totalAmount = 0.0;
        for (Product product : bill.getProducts()) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    private double calculatePercentageBasedDiscountAmount(User user, Bill bill) {
        double discountAmount = 0.0;

        if(!user.getDiscounts().isEmpty()) {
            for (Product product : bill.getProducts()) {
                if(product.isDiscountable()) {
                    Discount maxDiscount = Collections.max(
                            user.getDiscounts(),
                            Comparator.comparingDouble(
                                    discount -> discount.calculateDiscountAmount(product.getPrice())
                            )
                    );
                    discountAmount += maxDiscount.calculateDiscountAmount(product.getPrice());
                }
            }
        }

        return discountAmount;
    }

    private double applyBillAmountDiscount(double billAmount) {
        double discountAmount = new BillAmountDiscount().calculateDiscountAmount(billAmount);
        return billAmount - discountAmount;
    }

}
