public class OrderItem {

    private Coffee coffee;
    private CoffeeSize size;
    private Milk milk;
    private Syrup syrup;

    public OrderItem(Coffee coffee, CoffeeSize size, Milk milk, Syrup syrup) {
        this.coffee = coffee;
        this.size = size;
        this.milk = milk;
        this.syrup = syrup;
    }

    public double calculatePrice() {
        double basePrice = coffee.getPrice() * size.getPriceMultiplier();
        double milkCost = (milk != null) ? milk.getExtraCost() : 0.0;
        double syrupCost = (syrup != null) ? syrup.getPrice() : 0.0;
        return basePrice + milkCost + syrupCost;
    }

    public int calculatePrepTime() {
        int baseTime = coffee.getPrepTime();
        int milkTime = (milk != null) ? 1 : 0;
        int syrupTime = (syrup != null) ? 1 : 0;
        return baseTime + milkTime + syrupTime;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public Syrup getSyrup() {
        return syrup;
    }

    public void setSyrup(Syrup syrup) {
        this.syrup = syrup;
    }
}
