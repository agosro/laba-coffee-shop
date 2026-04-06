package com.coffeeshop.model;

public interface IStockable {
    void restock(int amount);
    boolean isInStock(int amount);
}
