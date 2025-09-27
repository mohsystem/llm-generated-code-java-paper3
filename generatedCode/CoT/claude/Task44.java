package CoT.claude;

public class Task44 {
    public static String processInput(String input) {
        // Input validation
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input: Input cannot be empty";
        }
        
        // Remove any special characters and numbers
        String cleanInput = input.replaceAll("[^a-zA-Z\\\\s]", "");
        
        // Convert to uppercase and reverse the string
        String result = new StringBuilder(cleanInput.toUpperCase()).reverse().toString();
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "Hello World!",
            "Test123@#",
            "",
            null,
            "SecurityCheck456!"
        };
        
        for(String input : testInputs) {
            System.out.println("Input: " + input);
            System.out.println("Output: " + processInput(input));
            System.out.println();
        }
    }
}
