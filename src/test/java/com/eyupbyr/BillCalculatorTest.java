package com.eyupbyr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class BillCalculatorTest {

    @Test
    public void testCalculateNetPayableAmount_GoldCardDiscount() {
        User user = new User(true, false, false, LocalDate.of(2019, 3, 10));


        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true));
        bill.addProduct(new Product(1500.00, false));
        bill.addProduct(new Product(1000.00, true));

        BillCalculator billCalculator = new BillCalculator();

        //350 + 1500 + 700 = 2550
        //2550 % 200 = 12, 2550 - 12*5 = 2490
        double expectedNetPayableAmount = 2490.00;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_SilverCardDiscount() {
        User user = new User(false, true, true, LocalDate.of(2022, 3, 10));

        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true));
        bill.addProduct(new Product(1500.00, true));
        bill.addProduct(new Product(1000.00, true));

        BillCalculator billCalculator = new BillCalculator();

        double expectedNetPayableAmount = 2340.00;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_AffiliateDiscount() {
        User user = new User(false, false, true, LocalDate.of(2018, 3, 10));


        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true));
        bill.addProduct(new Product(1500.00, true));
        bill.addProduct(new Product(1000.00, true));

        BillCalculator billCalculator = new BillCalculator();

        double expectedNetPayableAmount = 2635.00;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_CustomerOverTwoYearsDiscount() {
        User user = new User(false, false, false, LocalDate.of(2020, 3, 10));


        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true));
        bill.addProduct(new Product(1500.00, true));
        bill.addProduct(new Product(1000.00, true));

        BillCalculator billCalculator = new BillCalculator();

        double expectedNetPayableAmount = 2780;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_OnlyBillAmountDiscount() {
        User user = new User(false, false, false, LocalDate.of(2023, 3, 10));

        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true));
        bill.addProduct(new Product(1500.00, true));
        bill.addProduct(new Product(1000.00, true));

        BillCalculator billCalculator = new BillCalculator();

        double expectedNetPayableAmount = 2925.00;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_NoDiscount() {
        User user = new User(false, false, false, LocalDate.of(2023, 3, 10));

        Bill bill = new Bill();
        bill.addProduct(new Product(195.00, true));

        BillCalculator billCalculator = new BillCalculator();

        double expectedNetPayableAmount = 195.00;
        double actualNetPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);

        Assertions.assertEquals(expectedNetPayableAmount, actualNetPayableAmount);
    }

}
