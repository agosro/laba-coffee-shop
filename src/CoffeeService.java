public class CoffeeService {

    private String serviceName;
    private String location;

    public CoffeeService(String serviceName, String location) {
        this.serviceName = serviceName;
        this.location = location;
    }

    public void processOrder(Order order) {
        System.out.println("\n================================");
        System.out.println("   " + serviceName);
        System.out.println("   " + location);
        System.out.println("================================");
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("--------------------------------");

        if (order.getItem() != null) {
            OrderItem item = order.getItem();
            System.out.println("Coffee: " + item.getCoffee().getName());
            System.out.println("Size: " + item.getSize().getSize());

            if (item.getMilk() != null) {
                System.out.println("Milk: " + item.getMilk().getType());
            }

            if (item.getSyrup() != null) {
                System.out.println("Syrup: " + item.getSyrup().getFlavor());
            }

            System.out.println("--------------------------------");
            System.out.printf("Total: $%.2f%n", order.calculateTotal());
            System.out.println("Estimated Prep Time: " + order.calculatePrepTime() + " minutes");
        }

        System.out.println("================================");
        System.out.println("Status: " + order.getStatus());
        System.out.println("================================\n");
    }

    public void checkLowStock(Inventory inventory) {
        if (inventory.getIngredient().getQuantity() < inventory.getMinimumStock()) {
            System.out.println("\nLow Stock Alert!");
            System.out.println("Ingredient: " + inventory.getIngredient().getName());
            System.out.println("Current Stock: " + inventory.getIngredient().getQuantity());
            System.out.println("Minimum Required: " + inventory.getMinimumStock());
            System.out.println("Please restock soon!");
            System.out.println("=====================================\n");
        }
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

