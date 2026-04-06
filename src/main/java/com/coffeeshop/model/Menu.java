package com.coffeeshop.model;

import java.util.HashMap;
import java.util.Map;

public class Menu<T extends IMenuItem> {
    private Map<String, T> menuItems = new HashMap<>();

    public void addItem(String name, T item) {
        menuItems.put(name, item);
    }

    public T getItem(String name) {
        return menuItems.get(name);
    }

    public Map<String, T> getMenuItems() {
        return menuItems;
    }
}

