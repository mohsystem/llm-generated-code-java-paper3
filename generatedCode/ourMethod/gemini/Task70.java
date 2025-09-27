package ourMethod.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task70 {

    public static List<String> readFile(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }
        
        // Check for path traversal vulnerability
        if (!filePath.startsWith("/") || filePath.contains("..") || filePath.contains("./")) {
             throw new IllegalArgumentException("Invalid file path.");
        }
        return Files.readAllLines(Paths.get(filePath));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Task70 <file_path>");
            System.exit(1);
        }

        try {
            List<String> content = readFile(args[0]);
            content.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);

        } catch (IllegalArgumentException e) {
            System.err.println("Error : " + e.getMessage());
            System.exit(1);
        }
    }
}