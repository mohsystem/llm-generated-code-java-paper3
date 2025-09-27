package ZeroShot.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task39 {
    public static String displayFileContents(String filename) {
        StringBuilder output = new StringBuilder();
        try {
            // Using Files.readString instead of system commands for security
            String content = Files.readString(Paths.get(filename));
            output.append(content);
        } catch (Exception e) {
            output.append("Error reading file: ").append(e.getMessage());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "sample.txt",
            "nonexistent.txt",
            "data.txt",
            "empty.txt"
        };

        for (String file : testFiles) {
            System.out.println("Reading file: " + file);
            System.out.println(displayFileContents(file));
            System.out.println("------------------------");
        }
    }
}
