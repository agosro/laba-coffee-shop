public class Order {

    private Customer customer;
    private OrderItem item;
    private String orderDate;
    private String status;

    public Order(Customer customer, String orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = "Pending";
    }

    public double calculateTotal() {
        if (item != null) {
            return item.calculatePrice();
        }
        return 0.0;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
