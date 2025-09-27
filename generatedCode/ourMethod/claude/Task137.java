package ourMethod.claude;

import java.sql.*;
import java.util.Scanner;

public class Task137 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/productdb";
    private static final String USER = "user";
    private static final String PASS = "password";
    
    public static Product getProductDetails(int productId) throws SQLException {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        
        Product product = null;
        String query = "SELECT * FROM products WHERE product_id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, productId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description")
                    );
                }
            }
        }
        return product;
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Enter product ID (or 0 to exit): ");
                    String input = scanner.nextLine().trim();
                    
                    if (input.isEmpty()) {
                        System.out.println("Input cannot be empty");
                        continue;
                    }
                    
                    int productId = Integer.parseInt(input);
                    if (productId == 0) {
                        break;
                    }
                    
                    Product product = getProductDetails(productId);
                    if (product != null) {
                        System.out.println(product);
                    } else {
                        System.out.println("Product not found");
                    }
                    
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (SQLException e) {
                    System.out.println("Database error occurred");
                }
            }
        }
    }
    
    private static class Product {
        private final int id;
        private final String name;
        private final double price;
        private final String description;
        
        public Product(int id, String name, double price, String description) {
            this.id = id;
            this.name = name != null ? name : "";
            this.price = price;
            this.description = description != null ? description : "";
        }
        
        @Override
        public String toString() {
            return String.format("Product[id=%d, name='%s', price=%.2f, description='%s']",
                id, name, price, description);
        }
    }
}
