package CoT.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task137 {

    public static String getProductDetails(String productName) {
        String productDetails = null;
        try {
            // Establish database connection (replace with your actual credentials)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
            
            // Prepare statement to prevent SQL injection
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE product_name = ?");
            statement.setString(1, productName);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                productDetails = "Product ID: " + resultSet.getInt("product_id") + "\n" +
                                 "Product Name: " + resultSet.getString("product_name") + "\n" +
                                 "Price: " + resultSet.getDouble("price") + "\n" +
                                 "Description: " + resultSet.getString("description");
            } else {
                productDetails = "Product not found.";
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            productDetails = "Error accessing database: " + e.getMessage();
        }

        return productDetails;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        String details = getProductDetails(productName);
        System.out.println(details);

        // Test Cases
        System.out.println(getProductDetails("Laptop"));
        System.out.println(getProductDetails("Keyboard"));
        System.out.println(getProductDetails("Mouse"));
        System.out.println(getProductDetails("Monitor"));
        System.out.println(getProductDetails("NonExistentProduct")); 
        scanner.close();
    }
}