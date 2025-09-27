package ourMethod.gpt4o;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class Task65 {
    public static String readFile(String filename) {
        try {
            Path filePath = Paths.get(filename);
            return Files.readString(filePath);
        } catch (InvalidPathException | IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(readFile("example1.txt"));
        System.out.println(readFile("example2.txt"));
        System.out.println(readFile("invalid_path.txt"));
        System.out.println(readFile("example3.txt"));
        System.out.println(readFile("example4.txt"));
    }
}