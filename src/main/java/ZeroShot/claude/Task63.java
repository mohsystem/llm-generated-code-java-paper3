package ZeroShot.claude;

import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class Task63 {
    public static Object processRequest(String raw_data) {
        try {
            // Validate input
            if (raw_data == null || raw_data.trim().isEmpty()) {
                throw new IllegalArgumentException("Raw data cannot be null or empty");
            }

            // Convert string to UTF-8 bytes and decode Base64
            byte[] decodedBytes = Base64.getDecoder().decode(raw_data.getBytes(StandardCharsets.UTF_8));
            
            // Convert bytes back to string
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            
            // Deserialize JSON 
            JSONObject jsonData = new JSONObject(decodedString);
            
            return jsonData;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Base64 encoded data");
        } catch (Exception e) {
            throw new RuntimeException("Error processing request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "eyJuYW1lIjoiSm9obiIsImFnZSI6MzB9", // {"name":"John","age":30}
            "eyJpZCI6MSwidGl0bGUiOiJUZXN0In0=", // {"id":1,"title":"Test"}
            "eyJlbWFpbCI6InRlc3RAZXhhbXBsZS5jb20ifQ==", // {"email":"test@example.com"}
            "eyJhY3RpdmUiOnRydWUsInJvbGUiOiJ1c2VyIn0=", // {"active":true,"role":"user"}
            "eyJkYXRhIjpbMSwyLDNdfQ==" // {"data":[1,2,3]}
        };

        for (int i = 0; i < testCases.length; i++) {
            try {
                System.out.println("Test case " + (i + 1) + ":");
                Object result = processRequest(testCases[i]);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
