package ourMethod.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137 {

    public static String getProductDetails(String productName, Map<String, String> productTable) {
        if (productTable.containsKey(productName)) {
            return productTable.get(productName);
        } else {
            return "Product not found.";
        }
    }

    public static void main(String[] args) {
        Map<String, String> productTable = new HashMap<>();
        productTable.put("Laptop", "Model: XPS 13, Price: $1200");
        productTable.put("Mouse", "Model: MX Master 3, Price: $100");
        productTable.put("Keyboard", "Model: G915, Price: $250");
        productTable.put("Monitor", "Model: U2720Q, Price: $700");
        productTable.put("Webcam", "Model: C920, Price: $60");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String input1 = scanner.nextLine();
        System.out.println(getProductDetails(input1, productTable));


        System.out.print("Enter product name: ");
        String input2 = scanner.nextLine();
        System.out.println(getProductDetails(input2, productTable));



        System.out.print("Enter product name: ");
        String input3 = scanner.nextLine();
        System.out.println(getProductDetails(input3, productTable));



        System.out.print("Enter product name: ");
        String input4 = scanner.nextLine();
        System.out.println(getProductDetails(input4, productTable));


        System.out.print("Enter product name: ");
        String input5 = scanner.nextLine();
        System.out.println(getProductDetails(input5, productTable));

        scanner.close();


    }
}