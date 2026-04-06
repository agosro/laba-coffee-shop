package com.coffeeshop.model;

public abstract class CoffeeShopAction {
    protected String actionName;

    public CoffeeShopAction(String actionName) {
        this.actionName = actionName;
    }

    public abstract void execute();
}
