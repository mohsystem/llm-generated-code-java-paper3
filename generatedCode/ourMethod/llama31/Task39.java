package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the filename: ");
            String filename = reader.readLine();

            // Validate the filename to prevent path traversal attacks
            if (filename.contains("../") || filename.contains("..\") || filename.startsWith("/") || filename.startsWith("\")) {
                System.out.println("Invalid filename. Path traversal attempt detected.");
                return;
            }

            // Use ProcessBuilder to execute the system command securely
            ProcessBuilder processBuilder = new ProcessBuilder("cat", filename);
            Process process = processBuilder.start();

            // Read and print the output
            try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = outputReader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Check the exit value to handle errors
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("Error: Command failed with exit value " + exitValue);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}