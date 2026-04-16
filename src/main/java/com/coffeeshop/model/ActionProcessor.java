package com.coffeeshop.model;

@FunctionalInterface
public interface ActionProcessor<T> {
    void process(T item);
}

