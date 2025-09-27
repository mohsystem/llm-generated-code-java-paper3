package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task137 {
    private static Map<Integer, Product> productTable = new HashMap<>();

    public static void main(String[] args) {
        // initialize product table
        productTable.put(1, new Product(1, "Product1", 10.0));
        productTable.put(2, new Product(2, "Product2", 20.0));

        // get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id:");
        int productId = scanner.nextInt();

        // query product table
        Product product = productTable.get(productId);
        if (product != null) {
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Price: " + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
//todo constructor Product in class Product cannot be applied to given types;
//required: no arguments
//found:    int,String,double
//reason: actual and formal argument lists differ in length
//constructor Product in class Product cannot be applied to given types;
//required: no arguments
//found:    int,String,double
//reason: actual and formal argument lists differ in length
//cannot find symbol method getProductName()
//cannot find symbol method getPrice()
    static class Product {
        private int productId;
        private String productName;
        private double price;

    public Product(int i, String product1, double v) {
        productId= i;
        productName = product1;
        price = v;
    }

    public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        // constructor, getters and setters here
    }
}