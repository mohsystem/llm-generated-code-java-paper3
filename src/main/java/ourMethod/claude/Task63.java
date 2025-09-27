package ourMethod.claude;

import java.util.Base64;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Task63 {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Object processRequest(String rawData) throws IOException {
        // Input validation
        if (rawData == null || rawData.isEmpty()) {
            throw new IllegalArgumentException("Raw data cannot be null or empty");
        }

        try {
            // Ensure UTF-8 encoding and decode base64
            byte[] decodedBytes = Base64.getDecoder().decode(
                rawData.getBytes(StandardCharsets.UTF_8)
            );

            // Convert decoded bytes to string using UTF-8
            String decodedStr = new String(decodedBytes, StandardCharsets.UTF_8);

            // Deserialize JSON string to object
            Object deserializedData = objectMapper.readValue(decodedStr, Object.class);

            // Validate deserialized data
            if (deserializedData == null) {
                throw new IllegalStateException("Deserialization resulted in null object");
            }

            return deserializedData;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Base64 encoding: " + e.getMessage());
        } catch (IOException e) {
            throw new IOException("Error deserializing data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Valid JSON object
            String test1 = Base64.getEncoder().encodeToString(
                "{\"name\":\"test\",\"value\":123}".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 1 Result: " + processRequest(test1));

            // Test case 2: Valid JSON array 
            String test2 = Base64.getEncoder().encodeToString(
                "[1,2,3,4,5]".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 2 Result: " + processRequest(test2));

            // Test case 3: Valid nested JSON
            String test3 = Base64.getEncoder().encodeToString(
                "{\"obj\":{\"arr\":[1,2,3]}}".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 3 Result: " + processRequest(test3));

            // Test case 4: Empty object
            String test4 = Base64.getEncoder().encodeToString(
                "{}".getBytes(StandardCharsets.UTF_8));
            System.out.println("Test 4 Result: " + processRequest(test4));

            // Test case 5: Invalid input handling
            String test5 = "invalid base64";
            try {
                processRequest(test5);
            } catch (IllegalArgumentException e) {
                System.out.println("Test 5 Result: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
        }
    }
}
