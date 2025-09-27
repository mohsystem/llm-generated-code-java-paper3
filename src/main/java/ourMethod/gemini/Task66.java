package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {

    public static String executeCommand(String command) {
        if (command == null || command.isEmpty()) {
            return "Error: Command cannot be empty.";
        }
        
        // Basic validation for potentially dangerous characters
        if (command.contains(";") || command.contains("|") || command.contains("&") || command.contains("<") || command.contains(">") || command.contains("`") || command.contains("$")) {
           return "Error: Invalid characters in command.";
        }

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command. Exit code: " + exitCode + "\n" + output.toString();
            }
            return output.toString();
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
                "ls -l",
                "pwd",
                "date",
                "whoami",
                "echo hello"
        };

        for (String testCase : testCases) {
            System.out.println("Executing command: " + testCase);
            String result = executeCommand(testCase);
            System.out.println("Result:\n" + result);
        }


        // Example of invalid command:
        String invalidCommand = "rm -rf /"; // DO NOT RUN THIS
        System.out.println("Executing command: " + invalidCommand); // But it's safe to print it as a string
        String invalidResult = executeCommand(invalidCommand);
        System.out.println("Result:\n" + invalidResult);

        invalidCommand = "ls -l ; rm -rf /"; // DO NOT RUN THIS
        System.out.println("Executing command: " + invalidCommand); // But it's safe to print it as a string
        invalidResult = executeCommand(invalidCommand);
        System.out.println("Result:\n" + invalidResult);


    }
}