package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task65 {

    public static String readFile(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Invalid filename.";
        }
        
        try {
            if (!Files.exists(Paths.get(filename))) {
                return "File does not exist.";
            }

            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            return content.toString();
        } catch (IOException e) {
            return "An error occurred while reading the file.";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(readFile("test1.txt"));
        System.out.println(readFile("test2.txt"));
        System.out.println(readFile("nonexistent.txt"));
        System.out.println(readFile(""));
        System.out.println(readFile(null));
    }
}