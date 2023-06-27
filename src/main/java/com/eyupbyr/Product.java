package com.eyupbyr;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private double price;
    private boolean discountable;
}
