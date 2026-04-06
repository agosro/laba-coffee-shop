package com.coffeeshop.model;

import java.util.Objects;

public class Syrup extends Addition {

    public Syrup(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "A type of syrup.";
    }

    @Override
    public String toString() {
        return "Syrup{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Syrup syrup = (Syrup) o;
        return Double.compare(syrup.price, price) == 0 &&
                Objects.equals(name, syrup.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
