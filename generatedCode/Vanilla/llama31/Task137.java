package Vanilla.llama31;
public class Task137 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(getProductDetails("1"));
        System.out.println(getProductDetails("2"));
        System.out.println(getProductDetails("3"));
        System.out.println(getProductDetails("4"));
        System.out.println(getProductDetails("5"));
    }

    public static String getProductDetails(String productId) {
        // Mock product table
        String[] productIds = {"1", "2", "3", "4", "5"};
        String[] productNames = {"Product A", "Product B", "Product C", "Product D", "Product E"};
        String[] productPrices = {"10.99", "9.99", "12.99", "8.99", "11.99"};

        for (int i = 0; i < productIds.length; i++) {
            if (productIds[i].equals(productId)) {
                return "Product ID: " + productId + ", Name: " + productNames[i] + ", Price: " + productPrices[i];
            }
        }

        return "Product not found";
    }
}