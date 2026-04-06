package com.coffeeshop.model;

public abstract class InventoryItem implements IStockable {
    protected String name;
    protected int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void restock(int amount) {
        this.quantity += amount;
        System.out.println(name + " restocked by " + amount + ". New quantity: " + quantity);
    }

    @Override
    public boolean isInStock(int amount) {
        return quantity >= amount;
    }
}
