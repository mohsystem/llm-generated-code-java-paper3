package Vanilla.claude;

class Task41 {
    public static String processString(String input) {
        if (input == null || input.length() > 1000) {
            return "Invalid input";
        }
        return input.trim().toLowerCase();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "   TESTING SPACES   ",
            "123!@#$%",
            "", // empty string
            "A".repeat(2000) // very long string
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + processString(test));
            System.out.println();
        }
    }
}
