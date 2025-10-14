package ourMethod.openai;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

public class Task70 {

    public static String readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath).normalize();
            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No file path provided.");
            return;
        }
        
        for (String filePath : args) {
            System.out.println("Content of " + filePath + ":");
            System.out.println(readFileContent(filePath));
            System.out.println();
        }
    }
}