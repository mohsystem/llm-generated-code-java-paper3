package ourMethod.claude;

public class Task125 {
    private static final String[] ALLOWED_RESOURCES = {"file1.txt", "file2.txt", "file3.txt"};

    public static boolean validateAccess(String requestedResource) {
        if (requestedResource == null || requestedResource.trim().isEmpty()) {
            return false;
        }

        // Validate against allowed resources
        for (String resource : ALLOWED_RESOURCES) {
            if (resource.equals(requestedResource)) {
                return true; 
            }
        }
        return false;
    }

    public static String accessResource(String resourceName) {
        if (!validateAccess(resourceName)) {
            return "Access denied";
        }
        return "Accessing resource: " + resourceName;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(accessResource("file1.txt")); // Valid
        System.out.println(accessResource("file2.txt")); // Valid 
        System.out.println(accessResource("file4.txt")); // Invalid
        System.out.println(accessResource("")); // Invalid
        System.out.println(accessResource(null)); // Invalid
    }
}
