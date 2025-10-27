package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Task66 {
    public static String executeCommand(String command) {
        if (!isValidCommand(command)) {
            return "Invalid command format";
        }
        
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            // Only allow certain safe commands
            if (command.startsWith("ls") || command.startsWith("pwd") || command.startsWith("whoami") || command.startsWith("date")) {
                processBuilder.command("bash", "-c", command);
                Process process = processBuilder.start();
                
                StringBuilder output = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    return "Command execution failed";
                }
                
                return output.toString();
            } else {
                return "Command not allowed for security reasons";
            }
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
    }
    
    private static boolean isValidCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return false;
        }
        // Only allow alphanumeric characters, spaces, and basic command symbols
        return Pattern.matches("^[a-zA-Z0-9\\\\s\\\\-_./]*$", command);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCommands = {
            "ls -l",
            "pwd",
            "whoami",
            "date",
            "rm -rf /" // Should be rejected
        };
        
        for (String cmd : testCommands) {
            System.out.println("Executing: " + cmd);
            System.out.println("Result:\\n" + executeCommand(cmd));
            System.out.println("------------------------");
        }
    }
}
