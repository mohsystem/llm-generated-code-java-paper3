package CoT.claude;

public class Task125 {
    public static boolean checkResourceAccess(String username, String resource) {
        // Input validation
        if (username == null || resource == null || username.isEmpty() || resource.isEmpty()) {
            return false;
        }

        // Sanitize inputs
        username = username.toLowerCase().trim();
        resource = resource.toLowerCase().trim();

        // Access control mapping
        if (username.equals("admin")) {
            return true; // Admin has access to all resources
        } else if (username.equals("user")) {
            // Regular user can only access public resources
            return resource.equals("public_doc") || resource.equals("shared_folder");
        } else if (username.equals("guest")) {
            // Guest can only access public docs
            return resource.equals("public_doc");
        }
        
        return false; // Default deny access
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(checkResourceAccess("admin", "confidential_doc")); // true
        System.out.println(checkResourceAccess("user", "public_doc")); // true
        System.out.println(checkResourceAccess("user", "confidential_doc")); // false
        System.out.println(checkResourceAccess("guest", "public_doc")); // true
        System.out.println(checkResourceAccess("guest", "shared_folder")); // false
    }
}
