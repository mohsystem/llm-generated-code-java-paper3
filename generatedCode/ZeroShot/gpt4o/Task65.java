package ZeroShot.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Task65 {
    public static String readFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Invalid filename.";
        }
        
        File file = new File(filename);
        if (!file.exists() || file.isDirectory()) {
            return "File does not exist or is a directory.";
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("test1.txt"));
        System.out.println(readFile("test2.txt"));
        System.out.println(readFile(""));
        System.out.println(readFile("nonexistent.txt"));
        System.out.println(readFile(null));
    }
}