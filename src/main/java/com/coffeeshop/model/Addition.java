package com.coffeeshop.model;

public abstract class Addition extends Product {
    public Addition(String name, double price) {
        super(name, price);
    }

    @Override
    public abstract String getDescription();
}
