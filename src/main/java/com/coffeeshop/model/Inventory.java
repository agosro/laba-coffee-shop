package com.coffeeshop.model;

import com.coffeeshop.exception.OutOfStockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Inventory<T extends InventoryItem> {

    private static final Logger LOGGER = LogManager.getLogger(Inventory.class);

    private T ingredient;
    private int minimumStock;
    private String lastRestockDate;

    public Inventory(T ingredient, int minimumStock, String lastRestockDate) {
        this.ingredient = ingredient;
        this.minimumStock = minimumStock;
        this.lastRestockDate = lastRestockDate;
    }

    public void checkLowStock() throws OutOfStockException {
        if (ingredient.getQuantity() < minimumStock) {
            String message = String.format("Low Stock Alert for %s! Current: %d, Minimum: %d",
                    ingredient.getName(),
                    ingredient.getQuantity(),
                    minimumStock);
            LOGGER.warn(message);
            throw new OutOfStockException(message);
        }
    }

    public T getIngredient() {
        return ingredient;
    }

    public void setIngredient(T ingredient) {
        this.ingredient = ingredient;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(String lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "ingredient=" + ingredient +
                ", minimumStock=" + minimumStock +
                ", lastRestockDate='" + lastRestockDate + '\'' +
                '}';
    }
}
