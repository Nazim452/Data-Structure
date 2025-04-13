package TCS.Array;

import java.util.ArrayList;

class GroceryItem {
    String itemName;
    int quantity;
    double price;

    public GroceryItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

}

public class Grocery {

    public static void main(String[] args) {

        ArrayList<GroceryItem> groceryList = new ArrayList<>();

        // Hardcoded example items
        groceryList.add(new GroceryItem("Apples", 50, 1.20));
        groceryList.add(new GroceryItem("Bananas", 30, 0.75));
        groceryList.add(new GroceryItem("Oranges", 20, 1.10));
        groceryList.add(new GroceryItem("Grapes", 40, 2.50));
        groceryList.add(new GroceryItem("Mangoes", 15, 1.80));

        String highrSellingItem = "";
        int maxQuantity = 0;
        int totalQuanity = 0;

        for (GroceryItem item : groceryList) {
            totalQuanity += item.quantity;

            if (item.quantity > maxQuantity) {
                maxQuantity = item.quantity;
                highrSellingItem = item.itemName;

            }
        }

        double aveargePrice = totalQuanity / groceryList.size();
        // Printing results
        System.out.println("\nAnalysis Results:");
        System.out.println("1. Higher selling item: " + highrSellingItem);
        System.out.println("2. Total quantity sold: " + totalQuanity);
        System.out.printf("3. Average quantity sold: %.2f\n", aveargePrice);

    }

}
