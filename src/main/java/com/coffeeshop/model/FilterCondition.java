package com.coffeeshop.model;

@FunctionalInterface
public interface FilterCondition<T> {
    boolean test(T item);
}

