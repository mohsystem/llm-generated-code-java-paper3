package CoT.gpt4o;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;

public class Task65 {
    public static String readFile(String filename) {
        try {
            return Files.readString(Paths.get(filename));
        } catch (InvalidPathException | IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(readFile("example1.txt")); // Test case 1
        System.out.println(readFile("example2.txt")); // Test case 2
        System.out.println(readFile("example3.txt")); // Test case 3
        System.out.println(readFile("example4.txt")); // Test case 4
        System.out.println(readFile("example5.txt")); // Test case 5
    }
}