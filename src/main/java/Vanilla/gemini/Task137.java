package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137 {

    public static String getProductDetails(String productName, Map<String, String> productTable) {
        return productTable.getOrDefault(productName, "Product not found");
    }

    public static void main(String[] args) {
        Map<String, String> productTable = new HashMap<>();
        productTable.put("Laptop", "Price: $1200, RAM: 16GB, Storage: 1TB SSD");
        productTable.put("Mouse", "Price: $25, Wireless, Optical");
        productTable.put("Keyboard", "Price: $75, Mechanical, RGB");
        productTable.put("Monitor", "Price: $300, 27-inch, 144Hz");
        productTable.put("Webcam", "Price: $50, 1080p, Built-in microphone");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name:");
        String productName1 = scanner.nextLine();
        System.out.println(getProductDetails(productName1, productTable));

        System.out.println("Enter product name:");
        String productName2 = scanner.nextLine();
        System.out.println(getProductDetails(productName2, productTable));

        System.out.println("Enter product name:");
        String productName3 = scanner.nextLine();
        System.out.println(getProductDetails(productName3, productTable));

        System.out.println("Enter product name:");
        String productName4 = scanner.nextLine();
        System.out.println(getProductDetails(productName4, productTable));

        System.out.println("Enter product name:");
        String productName5 = scanner.nextLine();
        System.out.println(getProductDetails(productName5, productTable));


        scanner.close();

    }
}