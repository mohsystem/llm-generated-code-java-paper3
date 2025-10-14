package ZeroShot.openai;
import java.util.HashMap;
import java.util.Map;

public class Task137 {
    private static Map<Integer, String> productTable;

    static {
        productTable = new HashMap<>();
        productTable.put(1, "Product 1 details");
        productTable.put(2, "Product 2 details");
        productTable.put(3, "Product 3 details");
        productTable.put(4, "Product 4 details");
        productTable.put(5, "Product 5 details");
    }

    public static String getProductDetails(int productId) {
        return productTable.getOrDefault(productId, "Product not found");
    }

    public static void main(String[] args) {
        System.out.println(getProductDetails(1)); // Expected: Product 1 details
        System.out.println(getProductDetails(3)); // Expected: Product 3 details
        System.out.println(getProductDetails(5)); // Expected: Product 5 details
        System.out.println(getProductDetails(7)); // Expected: Product not found
        System.out.println(getProductDetails(2)); // Expected: Product 2 details
    }
}