package CoT.claude;

import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class Task63 {
    public static JSONObject processRequest(String raw_data) {
        try {
            // Validate input
            if (raw_data == null || raw_data.isEmpty()) {
                throw new IllegalArgumentException("Raw data cannot be null or empty");
            }

            // Convert raw_data to UTF-8 bytes
            byte[] utf8Bytes = raw_data.getBytes(StandardCharsets.UTF_8);
            
            // Base64 decode
            byte[] decodedBytes = Base64.getDecoder().decode(utf8Bytes);
            
            // Convert decoded bytes to string
            String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
            
            // Deserialize JSON
            JSONObject jsonData = new JSONObject(decodedString);
            
            return jsonData;
            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Base64 data: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error processing request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "eyJ0ZXN0IjoiSGVsbG8gV29ybGQifQ==", // {"test":"Hello World"}
            "eyJuYW1lIjoiSm9obiIsImFnZSI6MzB9", // {"name":"John","age":30}
            "eyJjb2xvciI6InJlZCIsInNpemUiOiJsYXJnZSJ9", // {"color":"red","size":"large"}
            "eyJpZCI6MTIzLCJhY3RpdmUiOnRydWV9", // {"id":123,"active":true}
            "eyJpdGVtcyI6WzEsMiwzXSwic3RhdHVzIjoib2sifQ==" // {"items":[1,2,3],"status":"ok"}
        };

        for (int i = 0; i < testCases.length; i++) {
            try {
                System.out.println("Test case " + (i + 1) + ":");
                JSONObject result = processRequest(testCases[i]);
                System.out.println("Result: " + result.toString());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
