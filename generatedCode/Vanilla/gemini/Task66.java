package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {

    public static String executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command. Exit code: " + exitCode;
            }
            return output.toString();
        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String[] testCommands = {
                "ls -l",
                "pwd",
                "date",
                "echo hello",
                "cat non_existent_file" // Example of an error case
        };

        for (String command : testCommands) {
            System.out.println("Executing command: " + command);
            String result = executeCommand(command);
            System.out.println("Result:\n" + result);
        }
    }
}