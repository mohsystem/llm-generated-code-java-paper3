package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {
    public static void main(String[] args) {
        displayFileContents("filename.txt");
    }

    public static void displayFileContents(String filename) {
        try {
            // Use a ProcessBuilder to execute the system command
            ProcessBuilder processBuilder = new ProcessBuilder("cat", filename);

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            // Check the exit code
            if (exitCode != 0) {
                System.err.println("Error occurred while reading the file.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}