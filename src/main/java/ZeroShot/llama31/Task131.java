package ZeroShot.llama31;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task131 {
    public static void main(String[] args) {
        // Test cases
        String[] testData = {
            "{\"username\":\"john_doe\",\"userRole\":\"admin\"}",
            "{\"username\":\"malicious\",\"userRole\":\"hacker\"}",
            "{\"username\":\"valid\",\"userRole\":\"user\"}",
            "{\"username\":\"invalid\",\"userRole\":\"invalid\"}",
            "{\"username\":\"test\",\"userRole\":\"test\"}"
        };

        for (String data : testData) {
            try {
                deserializeJSON(data);
            } catch (Exception e) {
                System.out.println("Error deserializing data: " + e.getMessage());
            }
        }
    }

    public static void deserializeJSON(String json) throws Exception {
        // Validate and sanitize input
        if (json == null || json.isEmpty()) {
            throw new Exception("Invalid input data");
        }

        // Use digital signatures or hashing for integrity check (example with hashing)
        String expectedHash = "your_expected_hash_here"; // Replace with actual expected hash
        String actualHash = hash(json);
        if (!actualHash.equals(expectedHash)) {
            throw new Exception("Data integrity check failed");
        }

        //todo cannot find symbol class JsonMapper
        // Deserialize JSON safely
//        com.fasterxml.jackson.databind.JsonNode jsonNode = com.fasterxml.jackson.databind.JsonMapper.builder().build().readTree(json);
//        String username = jsonNode.get("username").asText();
//        String userRole = jsonNode.get("userRole").asText();

//        System.out.println("Deserialized Data: username=" + username + ", userRole=" + userRole);
    }

    private static String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }
}