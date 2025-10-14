package ZeroShot.claude;

import java.util.*;
import java.util.regex.Pattern;

public class Task125 {
    private static final Set<String> ALLOWED_RESOURCES = new HashSet<>(Arrays.asList(
        "document1.txt", "document2.txt", "image1.jpg", "image2.jpg", "data.csv"
    ));
    
    private static final Pattern VALID_RESOURCE_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+$");
    
    public static String accessResource(String username, String resourceName) {
        // Input validation
        if (username == null || username.trim().isEmpty()) {
            return "Error: Invalid username";
        }
        
        if (resourceName == null || resourceName.trim().isEmpty()) {
            return "Error: Invalid resource name";
        }
        
        // Sanitize input - remove whitespace
        resourceName = resourceName.trim();
        
        // Validate resource name format (prevent path traversal)
        if (!VALID_RESOURCE_PATTERN.matcher(resourceName).matches()) {
            return "Error: Invalid resource name format";
        }
        
        // Check for path traversal attempts
        if (resourceName.contains("..") || resourceName.contains("/") || resourceName.contains("\\")) {
            return "Error: Path traversal attempt detected";        }
        // Check if resource is in whitelist
        if (!ALLOWED_RESOURCES.contains(resourceName)) {
            return "Error: Access denied - resource not found or unauthorized";        }
        // Simulate resource access
        return "Success: User '" + username + "' accessed resource '" + resourceName + "'";    }
    public static void main(String[] args) {
        System.out.println("=== Resource Access Control System ===");
        // Test case 1: Valid access
        System.out.println("Test 1 - Valid access:");
        System.out.println(accessResource("john_doe", "document1.txt"));
        System.out.println();
        // Test case 2: Valid access to different resource
         System.out.println("Test 2 - Valid access to image:");
         System.out.println(accessResource("jane_smith", "image1.jpg"));
         System.out.println();
         // Test case 3: Attempt to access non-existent resource
        System.out.println("Test 3 - Non-existent resource:");
        System.out.println(accessResource("user1", "secret.txt"));
        System.out.println();
        // Test case 4: Path traversal attempt
        System.out.println("Test 4 - Path traversal attempt:");
        System.out.println(accessResource("attacker", "../../../etc/passwd"));
        System.out.println();
        // Test case 5: Invalid input
        System.out.println("Test 5 - Invalid input:");
        System.out.println(accessResource("", "document1.txt"));
        System.out.println(accessResource("user2", ""));
        System.out.println();
    }
}
