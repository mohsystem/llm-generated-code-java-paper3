package ZeroShot.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137 {

    private static final Map<String, Product> productTable = new HashMap<>();

    static {
        // Initialize product table (replace with your actual product data)
        productTable.put("A123", new Product("A123", "Product A", 10.99));
        productTable.put("B456", new Product("B456", "Product B", 25.50));
        productTable.put("C789", new Product("C789", "Product C", 5.75));
    }

    public static Product getProductDetails(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            return null; // Or throw an exception for invalid input
        }
        return productTable.get(productId);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID:");
        String productId = scanner.nextLine();

        Product product = getProductDetails(productId);

        if (product != null) {
            System.out.println("Product Details:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }

        // Test cases
        System.out.println(getProductDetails("A123"));
        System.out.println(getProductDetails("B456"));
        System.out.println(getProductDetails("C789"));
        System.out.println(getProductDetails("InvalidID"));
        System.out.println(getProductDetails(""));

        scanner.close();

    }


    private static class Product {
        private String id;
        private String name;
        private double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}