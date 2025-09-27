package CoT.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the OS command: ");
        String command = reader.readLine();
        System.out.print("Enter the arguments (separated by spaces): ");
        String argsStr = reader.readLine();
        String[] arguments = argsStr.split("\\s+");

        // Validate input to prevent security vulnerabilities
        if (command == null || command.isEmpty() || arguments == null || arguments.length == 0) {
            System.out.println("Invalid input. Please provide a valid command and arguments.");
            return;
        }

        // Construct the full command
        StringBuilder fullCommand = new StringBuilder(command);
        for (String arg : arguments) {
            fullCommand.append(" ").append(arg);
        }

        // Execute the command securely
        try {
            Process process = Runtime.getRuntime().exec(fullCommand.toString());
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);
        } catch (InterruptedException | IOException e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}