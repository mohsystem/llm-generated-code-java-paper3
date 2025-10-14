package Vanilla.openai;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task70 {
    public static String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path.");
            return;
        }
        for (String filePath : args) {
            try {
                System.out.println(readFileContent(filePath));
            } catch (IOException e) {
                System.out.println("Error reading file: " + filePath);
            }
        }
    }
}