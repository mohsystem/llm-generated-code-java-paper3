package Vanilla.claude;

import java.util.*;

class Product {
    int id;
    String name;
    double price;
    
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Task137 {
    private static Map<Integer, Product> productTable = new HashMap<>();
    
    public static Product getProductDetails(int productId) {
        return productTable.get(productId);
    }
    
    public static void addProduct(int id, String name, double price) {
        productTable.put(id, new Product(id, name, price));
    }
    
    public static void main(String[] args) {
        // Initialize product table with sample data
        addProduct(1, "Laptop", 999.99);
        addProduct(2, "Phone", 599.99);
        addProduct(3, "Tablet", 299.99);
        addProduct(4, "Watch", 199.99);
        addProduct(5, "Headphones", 99.99);
        
        // Test cases
        int[] testIds = {1, 2, 3, 4, 5};
        
        for(int id : testIds) {
            Product product = getProductDetails(id);
            if(product != null) {
                System.out.println("Product ID: " + product.id);
                System.out.println("Name: " + product.name);
                System.out.println("Price: $" + product.price);
                System.out.println("---------------");
            }
        }
    }
}
