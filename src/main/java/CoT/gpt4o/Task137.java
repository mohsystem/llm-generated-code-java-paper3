package CoT.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task137 {

    static class Product {
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + "}";
        }
    }

    private static final Map<String, Product> productTable = new HashMap<>();

    static {
        productTable.put("P001", new Product("Laptop", 1500.0));
        productTable.put("P002", new Product("Smartphone", 800.0));
        productTable.put("P003", new Product("Headphones", 150.0));
        productTable.put("P004", new Product("Monitor", 300.0));
        productTable.put("P005", new Product("Keyboard", 100.0));
    }

    public static Product inquireProduct(String productId) {
        return productTable.get(productId);
    }

    public static void main(String[] args) {
        String[] testCases = {"P001", "P002", "P003", "P006", "P005"};
        for (String testCase : testCases) {
            Product product = inquireProduct(testCase);
            if (product != null) {
                System.out.println("Found: " + product);
            } else {
                System.out.println("Product ID " + testCase + " not found.");
            }
        }
    }
}