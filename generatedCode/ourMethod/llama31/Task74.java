package ourMethod.llama31;
// Java
public class Task74 {
    // ...
    public static void main(String[] args) {
        // Test cases
        testConnection("localhost", "mydatabase", "myuser", "mypassword");
        testConnection("invalid-host", "mydatabase", "myuser", "mypassword");
        testConnection("localhost", "invalid-database", "myuser", "mypassword");
        testConnection("localhost", "mydatabase", "invalid-user", "mypassword");
        testConnection("localhost", "mydatabase", "myuser", "invalid-password");
    }

    public static void testConnection(String host, String database, String user, String password) {
        try (Connection conn = createPostgresConnection(host, database, user, password)) {
            System.out.println("Connected to the PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}