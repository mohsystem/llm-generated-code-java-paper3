package ourMethod.codestral;
// Java

import java.util.HashMap;
import java.util.Map;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Task137 {
    // Predefined product table
    private static Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1, new Product(1, "Product1", 10.0));
        products.put(2, new Product(2, "Product2", 20.0));
        // Add more products as needed
    }

    public static String getProductDetails(Integer productId) {
        // Ensure productId is not null
        if (productId == null) {
            return "Invalid product ID";
        }

        // Search for the product in the product table
        Product product = products.get(productId);
        if (product != null) {
            return "Product ID: " + product.id + ", Name: " + product.name + ", Price: " + product.price;
        }

        return "Product not found";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getProductDetails(1));
        System.out.println(getProductDetails(3));
        System.out.println(getProductDetails(null));
    }
}