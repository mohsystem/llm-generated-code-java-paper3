package CoT.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Task158 {
    private static final List<String> ALLOWED_COMMANDS = Arrays.asList("dir", "ls", "pwd", "date");
    
    public static String executeCommand(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "Invalid input: Command cannot be empty";
        }
        
        // Sanitize input - only allow alphanumeric and basic commands
        if (!Pattern.matches("^[a-zA-Z]+$", userInput)) {
            return "Invalid input: Only letters are allowed";
        }
        
        // Check if command is in whitelist
        String sanitizedCommand = userInput.toLowerCase().trim();
        if (!ALLOWED_COMMANDS.contains(sanitizedCommand)) {
            return "Command not allowed. Allowed commands: " + String.join(", ", ALLOWED_COMMANDS);
        }
        
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                processBuilder.command("cmd.exe", "/c", sanitizedCommand);
            } else {
                processBuilder.command("bash", "-c", sanitizedCommand);
            }
            
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\\n");
            }
            
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Command execution failed with exit code: " + exitCode;
            }
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
        
        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "ls",
            "dir",
            "pwd",
            "date",
            "rm" // This should be rejected
        };

        for (String input : testInputs) {
            System.out.println("Test input: " + input);
            System.out.println("Output: " + executeCommand(input));
            System.out.println("------------------------");
        }
    }
}
