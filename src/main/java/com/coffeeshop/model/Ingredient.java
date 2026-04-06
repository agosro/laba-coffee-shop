package com.coffeeshop.model;

public class Ingredient extends InventoryItem {

    public Ingredient(String name, int quantity) {
        super(name, quantity);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
