public class Inventory {

    private Ingredient ingredient;
    private int minimumStock;
    private String lastRestockDate;

    public Inventory(Ingredient ingredient, int minimumStock, String lastRestockDate) {
        this.ingredient = ingredient;
        this.minimumStock = minimumStock;
        this.lastRestockDate = lastRestockDate;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(String lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }
}
