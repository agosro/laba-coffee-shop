package com.coffeeshop.model;

public class Order {

    private static int orderCounter = 0;
    private final int orderId;
    private Customer customer;
    private OrderItem item;
    private String orderDate;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private DiscountType discountType;
    private Discount discount;

    public Order(Customer customer, String orderDate) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = OrderStatus.NEW;
        this.paymentMethod = PaymentMethod.CASH;
        this.discount = Discount.none();
        this.discountType = discount.getType();
    }

    public double calculateTotal() {
        if (item == null) {
            return 0.0;
        }

        double subtotal = item.calculatePrice();
        if (discount == null || discount.getType() == null) {
            return subtotal;
        }

        double total;
        switch (discount.getType()) {
            case PERCENTAGE -> {
                double pct = discount.getPercentage();
                total = subtotal * (1.0 - (pct / 100.0));
            }
            case FIXED_AMOUNT -> {
                total = subtotal - discount.getAmount();
            }
            case NONE -> total = subtotal;
            default -> total = subtotal;
        }

        return Math.max(0.0, total);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderDate='" + orderDate + '\'' +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                ", discountType=" + discountType +
                ", discount=" + (discount != null ? discount.getType() : null) +
                '}';
    }

    public int calculatePrepTime() {
        if (item != null) {
            return item.calculatePrepTime();
        }
        return 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;

        if (discountType == null) {
            this.discount = Discount.none();
            this.discountType = this.discount.getType();
            return;
        }

        switch (discountType) {
            case NONE -> this.discount = Discount.none();
            case PERCENTAGE -> this.discount = (this.discount != null && this.discount.getType() == DiscountType.PERCENTAGE)
                    ? this.discount
                    : Discount.percentage(0);
            case FIXED_AMOUNT -> this.discount = (this.discount != null && this.discount.getType() == DiscountType.FIXED_AMOUNT)
                    ? this.discount
                    : Discount.fixedAmount(0);
        }
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
        this.discountType = (discount != null ? discount.getType() : null);
    }

    public int getOrderId() {
        return orderId;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }
}
