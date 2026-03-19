public class CoffeeSize {
    private String size;
    private double priceMultiplier;

    public CoffeeSize(double priceMultiplier, String size) {
        this.priceMultiplier = priceMultiplier;
        this.size = size;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
