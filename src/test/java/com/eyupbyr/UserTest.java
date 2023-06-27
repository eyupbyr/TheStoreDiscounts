package com.eyupbyr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    @Test
    public void testIsUserLongTermCustomer() {
        User user = new User(true, false, false, LocalDate.of(2019, 3, 10));

        Assertions.assertTrue(user.isCustomerOverTwoYears());
    }

    @Test
    public void testIsUserNotLongTermCustomer() {
        User user = new User(true, false, false, LocalDate.of(2023, 3, 10));

        Assertions.assertFalse(user.isCustomerOverTwoYears());
    }
}
