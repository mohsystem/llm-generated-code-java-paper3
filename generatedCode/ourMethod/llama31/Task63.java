package ourMethod.llama31;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task63 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "SGVsbG8gd29ybGQh", // Base64 encoded "Hello world!"
            "eyJhbGdvcml0aG0iOiJzdWIiLCJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaGFuIjoiMjMwfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", // Invalid JSON
            "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48cmVzb3VyY2U+PHJlc291cmNlPjwvcmVzb3VyY2U+PC9yZXNvdXJjZT4=", // Valid XML
        };

        for (String testCase : testCases) {
            try {
                Map<String, Object> data = processRequest(testCase);
                System.out.println(data);
            } catch (Exception e) {
                System.out.println("Error processing request: " + e.getMessage());
            }
        }
    }

    public static Map<String, Object> processRequest(String raw_data) throws Exception {
        // Step 1: Ensure raw_data is encoded in UTF-8
        if (raw_data == null || raw_data.isEmpty()) {
            throw new Exception("Raw data is empty or null");
        }

        // Step 2: Decode raw_data using Base64
        byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
        String decodedData = new String(decodedBytes, StandardCharsets.UTF_8);

        // Step 3: Deserialize the decoded data into its original format
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Attempt to deserialize as JSON
            Map<String, Object> jsonData = mapper.readValue(decodedData, Map.class);
            return jsonData;
        } catch (JsonMappingException e) {
            // If JSON deserialization fails, try XML
            try {
                // XML deserialization (simplified example, use a proper XML parser for real applications)
                if (decodedData.startsWith("<") && decodedData.endsWith(">")) {
                    // Basic XML parsing, in real scenarios use an XML parser like JAXB or Jackson
                    Map<String, Object> xmlData = new HashMap<>();
                    xmlData.put("xml", decodedData);
                    return xmlData;
                } else {
                    throw new Exception("Failed to deserialize data: " + e.getMessage());
                }
            } catch (Exception ex) {
                throw new Exception("Failed to deserialize data: " + ex.getMessage());
            }
        }
    }
}