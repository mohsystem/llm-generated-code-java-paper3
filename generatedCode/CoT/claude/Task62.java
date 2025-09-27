package CoT.claude;

import java.util.*;

public class Task62 {
    public static String findJsonRoot(String jsonStr) {
        if (jsonStr == null || jsonStr.trim().isEmpty()) {
            return "";
        }
        
        // Remove whitespace
        jsonStr = jsonStr.trim();
        
        // Check first character to determine root type
        char firstChar = jsonStr.charAt(0);
        
        if (firstChar == '{') {
            return "object";
        } else if (firstChar == '[') {
            return "array";
        } else if (firstChar == '"') {
            return "string";
        } else if (Character.isDigit(firstChar) || firstChar == '-') {
            return "number";
        } else if (jsonStr.equals("true") || jsonStr.equals("false")) {
            return "boolean";
        } else if (jsonStr.equals("null")) {
            return "null";
        }
        
        return "invalid";
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "{\\"name\\": \\"John\\", \\"age\\": 30}",
            "[1, 2, 3, 4]",
            "\\"Hello World\\"",
            "42",
            "true"
        };
        
        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + findJsonRoot(tests[i]));
        }
    }
}
