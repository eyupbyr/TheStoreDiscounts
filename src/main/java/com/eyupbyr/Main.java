package com.eyupbyr;

import com.eyupbyr.discount.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User(false, true, true, LocalDate.of(2022, 3, 10));

        Bill bill = new Bill();
        bill.addProduct(new Product(500.00, true)); // 400
        bill.addProduct(new Product(1500.00, false)); // 1500
        bill.addProduct(new Product(1000.00, true)); // 800

        //2700
        //2700 % 200 = 13
        //2700 - 13*5 = 2635

        BillCalculator billCalculator = new BillCalculator();
        double netPayableAmount = billCalculator.calculateNetPayableAmount(user, bill);
        System.out.println("Net Payable Amount: $" + netPayableAmount);
    }
}