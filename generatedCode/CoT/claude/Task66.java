package CoT.claude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task66 {
    private static final List<String> ALLOWED_COMMANDS = Arrays.asList("ls", "pwd", "date", "whoami", "echo");
    
    public static String executeCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return "Invalid command: Command cannot be empty";
        }

        // Validate command format
        String[] cmdParts = command.trim().split("\\\\s+");
        String baseCmd = cmdParts[0].toLowerCase();
        
        // Security check - only allow specific commands
        if (!ALLOWED_COMMANDS.contains(baseCmd)) {
            return "Command not allowed for security reasons";
        }
        
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(cmdParts);
            Process process = processBuilder.start();
            
            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            // Wait for process to complete and check exit value
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Command execution failed with exit code: " + exitCode;
            }
            
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
        
        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCommands = {
            "ls",
            "pwd",
            "date",
            "whoami",
            "rm -rf /" // should be rejected
        };

        for (String cmd : testCommands) {
            System.out.println("Executing: " + cmd);
            System.out.println("Result: " + executeCommand(cmd));
            System.out.println("------------------------");
        }
    }
}
