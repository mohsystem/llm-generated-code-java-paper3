package ourMethod.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task66 {
    private static final Pattern SAFE_COMMAND_PATTERN = Pattern.compile("^[a-zA-Z0-9\\\\s_\\\\-./]+$");
    
    public static String executeCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return "Error: Empty command";
        }

        // Validate command format
        if (!SAFE_COMMAND_PATTERN.matcher(command).matches()) {
            return "Error: Invalid command format - only alphanumeric characters, spaces, underscore, dash, dot and forward slash allowed";
        }

        StringBuilder output = new StringBuilder();
        Process process = null;
        BufferedReader reader = null;
        
        try {
            // Execute command
            process = new ProcessBuilder("bash", "-c", command)
                .redirectErrorStream(true)
                .start();

            // Read output
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for process to complete
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error: Command execution failed with exit code " + exitCode;
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            try {
                if (reader != null) reader.close();
                if (process != null) process.destroy();
            } catch (Exception e) {
                // Ignore cleanup errors
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "ls -l",
            "pwd",
            "echo hello world",
            "date",
            "whoami"
        };

        for (String test : tests) {
            System.out.println("Executing: " + test);
            System.out.println(executeCommand(test));
            System.out.println("-------------------");
        }
    }
}
