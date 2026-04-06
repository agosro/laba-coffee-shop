package com.coffeeshop.model;

import com.coffeeshop.exception.OutOfStockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckStockTask extends CoffeeShopAction {
    private static final Logger LOGGER = LogManager.getLogger(CheckStockTask.class);
    private final Inventory inventory;

    public CheckStockTask(Inventory inventory) {
        super("Check Stock");
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        try {
            inventory.checkLowStock();
        } catch (OutOfStockException e) {
            // Log already handled in Inventory.checkLowStock()
        }
    }
}
