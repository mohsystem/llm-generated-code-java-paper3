package ourMethod.openai;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Task137 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static Map<String, String> getProductDetails(String productId) {
        Map<String, String> productDetails = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE product_id = ?")) {

            stmt.setString(1, productId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    productDetails.put("product_id", rs.getString("product_id"));
                    productDetails.put("name", rs.getString("name"));
                    productDetails.put("price", rs.getString("price"));
                    // Add more fields as necessary
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDetails;
    }

    public static void main(String[] args) {
        String[] testProductIds = {"1", "2", "3", "4", "5"};
        for (String productId : testProductIds) {
            System.out.println("Product ID: " + productId + ", Details: " + getProductDetails(productId));
        }
    }
}