package com.week4.day2.map;
import java.util.*;

public class ShoppingCart {
    // HashMap to store product prices
    private Map<String, Double> productPrices;

    // LinkedHashMap to maintain the order of added items
    private Map<String, Double> addedItems;

    // TreeMap to display items sorted by price
    private Map<String, Double> sortedItemsByPrice;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        addedItems = new LinkedHashMap<>();
        sortedItemsByPrice = new TreeMap<>(Comparator.comparing(productPrices::get));
    }

    // Method to add products with their prices
    public void addProduct(String productName, double price)
    {
        productPrices.put(productName, price);
    }

    // Method to add items to the cart
    public void addItemToCart(String productName) {
        if (productPrices.containsKey(productName)) {
            addedItems.put(productName, productPrices.get(productName));
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    // Method to display all available products and their prices
    public void displayAllItems() {
        System.out.println("Available Products:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    // Method to display items in the order they were added
    public void displayCartInOrder() {
        System.out.println("Items in the cart (in order of addition):");
        for (Map.Entry<String, Double> entry : addedItems.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    // Method to display items sorted by price
    public void displayCartSortedByPrice() {
        sortedItemsByPrice.putAll(addedItems);
        System.out.println("Items in the cart (sorted by price):");
        for (Map.Entry<String, Double> entry : sortedItemsByPrice.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }
    // Getter for added items (for testing or external use)
    public Map<String, Double> getAddedItems() {
        return addedItems;
    }

    public Map<String, Double> getSortedItemsByPrice() {
        return sortedItemsByPrice;
    }

    public Map<String, Double> getProductPrices() {
        return productPrices;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to the store
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Smartphone", 800.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);
        cart.addProduct("Keyboard", 100.00);

        // Adding items to the cart
        cart.addItemToCart("Laptop");
        cart.addItemToCart("Mouse");
        cart.addItemToCart("Smartphone");
        cart.addItemToCart("Keyboard");

        // Display all available products
        System.out.println();
        cart.displayAllItems();

        // Display items in the cart in order of addition
        System.out.println();
        cart.displayCartInOrder();

        // Display items in the cart sorted by price
        System.out.println();
        cart.displayCartSortedByPrice();
    }
}

