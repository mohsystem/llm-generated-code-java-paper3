package CoT.claude;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Task66 {
    private static final Set<String> ALLOWED_COMMANDS = new HashSet<>(Arrays.asList(
            "ls", "pwd", "date", "whoami", "echo"
    ));

    private static final int TIMEOUT_SECONDS = 5;
    private static final int MAX_OUTPUT_LENGTH = 10000;

    public static String executeCommand(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "Error: Command cannot be empty";
        }

        userInput = userInput.trim();

        // Validate: no dangerous characters
        if (userInput.contains(";") || userInput.contains("&") ||
                userInput.contains("|") || userInput.contains(">") ||
                userInput.contains("<") || userInput.contains("`") ||
                userInput.contains("$") || userInput.contains("\\") || userInput.contains("\\") || userInput.contains("\\r")) {
            return "Error: Command contains forbidden characters";
        }
        // Parse command and arguments
        String[] parts = userInput.split("\\\\s+");
        String command = parts[0];
        // Whitelist validation
        if (!ALLOWED_COMMANDS.contains(command)) {
            return "Error: Command '" + command + "' is not in the allowed list";
        }
        try {
            ProcessBuilder pb = new ProcessBuilder();
            List<String> cmdList = new ArrayList<>();
            cmdList.addAll(Arrays.asList(parts));
            pb.command(cmdList);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            // Execute with timeout
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(() -> {
                StringBuilder output = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (output.length() + line.length() > MAX_OUTPUT_LENGTH) {
                            return output.toString() + "[Output truncated]";
                        }
                        output.append(line).append("\\");
                    }
                }
                return output.toString();
            });
            String result;
            try {
                result = future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
                process.waitFor(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                process.destroyForcibly();
                future.cancel(true);
                return "Error: Command execution timeout";
            } finally {
                executor.shutdownNow();
            }
            return result.isEmpty() ? "Command executed successfully (no output)" : result;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Secure Command Executor Test Cases ===\\");
        String[] testCases = {"ls", "pwd", "echo Hello World", "ls; rm -rf /",
                // Malicious attempt
                // "cat /etc/passwd"  // Unauthorized command
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + testCases[i]);
            System.out.println("Result: " + executeCommand(testCases[i]));
            System.out.println("---");
        }
    }
}
