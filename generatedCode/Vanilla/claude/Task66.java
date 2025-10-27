package Vanilla.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task66 {
    public static String executeCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return "Invalid command: Command cannot be empty";
        }

        try {
            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            while ((line = errorReader.readLine()) != null) {
                output.append("Error: ").append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                output.append("Command exited with code: ").append(exitCode);
            }
            
            return output.toString().trim();
        } catch (Exception e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCommands = {
            "ls -l",
            "pwd",
            "echo 'Hello World'",
            "date",
            "whoami"
        };

        for (int i = 0; i < testCommands.length; i++) {
            System.out.println("Test case " + (i + 1) + ": " + testCommands[i]);
            System.out.println("Output:");
            System.out.println(executeCommand(testCommands[i]));
            System.out.println("------------------------");
        }
    }
}
