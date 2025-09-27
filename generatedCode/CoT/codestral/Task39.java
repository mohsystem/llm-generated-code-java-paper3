package CoT.codestral;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task39 {
    public static void main(String[] args) {
        displayFileContents("test.txt");
    }

    public static void displayFileContents(String filename) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}