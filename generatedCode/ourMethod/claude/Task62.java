package ourMethod.claude;

import org.json.JSONObject;
import org.json.JSONException;

public class Task62 {
    public static JSONObject parseAndGetRoot(String jsonStr) {
        if (jsonStr == null || jsonStr.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON string cannot be null or empty");
        }
        
        try {
            JSONObject root = new JSONObject(jsonStr);
            return root;
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON format: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "{\\"name\\":\\"John\\", \\"age\\":30}",
            "{\\"employees\\":[{\\"name\\":\\"Tom\\", \\"age\\":25},{\\"name\\":\\"Jane\\", \\"age\\":28}]}",
            "{}",
            "{\\"nested\\":{\\"key\\":\\"value\\"}}",
            "{\\"array\\":[1,2,3,4,5]}"
        };

        for (int i = 0; i < testCases.length; i++) {
            try {
                System.out.println("Test case " + (i + 1) + ":");
                JSONObject root = parseAndGetRoot(testCases[i]);
                System.out.println("Root element: " + root.toString());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
