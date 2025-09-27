package CoT.codestral;
import java.sql.*;
import java.util.Scanner;

public class Task137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        getProductDetails(productName);
    }

    public static void getProductDetails(String productName) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE name = '" + productName + "'");

            while (resultSet.next()) {
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getString("price"));
                System.out.println("Product Description: " + resultSet.getString("description"));
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}