package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task137 {

    private static Map<String, String> productTable = new HashMap<>();

    static {
        productTable.put("101", "Product A: Description of product A");
        productTable.put("102", "Product B: Description of product B");
        productTable.put("103", "Product C: Description of product C");
        productTable.put("104", "Product D: Description of product D");
        productTable.put("105", "Product E: Description of product E");
    }

    public static String getProductDetails(String productId) {
        if (productId == null || !productTable.containsKey(productId)) {
            return "Product not found.";
        }
        return productTable.get(productId);
    }

    public static void main(String[] args) {
        System.out.println(getProductDetails("101")); // Test case 1
        System.out.println(getProductDetails("102")); // Test case 2
        System.out.println(getProductDetails("106")); // Test case 3
        System.out.println(getProductDetails("103")); // Test case 4
        System.out.println(getProductDetails(null));  // Test case 5
    }
}