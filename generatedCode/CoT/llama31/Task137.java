package CoT.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137 {
    public static void main(String[] args) {
        // Sample product table
        Map<String, String> productTable = new HashMap<>();
        productTable.put("Product1", "Details of Product1");
        productTable.put("Product2", "Details of Product2");
        productTable.put("Product3", "Details of Product3");

        Scanner scanner = new Scanner(System.in);

        // Test cases
        String[] testCases = {"Product1", "Product2", "Product3", "InvalidProduct", ""};

        for (String testCase : testCases) {
            System.out.println("Enter product name: " + testCase);
            String productDetails = getProductDetails(productTable, testCase);
            System.out.println("Product Details: " + productDetails);
            System.out.println("----------------------------");
        }

        scanner.close();
    }

    public static String getProductDetails(Map<String, String> productTable, String productName) {
        if (productName == null || productName.isEmpty()) {
            return "Product name cannot be empty.";
        }
        return productTable.getOrDefault(productName, "Product not found.");
    }
}