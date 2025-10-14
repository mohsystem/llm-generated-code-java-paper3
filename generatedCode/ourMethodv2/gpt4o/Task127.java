package ourMethodv2.gpt4o;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.security.*;
import java.util.*;

public class Task127 {

    public static void readFileAndWriteToTemp(String sourceFilePath, String tempFilePath) {
        try {
            // Check if file exists and is not a directory
            Path path = Paths.get(sourceFilePath);
            if (Files.exists(path) && !Files.isDirectory(path)) {
                // Read content from the source file
                List<String> content = Files.readAllLines(path);

                // Write content to the temporary file
                Files.write(Paths.get(tempFilePath), content);
                System.out.println("File successfully written to " + tempFilePath);
            } else {
                System.out.println("Source file does not exist or is a directory.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        readFileAndWriteToTemp("source1.txt", "temp1.txt");
        readFileAndWriteToTemp("source2.txt", "temp2.txt");
        readFileAndWriteToTemp("source3.txt", "temp3.txt");
        readFileAndWriteToTemp("source4.txt", "temp4.txt");
        readFileAndWriteToTemp("source5.txt", "temp5.txt");
    }
}