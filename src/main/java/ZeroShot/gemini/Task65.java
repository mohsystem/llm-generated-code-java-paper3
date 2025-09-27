package ZeroShot.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task65 {

    public static String readFile(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists() || !file.isFile()) {
                return "Error: Invalid filename or file not found.";
            }

            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            return new String(bytes);

        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(readFile("test1.txt"));
        System.out.println(readFile("test2.txt"));
        System.out.println(readFile("invalid.txt"));
        System.out.println(readFile("test/test3.txt"));
        System.out.println(readFile(""));


        try {
            Files.writeString(Paths.get("test1.txt"), "test 1 content");
            Files.writeString(Paths.get("test/test3.txt"), "test 3 content");

            new File("test").mkdir();
            Files.writeString(Paths.get("test/test3.txt"), "test 3 content");
            
        } catch (IOException e) {
            System.err.println("Error creating test files: " + e.getMessage());
        }



    }
}