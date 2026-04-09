package com.coffeeshop.model;

public class Discount {

    private DiscountType type;
    private double percentage;
    private double amount;

    public Discount(DiscountType type) {
        this.type = type;
    }

    public static Discount none() {
        return new Discount(DiscountType.NONE);
    }

    public static Discount percentage(double percentage) {
        Discount d = new Discount(DiscountType.PERCENTAGE);
        d.setPercentage(percentage);
        return d;
    }

    public static Discount fixedAmount(double amount) {
        Discount d = new Discount(DiscountType.FIXED_AMOUNT);
        d.setAmount(amount);
        return d;
    }

    public DiscountType getType() {
        return type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("percentage must be between 0 and 100");
        }
        this.percentage = percentage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        this.amount = amount;
    }
}

