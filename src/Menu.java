public class Menu {

    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;
    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;
    static final int MAX_ITEMS = 20;
    MenuItem[] items;
    int itemCount = 0;

    public Menu() {
        items = new MenuItem[MAX_ITEMS];
    }

    public void add(String itemName, int category, boolean heartHealthy, double price) {
        MenuItem newItem = new MenuItem(itemName, category, heartHealthy, price);
        if(itemCount >= items.length) {
            System.err.println("ERROR: Menu has reached the max amount of items");
        }
        else {
            items[itemCount] = newItem;
            itemCount++;
        }
    }

    public void delete(MenuIterator itr){
        allItemsIterator itemItr = (allItemsIterator) itr;
        int toDelete = itemItr.index - 1;

        for(int i = toDelete; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }

        if(items.length == MAX_ITEMS) {
            items[items.length - 1] = null;
        }

        itemCount--;
    }

    public MenuIterator getAllItemsIterator() {
        return new allItemsIterator();
    }

    public MenuIterator getItemIterator(int category) {
        return new itemIterator(category);
    }

    public MenuIterator getHeartHealthyIterator(boolean healthValue) {
        return new heartHealthyIterator(healthValue);
    }

    public MenuIterator getPriceIterator(double price) {
        return new priceIterator(price);
    }

    private class allItemsIterator implements MenuIterator {
        private int index;

        public boolean hasNext() {
            return !(index >= items.length || items[index] == null);
        }

        public MenuItem next() {
            return items[index++];
        }
    }

    private class itemIterator implements MenuIterator {

        private int index;
        private int category;


        public itemIterator(int category) {
            this.category = category;
        }

        public boolean checkArray() {
            if(items[index].getCategory() == category){
                return true;
            }
            else {
                index++;
                return hasNext();
            }
        }

        public boolean hasNext() {
            return !(index >= items.length || items[index] == null) && checkArray();
        }

        public MenuItem next() {
            return items[index++];
        }
    }

    private class heartHealthyIterator implements MenuIterator {

        private int index;
        private boolean heartHealthy;

        public heartHealthyIterator(boolean heartHealthy) {
            this.heartHealthy = heartHealthy;
        }

        public boolean checkArray() {
            if(items[index].getHeartHealthy() == heartHealthy){
                return true;
            }
            else {
                index++;
                return hasNext();
            }
        }

        public boolean hasNext() {
            return !(index >= items.length || items[index] == null) && checkArray();
        }

        public MenuItem next() {
            return items[index++];
        }
    }

    private class priceIterator implements MenuIterator {

        private int index;
        private double price;

        public priceIterator(double price){
            this.price = price;
        }

        public boolean checkArray() {
            if(items[index].getPrice() <= price){
                return true;
            }
            else {
                index++;
                return hasNext();
            }
        }

        public boolean hasNext() {
            return !(index >= items.length || items[index] == null) && checkArray();
        }


        public MenuItem next() {
            return items[index++];
        }
    }
}
