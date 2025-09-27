package ZeroShot.gpt4o;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task70 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a file path as an argument.");
            return;
        }
        try {
            String content = readFile(args[0]);
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}