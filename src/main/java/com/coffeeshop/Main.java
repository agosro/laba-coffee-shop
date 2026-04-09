package com.coffeeshop;

import com.coffeeshop.exception.InvalidOrderException;
import com.coffeeshop.exception.InvalidPointsException;
import com.coffeeshop.exception.OutOfStockException;
import com.coffeeshop.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Coffee Shop application...");

        CoffeeService coffeeService = new CoffeeService("Laba's Coffee", "123 Java Street");
        Customer customer = new Customer("John Doe", 1);

        // --- Demo 1: Successful Order ---
        LOGGER.info("--- Running Demo 1: Successful Order ---");
        try {
            Coffee espresso = new Coffee("Espresso", 2.50, 2);
            CoffeeSize medium = new CoffeeSize(1.0, "Medium");

            Order order = new Order(customer, "2026-03-26");
            order.setStatus(OrderStatus.NEW);
            order.setPaymentMethod(PaymentMethod.CASH);

            // Apply a real discount to demonstrate DiscountType in the domain
            order.setDiscount(Discount.percentage(10)); // 10% off

            order.setItem(new OrderItem(espresso, medium, null, null));

            coffeeService.processOrder(order);
        } catch (InvalidOrderException e) {
            LOGGER.error("Failed to process order: {}", e.getMessage());
        }

        // --- Demo 2: Low Stock ---
        LOGGER.info("--- Running Demo 2: Low Stock ---");
        try {
            Ingredient coffeeBeans = new Ingredient("Coffee Beans", 5); // Low stock
            Inventory<Ingredient> inventory = new Inventory<>(coffeeBeans, 10, "2026-03-20");
            inventory.checkLowStock();
        } catch (OutOfStockException e) {
            // Log already handled in Inventory.checkLowStock()
        }

        // --- Demo 3: Invalid Points ---
        LOGGER.info("--- Running Demo 3: Invalid Points ---");
        try {
            customer.earnPoints(-10);
        } catch (InvalidPointsException e) {
            // Log already handled in Customer.earnPoints()
        }

        // --- Demo 4: 5 Collections & 3 Generics ---
        LOGGER.info("--- Running Demo 4: Collections & Generics ---");

        // 1. Map (HashMap) inside generic Menu
        Menu<Coffee> coffeeMenu = new Menu<>();
        coffeeMenu.addItem("Espresso", new Coffee("Espresso", 2.50, 2));
        coffeeMenu.addItem("Latte", new Coffee("Latte", 3.50, 3));
        LOGGER.info("Menu Map contains Coffee 'Latte': {}", coffeeMenu.getItem("Latte").getName());

        // 2. List (ArrayList) inside generic OrderHistory
        OrderHistory<Order> orderHistory = new OrderHistory<>();
        Order sampleOrder = new Order(customer, "2026-03-30");
        orderHistory.addOrder(sampleOrder);
        LOGGER.info("Order History List contains {} order(s), first item Date: {}",
                orderHistory.getHistory().size(),
                orderHistory.getHistory().get(0).getOrderDate());

        // 3. Set (HashSet)
        java.util.Set<Customer> uniqueCustomers = new java.util.HashSet<>();
        uniqueCustomers.add(customer);
        uniqueCustomers.add(new Customer("Alice", 2));
        LOGGER.info("HashSet contains unique customers. Count: {}", uniqueCustomers.size());

        // 4. Queue (LinkedList)
        java.util.Queue<Order> orderQueue = new java.util.LinkedList<>();
        orderQueue.add(sampleOrder);
        orderQueue.add(new Order(new Customer("Bob", 3), "2026-03-30"));
        LOGGER.info("Queue (LinkedList) next order to process is from: {}", orderQueue.peek().getCustomer().getName());

        // 5. Set (TreeSet)
        java.util.Set<String> sortedCoffees = new java.util.TreeSet<>();
        sortedCoffees.add("Mocha");
        sortedCoffees.add("Americano");
        sortedCoffees.add("Cappuccino");
        LOGGER.info("Sorted Coffees (TreeSet): {}", sortedCoffees);

        // --- Demo 5: File words counter ---
        LOGGER.info("--- Running Demo 5: File Words Counter ---");
        WordCounter.countWordsInFile("input.txt", "output.txt", "coffee");

        LOGGER.info("Coffee Shop application finished.");
    }

}
