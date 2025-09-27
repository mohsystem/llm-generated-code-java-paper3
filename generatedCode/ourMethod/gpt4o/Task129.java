package ourMethod.gpt4o;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.io.IOException;

public class Task129 {

    public static String retrieveFile(String fileName) {
        if (!fileName.matches("[a-zA-Z0-9_.-]+")) {
            return "Invalid file name.";
        }
        Path filePath = Paths.get("server_directory", fileName);
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            return "File not found.";
        }
        try {
            return Files.readString(filePath, StandardOpenOption.READ);
        } catch (IOException e) {
            return "Error reading file.";
        }
    }

    public static void main(String[] args) {
        System.out.println(retrieveFile("testfile1.txt"));  // Example Test Case 1
        System.out.println(retrieveFile("testfile2.txt"));  // Example Test Case 2
        System.out.println(retrieveFile("../testfile3.txt")); // Example Test Case 3 (Invalid)
        System.out.println(retrieveFile("valid-file_name.txt")); // Example Test Case 4
        System.out.println(retrieveFile("testfile5.exe")); // Example Test Case 5
    }
}