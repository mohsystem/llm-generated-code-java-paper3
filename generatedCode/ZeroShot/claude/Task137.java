package ZeroShot.claude;

import java.sql.*;
import java.util.Scanner;

public class Task137 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/products_db";
    private static final String USER = "user"; 
    private static final String PASS = "password";
    
    public static String getProductDetails(int productId) {
        String result = "";
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM products WHERE product_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                result = "Product ID: " + rs.getInt("product_id") + 
                        ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price");
            } else {
                result = "Product not found";
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch(SQLException e) {
            result = "Database error: " + e.getMessage();
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getProductDetails(1));  // Assuming product exists
        System.out.println(getProductDetails(2));  // Assuming product exists
        System.out.println(getProductDetails(3));  // Assuming product exists
        System.out.println(getProductDetails(-1)); // Invalid product id
        System.out.println(getProductDetails(999)); // Non-existent product
    }
}
