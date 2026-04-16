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

    public List<T> filter(FilterCondition<T> condition) {
        return history.stream()
                .filter(condition::test)
                .toList();
    }

    public double calculateTotal(PriceCalculator<T> calculator) {
        return history.stream()
                .mapToDouble(calculator::calculate)
                .sum();
    }

    public void processAll(ActionProcessor<T> processor) {
        history.stream().forEach(processor::process);
    }
}
