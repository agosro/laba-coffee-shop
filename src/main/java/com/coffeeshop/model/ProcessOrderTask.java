package com.coffeeshop.model;

import com.coffeeshop.exception.InvalidOrderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessOrderTask extends CoffeeShopAction {
    private static final Logger LOGGER = LogManager.getLogger(ProcessOrderTask.class);
    private final CoffeeService service;
    private final Order order;

    public ProcessOrderTask(CoffeeService service, Order order) {
        super("Process Order");
        this.service = service;
        this.order = order;
    }

    @Override
    public void execute() {
        try {
            service.processOrder(order);
        } catch (InvalidOrderException e) {
            LOGGER.error("Failed to process order: {}", e.getMessage());
        }
    }
}
