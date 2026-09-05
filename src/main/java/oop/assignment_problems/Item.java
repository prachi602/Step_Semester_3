package oop.assignment_problems;

public class Item {

    private String itemName;
    private int stock;

    // Constructor
    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    // Restock method
    public void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public void printStock() {
        System.out.println(
                itemName + " | Final Stock: " + stock
        );
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item("Samosa", 15),
                new Item("Tea Powder", 40),
                new Item("Bread", 8),
                new Item("Biscuit Packs", 25)
        };

        // Restock every item in one pass
        for (Item item : items) {
            item.restock(20);
            item.printStock();
        }
    }
}