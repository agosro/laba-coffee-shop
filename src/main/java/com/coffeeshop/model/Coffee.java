package com.coffeeshop.model;

import java.util.Objects;

public class Coffee extends Product implements IPreparable {

    private int prepTime;

    public Coffee(String name, double price, int prepTime) {
        super(name, price);
        this.prepTime = prepTime;
    }

    public int getPrepTime() {
        return prepTime;
    }

    @Override
    public int getPreparationTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Override
    public String getDescription() {
        return "A coffee beverage.";
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", prepTime=" + prepTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(coffee.price, price) == 0 &&
                prepTime == coffee.prepTime &&
                Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, prepTime);
    }
}
