package com.coffeeshop.model;

import com.coffeeshop.exception.InvalidOrderException;

public interface IOrderProcessor {
    void processOrder(Order order) throws InvalidOrderException;
}
