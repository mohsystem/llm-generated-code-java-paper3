package ZeroShot.claude;

class Task125 {
    private static boolean isAuthorized(String username, String role, String resource) {
        // Validate input
        if (username == null || role == null || resource == null ||
            username.isEmpty() || role.isEmpty() || resource.isEmpty()) {
            return false;
        }
        
        // Basic authorization logic
        if (role.equals("admin")) {
            return true;
        } else if (role.equals("user")) {
            return resource.equals("public") || resource.equals("user_data");
        } else if (role.equals("guest")) {
            return resource.equals("public");
        }
        return false;
    }

    private static String accessResource(String username, String role, String resource) {
        if (isAuthorized(username, role, resource)) {
            return "Access granted to " + resource + " for user " + username;
        }
        return "Access denied";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(accessResource("admin1", "admin", "confidential")); // Granted
        System.out.println(accessResource("user1", "user", "public")); // Granted
        System.out.println(accessResource("user2", "user", "admin_panel")); // Denied
        System.out.println(accessResource("guest1", "guest", "public")); // Granted
        System.out.println(accessResource("guest2", "guest", "user_data")); // Denied
    }
}
