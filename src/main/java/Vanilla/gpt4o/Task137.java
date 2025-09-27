package Vanilla.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task137 {
    private static Map<String, String> productTable;

    static {
        productTable = new HashMap<>();
        productTable.put("001", "Product 1: Widget A");
        productTable.put("002", "Product 2: Widget B");
        productTable.put("003", "Product 3: Widget C");
        productTable.put("004", "Product 4: Widget D");
        productTable.put("005", "Product 5: Widget E");
    }

    public static String getProductDetails(String productCode) {
        return productTable.getOrDefault(productCode, "Product not found");
    }

    public static void main(String[] args) {
        System.out.println(getProductDetails("001")); // Test case 1
        System.out.println(getProductDetails("002")); // Test case 2
        System.out.println(getProductDetails("003")); // Test case 3
        System.out.println(getProductDetails("006")); // Test case 4
        System.out.println(getProductDetails("005")); // Test case 5
    }
}