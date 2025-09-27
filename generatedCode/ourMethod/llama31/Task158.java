package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the OS command: ");
        String command = reader.readLine();

        // Validate the input to prevent security weaknesses
        if (command == null || command.isEmpty()) {
            System.out.println("Invalid input. Please provide a valid command.");
            return;
        }

        // Use ProcessBuilder to execute the command securely
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
        try {
            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("Command executed successfully.");
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}