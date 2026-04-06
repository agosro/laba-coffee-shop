package com.coffeeshop.model;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory<T extends Order> {
    private List<T> history = new ArrayList<>();

    public void addOrder(T order) {
        history.add(order);
    }

    public List<T> getHistory() {
        return history;
    }
}

