package com.coffeeshop.model;

import com.coffeeshop.exception.InvalidPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Customer extends Person implements ILoyaltyMember {

    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    private int id;
    private int loyaltyPoints;

    public Customer(String name, int id) {
        super(name);
        this.id = id;
        this.loyaltyPoints = 0;
        LOGGER.info("Customer created: {} with ID: {}", name, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void earnPoints(int points) throws InvalidPointsException {
        if (points < 0) {
            LOGGER.error("Attempted to add negative points: {}", points);
            throw new InvalidPointsException("Points to be earned cannot be negative.");
        }
        this.loyaltyPoints += points;
        LOGGER.info("{} earned {} points. Total points: {}", name, points, loyaltyPoints);
    }

    @Override
    public int getPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + loyaltyPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
