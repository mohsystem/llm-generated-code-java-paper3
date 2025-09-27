package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a Bash command:");
        String command = reader.readLine();

        // Validate the command (basic validation, you can add more)
        if (command == null || command.isEmpty()) {
            System.out.println("Invalid command");
            return;
        }

        // Execute the command
        try {
            Process process = Runtime.getRuntime().exec(new String[] {"bash", "-c", command});
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Command executed successfully");
            } else {
                System.out.println("Command failed with exit code " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution interrupted");
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}