package CoT.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task65 {

    public static String readFileData(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return "Error: File does not exist.";
            }
            if (!file.isFile()) {
                return "Error: Not a regular file.";
            }
            if (!file.canRead()) {
                return "Error: File cannot be read (permissions issue?).";
            }

            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            return new String(bytes);


        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(readFileData("test.txt"));
        System.out.println(readFileData("nonexistent.txt"));
        System.out.println(readFileData("./")); 
        System.out.println(readFileData("/etc/passwd")); // Example - check permissions
        System.out.println(readFileData("test_long_filename_that_might_cause_issues.txt"));

    }
}