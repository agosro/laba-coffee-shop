public class Milk {

    private String type;
    private double extraCost;

    public Milk(String type, double extraCost) {
        this.type = type;
        this.extraCost = extraCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }
}
