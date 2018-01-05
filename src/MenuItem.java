public class MenuItem {

    private String itemName;
    private int category;
    private boolean heartHealthy;
    private double price;

    public MenuItem(String itemName, int category, boolean heartHealthy, double price) {
        this.itemName = itemName;
        this.category = category;
        this.heartHealthy = heartHealthy;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean getHeartHealthy() {
        return heartHealthy;
    }

    public void setHeartHealthy(boolean heartHealthy) {
        this.heartHealthy = heartHealthy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return itemName + " category = " + category + "$" + price;
    }
}




