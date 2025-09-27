package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {

    public static String executeOSCommand(String userInput) {
        try {
            // Sanitize user input to prevent command injection
            String sanitizedInput = userInput.replace("\0", ""); // Remove null bytes

            // Use ProcessBuilder for better security and control
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", sanitizedInput);

            // Redirect error stream to standard output for easier debugging
            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                output.append("Command execution failed with exit code: ").append(exitCode).append(System.lineSeparator());
            }

            return output.toString();

        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
                "echo Hello, world!",
                "dir",
                "whoami",
                "ipconfig",
                "notepad" // Open notepad
        };

        for (String input : testInputs) {
            System.out.println("Executing command: " + input);
            System.out.println(executeOSCommand(input));
            System.out.println("---");
        }
    }
}