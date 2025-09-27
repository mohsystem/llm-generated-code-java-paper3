package ZeroShot.claude;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task158 {
    public static String executeCommand(String userInput) {
        // Whitelist of allowed commands
        List<String> allowedCommands = Arrays.asList("date", "time", "pwd", "whoami");
        
        // Sanitize input: remove any special characters and whitespace
        String sanitizedInput = userInput.trim().toLowerCase()
                                       .replaceAll("[^a-zA-Z]", "");
        
        // Validate against whitelist
        if (!allowedCommands.contains(sanitizedInput)) {
            return "Error: Command not allowed";
        }
        
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(sanitizedInput);
            Process process = processBuilder.start();
            
            // Read the output
            java.util.Scanner s = new java.util.Scanner(process.getInputStream())
                                        .useDelimiter("\\\\A");
            String result = s.hasNext() ? s.next() : "";
            
            process.waitFor();
            return result;
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "date",
            "pwd",
            "rm -rf /",  // malicious command
            "whoami; rm -rf /",  // command injection attempt
            "; destructive_command"  // another injection attempt
        };

        for (String input : testInputs) {
            System.out.println("Input: " + input);
            System.out.println("Output: " + executeCommand(input));
            System.out.println();
        }
    }
}
