package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {

    public static String displayFileContent(String filename) throws IOException {
        // Sanitize input
        if (filename == null || filename.isEmpty() || filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            throw new IllegalArgumentException("Invalid filename.");
        }
        StringBuilder content = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("sh", "-c", "cat " + filename);
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String filename : testFiles) {
            try {
                System.out.println("Contents of " + filename + ":");
                System.out.println(displayFileContent(filename));
            } catch (IOException | IllegalArgumentException e) {
                System.out.println("Error reading file " + filename + ": " + e.getMessage());
            }
        }
    }
}