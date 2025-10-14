package ZeroShot.claude;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Task66 {
    private static final Set<String> ALLOWED_COMMANDS = new HashSet<>(Arrays.asList(
            "ls", "pwd", "date", "whoami", "echo"
    ));

    private static final Pattern DANGEROUS_PATTERN = Pattern.compile(
            ".*[;&|`$(){}\\\\[\\\\]<>].*|.*\\\\.\\\\..*"
    );

    public static String executeCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return "Error: Command cannot be empty";
        }

        command = command.trim();

        // Check for dangerous characters
        if (DANGEROUS_PATTERN.matcher(command).matches()) {
            return "Error: Command contains dangerous characters";
        }

        // Parse command
        String[] parts = command.split("\\\\s+");
        String baseCommand = parts[0];

        // Validate against whitelist
        if (!ALLOWED_COMMANDS.contains(baseCommand)) {
            return "Error: Command not allowed. Allowed commands: " + ALLOWED_COMMANDS;
        }

        // Validate arguments
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].contains("/") || parts[i].contains("\\")) {
                return "Error: Path traversal not allowed in arguments";
            }
        }
        // Execute command
        try {
            ProcessBuilder pb = new ProcessBuilder(parts);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("");
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error: Command exited with code " + exitCode + "" + output.toString();
            }
            return output.toString().trim();
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1: Valid command 'pwd' ===");
        System.out.println(executeCommand("pwd"));
        System.out.println();
        System.out.println("=== Test Case 2: Valid command 'date' ===");
        System.out.println(executeCommand("date"));
        System.out.println();
        System.out.println("=== Test Case 3: Valid command 'echo' with arguments ===");
        System.out.println(executeCommand("echo Hello World"));
        System.out.println();
        System.out.println("=== Test Case 4: Invalid command with dangerous characters ===");
        System.out.println(executeCommand("ls; rm -rf /"));
        System.out.println();
        System.out.println("=== Test Case 5: Unauthorized command ===");
        System.out.println(executeCommand("rm testfile.txt"));
        System.out.println();
    }
}
