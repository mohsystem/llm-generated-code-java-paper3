package CoT.llama31;
public class Task125 {
    public static void main(String[] args) {
        // Test cases
        accessResource("admin", "password123", "database");
        accessResource("user", "password123", "file");
        accessResource("guest", "password123", "network");
        accessResource("admin", "wrongpassword", "database");
        accessResource("unknown", "password123", "database");
    }

    public static void accessResource(String username, String password, String resource) {
        // Simulated user database for demonstration
        String[] validUsers = {"admin", "user", "guest"};
        String[] validPasswords = {"password123", "password123", "password123"};
        String[] accessibleResources = {"database", "file", "network"};

        // Security check: Validate user credentials
        boolean isValidUser = false;
        for (int i = 0; i < validUsers.length; i++) {
            if (username.equals(validUsers[i]) && password.equals(validPasswords[i])) {
                isValidUser = true;
                break;
            }
        }

        if (!isValidUser) {
            System.out.println("Invalid username or password.");
            return;
        }

        // Check if the user has access to the requested resource
        boolean hasAccess = false;
        for (String resourceAccess : accessibleResources) {
            if (resource.equals(resourceAccess)) {
                hasAccess = true;
                break;
            }
        }

        if (!hasAccess) {
            System.out.println("You do not have access to this resource.");
            return;
        }

        // Grant access to the resource
        System.out.println("Access granted to " + resource + " for user " + username);
    }
}