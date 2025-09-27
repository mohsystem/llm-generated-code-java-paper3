package ourMethod.llama31;
public class Task137 {
    public static void main(String[] args) {
        // Sample product table
        Product[] products = {
            new Product("1", "Product A", 10.99),
            new Product("2", "Product B", 9.99),
            new Product("3", "Product C", 12.99)
        };

        // Test cases
        String[] testCases = {"1", "2", "3", "4", "invalid"};

        for (String testCase : testCases) {
            Product product = getProductDetails(products, testCase);
            if (product != null) {
                System.out.println("Product ID: " + product.id);
                System.out.println("Product Name: " + product.name);
                System.out.println("Product Price: $" + product.price);
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    public static Product getProductDetails(Product[] products, String productId) {
        // Secure coding practice: Avoid null pointer exceptions
        if (products == null || productId == null) {
            return null;
        }

        // Iterate through the product table
        for (Product product : products) {
            if (product.id.equals(productId)) {
                return product;
            }
        }

        return null;
    }

    public static class Product {
        public String id;
        public String name;
        public double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}