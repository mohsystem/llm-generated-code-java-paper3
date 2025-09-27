package ourMethod.claude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task70 {
    public static String readFile(String filePath) throws IOException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        // Normalize and validate path
        Path normalizedPath = Paths.get(filePath).normalize();
        File file = normalizedPath.toFile();

        // Validate file exists and is readable
        if (!file.exists()) {
            throw new IOException("File does not exist: " + filePath);
        }
        if (!file.isFile()) {
            throw new IOException("Path is not a regular file: " + filePath);
        }
        if (!file.canRead()) {
            throw new IOException("File is not readable: " + filePath);
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.err.println("Usage: java Task70 <filepath>");
                System.exit(1);
            }

            String content = readFile(args[0]);
            System.out.println("File content:");
            System.out.println(content);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
