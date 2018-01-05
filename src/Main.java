import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        Menu eatAtMattsMenu = new Menu();

        eatAtMattsMenu.add("Lobster Dinner", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 24.99);
        eatAtMattsMenu.add("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 3.50);
        eatAtMattsMenu.add("Calamari", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, 10.50);
        eatAtMattsMenu.add("Salad", Menu.APPETIZERS, Menu.HEART_HEALTHY, 7.50);
        eatAtMattsMenu.add("Ice Cream", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 5.00);
        eatAtMattsMenu.add("Veggie Burger", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 17.99);

        String itemName;
        int category;
        boolean heartHealthy;
        double price;

        MenuIterator itr;

        System.out.println("Would you like to view our services?: (yes(0)/no(1))");
        int option = console.nextInt();
        while( option == 0) {
            int choice = menuList(console);

            if(choice == 1){
                itr = eatAtMattsMenu.getItemIterator(Menu.APPETIZERS);
                print("Appetizer", itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 2){
                itr = eatAtMattsMenu.getItemIterator(Menu.MAIN_DISH);
                print("Main Dish", itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 3){
                itr = eatAtMattsMenu.getItemIterator(Menu.DESSERT);
                print("Dessert", itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 4){
                itr = eatAtMattsMenu.getHeartHealthyIterator(Menu.HEART_HEALTHY);
                print("Heart healthy options: ", itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 5){
                System.out.println("View dishes under what price?: ");
                Double checkPrice = console.nextDouble();
                itr = eatAtMattsMenu.getPriceIterator(checkPrice);
                print("Main Dish Prices under: " + checkPrice, itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }
            else if(choice == 6){
                itr = eatAtMattsMenu.getAllItemsIterator();
                print("Here are all options: ", itr);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 7){


                itemName = getString(console);
                category = getRange(console);
                heartHealthy = heartHealthCheck(console);
                price = getPrice(console);
                eatAtMattsMenu.add(itemName, category, heartHealthy, price);
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }

            else if(choice == 8){
                itr = eatAtMattsMenu.getAllItemsIterator();
                MenuItem item;

                while(itr.hasNext()) {
                    item = itr.next();
                    System.out.println(item.getItemName() + " $" + item.getPrice());
                    if(deleteOption(console) == true){
                        System.out.println("Deleted: " + item.getItemName());
                        eatAtMattsMenu.delete(itr);
                    }
                    else {
                        System.out.println("Did not delete: " + item.getItemName());
                    }

                }
                System.out.println("Would you like to view another service?: (yes(0)/no(1))");
                option = console.nextInt();
            }
        }
        System.out.println("Goodbye");

    }

    public static int menuList(Scanner console) {
        System.out.println("Please choose an option: ");
        System.out.println("1 - Display appetizers\n" + "2 - Display main dishes\n" + "3 - Display desserts\n" + "4 - Display heart healthy items\n" +
                "5 - Display main dishes under a specific price\n" + "6 - Display all menu items\n" + "7 - Add menu item\n" + "8 - Remove menu item\n");
        int choice = console.nextInt();
        while (choice < 1 || choice > 8){
            System.out.println("Not valid option: ");
            System.out.println("1 - Display appetizers\n" + "2 - Display main dishes\n" + "3 - Display desserts\n" + "4 - Display heart healthy items\n" +
                    "5 - Display main dishes under a specific price\n" + "6 - Display all menu items\n" + "7 - Add menu item\n" + "8 - Remove menu item\n");
            choice = console.nextInt();
        }
        return choice;
    }


    private static String getString(Scanner console){
        System.out.println("Enter item name");
        String option = console.next();
        return option;
    }

    private static int getRange(Scanner console){
        System.out.println("Enter a Category: 1(Appetizer), 2(Main Dish), 3(Dessert) ");
        int option = console.nextInt();
        while(option < 1 || option > 3){
            System.out.println("Not valid option: ");
            System.out.println("Enter a Category: 1(Appetizer), 2(Main Dish), 3(Dessert) ");
            option = console.nextInt();
        }
        return option;
    }

    private static boolean heartHealthCheck(Scanner console) {
        System.out.println("Is this a heart healthy option: (yes(0)/no(1))");
        int option = console.nextInt();
        if(option == 0){
            return true;
        }
        else {
            return false;
        }
    }

    private static double getPrice(Scanner console){
        System.out.println("What is the price of this item: ");
        Double option = console.nextDouble();
        return option;
    }

    private static boolean deleteOption(Scanner console){
        System.out.println("Would you like to delete this item: (yes(0)/no(1))");
        int option = console.nextInt();
        if(option == 0){
            return true;

        }
        else {
            return false;
        }
    }
    private static void print(String dish, MenuIterator itr) {
        System.out.println(dish);
        MenuItem item;

        while(itr.hasNext()) {
            item = itr.next();
            System.out.println(item.getItemName() + " $" + item.getPrice());
        }
    }

}