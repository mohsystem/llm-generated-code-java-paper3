package CoT.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task70 {

    public static String readFile(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }
        // Canonicalize the path to prevent path traversal vulnerabilities
        String canonicalPath = Paths.get(filePath).toRealPath().toString();


        return new String(Files.readAllBytes(Paths.get(canonicalPath)));
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Please provide a file path as a command-line argument.");
                System.exit(1);
            }

            String filePath = args[0];
            String fileContent = readFile(filePath);
            System.out.println(fileContent);

             // Test cases (demonstration - these would ideally be more robust)
            System.out.println(readFile("test1.txt")); // Assumes test1.txt exists
            System.out.println(readFile("test2.txt")); // Assumes test2.txt exists
            System.out.println(readFile("test3.txt")); // Assumes test3.txt exists
            System.out.println(readFile("test4.txt")); // Assumes test4.txt exists
            System.out.println(readFile("test5.txt")); // Assumes test5.txt exists


        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


    }
}