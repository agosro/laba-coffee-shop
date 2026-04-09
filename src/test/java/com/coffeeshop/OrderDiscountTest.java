package com.coffeeshop;

import com.coffeeshop.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderDiscountTest {

    @Test
    void percentageDiscountIsAppliedToTotal() {
        Customer customer = new Customer("Test", 999);
        Coffee coffee = new Coffee("Espresso", 10.0, 1);
        CoffeeSize size = new CoffeeSize(1.0, "M");

        Order order = new Order(customer, "2026-04-09");
        order.setItem(new OrderItem(coffee, size, null, null));
        order.setDiscount(Discount.percentage(10));

        assertEquals(9.0, order.calculateTotal(), 0.0001);
    }

    @Test
    void fixedAmountDiscountNeverMakesTotalNegative() {
        Customer customer = new Customer("Test", 999);
        Coffee coffee = new Coffee("Espresso", 5.0, 1);
        CoffeeSize size = new CoffeeSize(1.0, "M");

        Order order = new Order(customer, "2026-04-09");
        order.setItem(new OrderItem(coffee, size, null, null));
        order.setDiscount(Discount.fixedAmount(999));

        assertEquals(0.0, order.calculateTotal(), 0.0001);
    }
}

