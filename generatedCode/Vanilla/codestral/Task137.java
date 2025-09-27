package Vanilla.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task137 {
    private static Map<String, String> productTable = new HashMap<String, String>() {{
        put("Apple", "A red fruit");
        put("Banana", "A yellow fruit");
        // Add more products as needed
    }};

    public static String getProductDetails(String productName) {
        return productTable.getOrDefault(productName, "Product not found");
    }

    public static void main(String[] args) {
        System.out.println(getProductDetails("Apple"));
        System.out.println(getProductDetails("Banana"));
        System.out.println(getProductDetails("Orange"));
    }
}