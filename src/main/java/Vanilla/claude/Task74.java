package Vanilla.claude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection getPostgresConnection(String url, String username, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"jdbc:postgresql://localhost:5432/testdb", "user1", "pass1"},
            {"jdbc:postgresql://192.168.1.1:5432/proddb", "admin", "admin123"},
            {"jdbc:postgresql://localhost:5432/devdb", "dev", "dev123"},
            {"jdbc:postgresql://remotehost:5432/qadb", "qa", "qa123"},
            {"jdbc:postgresql://localhost:5432/stagingdb", "stage", "stage123"}
        };

        for(int i = 0; i < testCases.length; i++) {
            Connection conn = getPostgresConnection(testCases[i][0], testCases[i][1], testCases[i][2]);
            if(conn != null) {
                System.out.println("Test case " + (i+1) + ": Connection successful");
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Test case " + (i+1) + ": Connection failed");
            }
        }
    }
}
