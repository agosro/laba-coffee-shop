public class Main {

    public static void main(String[] args) {

        Coffee espresso = new Coffee("Espresso", 2.5, 5);
        Coffee latte = new Coffee("Latte", 3.0, 7);

        CoffeeSize small = new CoffeeSize(1.0, "Small");
        CoffeeSize medium = new CoffeeSize(1.2, "Medium");

        Milk almondMilk = new Milk("Almond", 0.5);
        Milk oatMilk = new Milk("Oat", 0.6);

        Syrup vanilla = new Syrup("Vanilla", 0.75);
        Syrup caramel = new Syrup("Caramel", 0.75);

        Customer alice = new Customer("Alice", 1);
        Customer bob = new Customer("Bob", 2);

        Ingredient coffeeBeans = new Ingredient("Coffee Beans", 50);

        Inventory inventory1 = new Inventory(coffeeBeans, 100, "2026-03-10");

        OrderItem item1 = new OrderItem(espresso, medium, almondMilk, vanilla);

        Order order1 = new Order(alice, "2026-03-16");
        order1.setItem(item1);

        CoffeeService service = new CoffeeService("Downtown Coffee", "Main Street");

        service.processOrder(order1);

        service.checkLowStock(inventory1);

        System.out.println("Coffee shop system running.");
    }
}
