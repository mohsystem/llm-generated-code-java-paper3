package ourMethod.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task65 {

    public static List<String> readFile(String filename) {
        try {
            Path filePath = Paths.get(filename);
            if (Files.exists(filePath) && Files.isRegularFile(filePath) && Files.isReadable(filePath)) {
                return Files.readAllLines(filePath);
            } else {
                System.err.println("Error: Invalid or inaccessible file: " + filename);
                return null;
            }
        } catch (InvalidPathException | NoSuchFileException e) {
            System.err.println("Error: Invalid file path: " + e.getMessage());
            return null;

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {
        // Test cases
        List<String> result1 = readFile("test.txt");
        if (result1 != null) {
            System.out.println("Test case 1:");
            result1.forEach(System.out::println);
        }


        List<String> result2 = readFile("nonexistent.txt");
        if (result2 != null) {
            System.out.println("Test case 2:");
            result2.forEach(System.out::println);
        }



        List<String> result3 = readFile("../test.txt");
        if (result3 != null) {
            System.out.println("Test case 3:");
            result3.forEach(System.out::println);
        }

        List<String> result4 = readFile("test/../test.txt");
         if (result4 != null) {
            System.out.println("Test case 4:");
            result4.forEach(System.out::println);
        }
        
        List<String> result5 = readFile("....//test.txt");
         if (result5 != null) {
            System.out.println("Test case 5:");
            result5.forEach(System.out::println);
        }

    }
}