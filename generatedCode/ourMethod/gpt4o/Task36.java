package ourMethod.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Task36 {

    public static void readFile(String filePath) {
        if (!isValidFilePath(filePath)) {
            System.out.println("Invalid file path.");
            return;
        }

        Path path = Paths.get(filePath).normalize().toAbsolutePath();

        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static boolean isValidFilePath(String filePath) {
        String filePathPattern = "^[a-zA-Z0-9._/\\\\:-]+$";
        return Pattern.matches(filePathPattern, filePath);
    }

    public static void main(String[] args) {
        readFile("test.txt");
        readFile("nonexistent.txt");
        readFile("../test.txt");
        readFile("C:\\Windows\\System32\\test.txt");
        readFile("/etc/passwd");
    }
}