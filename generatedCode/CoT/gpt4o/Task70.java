package CoT.openai;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Task70 {
    public static String readFileContent(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String filePath : args) {
                System.out.println("Content of " + filePath + ":");
                System.out.println(readFileContent(filePath));
            }
        } else {
            System.out.println("No file path provided.");
        }
    }
}