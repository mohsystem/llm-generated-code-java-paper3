package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Task99 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String file : testFiles) {
            readAndMatchLines(file);
        }
    }

    public static void readAndMatchLines(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (Pattern.matches("^[0-9].*\\.$", line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}