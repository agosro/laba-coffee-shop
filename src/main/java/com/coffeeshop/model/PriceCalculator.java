package com.coffeeshop.model;

@FunctionalInterface
public interface PriceCalculator<T> {
    double calculate(T item);
}

