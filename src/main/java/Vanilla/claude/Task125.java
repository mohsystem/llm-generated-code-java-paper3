package Vanilla.claude;

import java.util.HashMap;
import java.util.Map;

public class Task125 {
    private Map<String, String> resources;
    
    public Task125() {
        resources = new HashMap<>();
        resources.put("doc1", "Document 1 content");
        resources.put("doc2", "Document 2 content");
        resources.put("img1", "Image 1 content");
        resources.put("file1", "File 1 content");
        resources.put("data1", "Data 1 content");
    }
    
    public String accessResource(String resourceId, String userRole) {
        if (resourceId == null || userRole == null) {
            return "Invalid input";
        }
        
        if (!resources.containsKey(resourceId)) {
            return "Resource not found";
        }
        
        switch(userRole.toLowerCase()) {
            case "admin":
                return resources.get(resourceId);
            case "user":
                if (resourceId.startsWith("doc") || resourceId.startsWith("img")) {
                    return resources.get(resourceId);
                }
                return "Access denied";
            case "guest":
                if (resourceId.startsWith("doc")) {
                    return resources.get(resourceId);
                }
                return "Access denied";
            default:
                return "Invalid role";
        }
    }

    public static void main(String[] args) {
        Task125 accessControl = new Task125();
        
        // Test case 1: Admin accessing document
        System.out.println(accessControl.accessResource("doc1", "admin")); // Should return document content
        
        // Test case 2: User accessing image
        System.out.println(accessControl.accessResource("img1", "user")); // Should return image content
        
        // Test case 3: Guest accessing file
        System.out.println(accessControl.accessResource("file1", "guest")); // Should return access denied
        
        // Test case 4: Invalid role
        System.out.println(accessControl.accessResource("doc1", "invalid")); // Should return invalid role
        
        // Test case 5: Resource not found
        System.out.println(accessControl.accessResource("invalid", "admin")); // Should return resource not found
    }
}
