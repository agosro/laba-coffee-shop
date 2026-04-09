package com.coffeeshop.model;

import com.coffeeshop.exception.InvalidOrderException;
import com.coffeeshop.exception.InvalidPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeeService implements IOrderProcessor {

    private static final Logger LOGGER = LogManager.getLogger(CoffeeService.class);
    private static final String DEFAULT_CURRENCY = "$";

    private String serviceName;
    private String location;

    public CoffeeService(String serviceName, String location) {
        this.serviceName = serviceName;
        this.location = location;
    }

    @Override
    public void processOrder(Order order) throws InvalidOrderException {
        if (order == null || order.getItem() == null) {
            String message = "Order or order item cannot be null.";
            LOGGER.error(message);
            throw new InvalidOrderException(message);
        }

        LOGGER.info("\n================================\n   {}\n   {}\n================================", serviceName, location);
        LOGGER.info("Order ID: {}", order.getOrderId());
        LOGGER.info("Order Date: {}", order.getOrderDate());
        LOGGER.info("Customer: {}", order.getCustomer().getName());
        LOGGER.info("Payment Method: {}", order.getPaymentMethod());
        LOGGER.info("Discount Type: {}", order.getDiscountType());
        LOGGER.info("--------------------------------");

        OrderItem item = order.getItem();
        LOGGER.info("Coffee: {}", item.getCoffee().getName());
        LOGGER.info("Size: {}", item.getSize().getSize());

        if (item.getMilk() != null) {
            LOGGER.info("Milk: {}", item.getMilk().getName());
        }

        if (item.getSyrup() != null) {
            LOGGER.info("Syrup: {}", item.getSyrup().getName());
        }

        LOGGER.info("--------------------------------");
        double subtotal = item.calculatePrice();
        LOGGER.info("Subtotal: {}{}", DEFAULT_CURRENCY, String.format("%.2f", subtotal));
        LOGGER.info("Discount Type: {}", order.getDiscountType());
        if (order.getDiscount() != null) {
            if (order.getDiscount().getType() == DiscountType.PERCENTAGE) {
                LOGGER.info("Discount: {}%", String.format("%.2f", order.getDiscount().getPercentage()));
            } else if (order.getDiscount().getType() == DiscountType.FIXED_AMOUNT) {
                LOGGER.info("Discount: {}{}", DEFAULT_CURRENCY, String.format("%.2f", order.getDiscount().getAmount()));
            }
        }
        LOGGER.info("Total: {}{}", DEFAULT_CURRENCY, String.format("%.2f", order.calculateTotal()));
        LOGGER.info("Estimated Prep Time: {} minutes", order.calculatePrepTime());

        // Loyalty Points Logic - handle errors locally
        int pointsEarned = (int) order.calculateTotal();
        try {
            order.getCustomer().earnPoints(pointsEarned);
        } catch (InvalidPointsException e) {
            // Log already handled in Customer.earnPoints()
        }

        LOGGER.info("================================");
        LOGGER.info("Status: {}", order.getStatus());
        LOGGER.info("================================\n");
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
