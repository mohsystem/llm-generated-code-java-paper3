package Vanilla.claude;

import java.util.Stack;

class Task62 {
    public static String findRootElement(String jsonStr) {
        if (jsonStr == null || jsonStr.trim().isEmpty()) {
            return "";
        }
        
        Stack<String> stack = new Stack<>();
        StringBuilder currentElement = new StringBuilder();
        boolean inQuotes = false;
        
        for (char c : jsonStr.trim().toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
                continue;
            }
            
            if (!inQuotes) {
                if (c == '{' || c == '[') {
                    if (currentElement.length() > 0) {
                        stack.push(currentElement.toString().trim());
                        currentElement.setLength(0);
                    }
                } else if (c == ':' || c == ',' || c == '}' || c == ']') {
                    if (currentElement.length() > 0) {
                        currentElement.setLength(0);
                    }
                } else {
                    currentElement.append(c);
                }
            } else {
                currentElement.append(c);
            }
        }
        
        return stack.isEmpty() ? "" : stack.peek();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "{\\"root\\": {\\"child\\": \\"value\\"}}",
            "{\\"data\\": [1,2,3]}",
            "[]",
            "{}",
            "{\\"firstLevel\\": {\\"secondLevel\\": {\\"thirdLevel\\": \\"value\\"}}}"
        };
        
        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test " + (i+1) + ": " + findRootElement(tests[i]));
        }
    }
}
