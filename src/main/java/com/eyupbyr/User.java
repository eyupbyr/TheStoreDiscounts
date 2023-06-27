package com.eyupbyr;

import com.eyupbyr.discount.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private boolean hasGoldCard;
    private boolean hasSilverCard;
    private boolean isAffiliate;
    private LocalDate registrationDate;

    public boolean isCustomerOverTwoYears() {
        LocalDate currentDate = LocalDate.now();
        return registrationDate.plusYears(2).isBefore(currentDate) || registrationDate.plusYears(2).isEqual(currentDate);
    }

    public List<Discount> getDiscounts() {
        List<Discount> discounts = new ArrayList<>();

        if (hasGoldCard) {
            discounts.add(new GoldCardDiscount());
        }

        if (hasSilverCard) {
            discounts.add(new SilverCardDiscount());
        }

        if (isAffiliate) {
            discounts.add(new AffiliateDiscount());
        }

        if (isCustomerOverTwoYears()) {
            discounts.add(new CustomerOverTwoYearsDiscount());
        }

        return discounts;
    }
}
