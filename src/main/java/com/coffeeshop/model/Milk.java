package com.coffeeshop.model;

import java.util.Objects;

public class Milk extends Addition {

    public Milk(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "A type of milk.";
    }

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milk milk = (Milk) o;
        return Double.compare(milk.price, price) == 0 &&
                Objects.equals(name, milk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
