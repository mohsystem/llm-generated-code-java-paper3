package CoT.claude;

import java.util.*;

public class Task137 {
    private static Map<Integer, Product> productTable = new HashMap<>();
    
    static class Product {
        private int id;
        private String name;
        private double price;
        
        public Product(int id, String name, double price) {
            this.id = id;
            this.name = validateInput(name);
            this.price = price;
        }
        
        private String validateInput(String input) {
            if(input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid input");
            }
            return input.trim();
        }
        
        @Override
        public String toString() {
            return String.format("Product ID: %d, Name: %s, Price: $%.2f", id, name, price);
        }
    }
    
    public static void initializeProducts() {
        productTable.put(1, new Product(1, "Laptop", 999.99));
        productTable.put(2, new Product(2, "Phone", 599.99));
        productTable.put(3, new Product(3, "Tablet", 299.99));
        productTable.put(4, new Product(4, "Watch", 199.99));
        productTable.put(5, new Product(5, "Headphones", 99.99));
    }
    
    public static Product getProductDetails(int productId) {
        if(productId <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        Product product = productTable.get(productId);
        if(product == null) {
            throw new NoSuchElementException("Product not found");
        }
        return product;
    }
    
    public static void main(String[] args) {
        initializeProducts();
        
        // Test cases
        try {
            // Test case 1: Valid product
            System.out.println(getProductDetails(1));
            
            // Test case 2: Another valid product
            System.out.println(getProductDetails(3));
            
            // Test case 3: Invalid product ID (negative)
            System.out.println(getProductDetails(-1));
            
            // Test case 4: Non-existent product ID
            System.out.println(getProductDetails(10));
            
            // Test case 5: Invalid product ID (zero)
            System.out.println(getProductDetails(0));
            
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
