package com.week4.day2.map;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Smartphone", 800.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);
        cart.addProduct("Keyboard", 100.00);
    }

    @Test
    void testAddProduct() {
        cart.addProduct("Tablet", 500.00);
        assertEquals(500.00, cart.getProductPrices().get("Tablet"));
    }

    @Test
    void testAddItemToCart() {
        cart.addItemToCart("Laptop");
        cart.addItemToCart("Mouse");
        Map<String, Double> addedItems = cart.getAddedItems();
        assertEquals(1200.00, addedItems.get("Laptop"));
        assertEquals(50.00, addedItems.get("Mouse"));
    }

    @Test
    void testDisplayCartInOrder() {
        cart.addItemToCart("Laptop");
        cart.addItemToCart("Smartphone");
        cart.addItemToCart("Mouse");
        List<String> expectedOrder = Arrays.asList("Laptop", "Smartphone", "Mouse");
        List<String> actualOrder = new ArrayList<>(cart.getAddedItems().keySet());
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testDisplayCartSortedByPrice() {
        cart.addItemToCart("Laptop");
        cart.addItemToCart("Smartphone");
        cart.addItemToCart("Mouse");
        cart.addItemToCart("Keyboard");

        cart.displayCartSortedByPrice();
        List<String> expectedSortedItems = Arrays.asList("Mouse", "Keyboard", "Smartphone", "Laptop");
        List<String> actualSortedItems = new ArrayList<>(cart.getSortedItemsByPrice().keySet());
        assertEquals(expectedSortedItems, actualSortedItems);
    }

}
