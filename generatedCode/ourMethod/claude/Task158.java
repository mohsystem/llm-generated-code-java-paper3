package ourMethod.claude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Task158 {
    // Pattern to validate input - only allow alphanumeric and basic punctuation
    private static final Pattern SAFE_PATTERN = Pattern.compile("^[a-zA-Z0-9\\\\s._-]+$");
    
    public static String executeCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input: Empty or null command";
        }
        
        // Validate input against safe pattern
        if (!SAFE_PATTERN.matcher(input).matches()) {
            return "Invalid input: Contains unsafe characters";
        }
        
        StringBuilder output = new StringBuilder();
        try {
            // Create safe command array - prevents command injection
            String[] command = new String[]{"dir", input}; // Windows example
            
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }
            
            int exitCode = process.waitFor();
            output.append("Exit Code: ").append(exitCode);
            
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
        
        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "test.txt",
            "documents",
            "../dangerous",
            "file; rm -rf /",
            ""
        };
        
        for (String input : testInputs) {
            System.out.println("\\nTest input: " + input);
            System.out.println("Result: " + executeCommand(input));
        }
    }
}
