package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task36 {
    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        Path normalizedPath = Paths.get(filename).normalize();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(normalizedPath.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\\n");
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "nonexistent.txt",
            "../test2.txt",  // Testing path traversal
            "C:\\\\test3.txt",
            "./test4.txt"
        };
        
        for(String file : testFiles) {
            System.out.println("Reading file: " + file);
            System.out.println(readFile(file));
            System.out.println("------------------------");
        }
    }
}
