package Vanilla.claude;

import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class Task63 {
    public static Object processRequest(String raw_data) {
        try {
            // Ensure UTF-8 encoding
            byte[] encodedBytes = raw_data.getBytes(StandardCharsets.UTF_8);
            
            // Base64 decode
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            
            // Convert to string
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            
            // Deserialize JSON 
            JSONObject deserializedData = new JSONObject(decodedString);
            
            return deserializedData;
            
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "eyJuYW1lIjoiSm9obiIsImFnZSI6MzB9", // {"name":"John","age":30}
            "eyJpZCI6MSwidGl0bGUiOiJUZXN0In0=", // {"id":1,"title":"Test"}
            "eyJlbWFpbCI6InRlc3RAZXhhbXBsZS5jb20ifQ==", // {"email":"test@example.com"}
            "eyJhY3RpdmUiOnRydWUsInJvbGUiOiJ1c2VyIn0=", // {"active":true,"role":"user"}
            "eyJzY29yZSI6OTUsImdyYWRlIjoiQSJ9" // {"score":95,"grade":"A"}
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i+1) + ":");
            System.out.println("Input: " + testCases[i]);
            System.out.println("Output: " + processRequest(testCases[i]));
            System.out.println();
        }
    }
}
