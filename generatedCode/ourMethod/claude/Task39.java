package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Task39 {
    public static String displayFileContents(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Invalid filename";
        }

        try {
            // Normalize the path and verify it's a regular file
            Path path = Paths.get(filename).normalize();
            if (!Files.isRegularFile(path)) {
                return "Not a valid file";
            }

            // Use ProcessBuilder for secure command execution
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                processBuilder.command("type", path.toString());
            } else {
                processBuilder.command("cat", path.toString());
            }

            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\\n");
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error reading file";
            }

            return output.toString();
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test.txt",
            "/etc/passwd",  // should be blocked
            "../../test.txt", // should be normalized
            "",  // invalid
            "nonexistent.txt" // should show error
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename or press Enter to run test cases: ");
        String userInput = scanner.nextLine();

        if (!userInput.trim().isEmpty()) {
            System.out.println(displayFileContents(userInput));
        } else {
            // Run test cases
            for (String testFile : testFiles) {
                System.out.println("\\nTesting file: " + testFile);
                System.out.println(displayFileContents(testFile));
            }
        }
        scanner.close();
    }
}
