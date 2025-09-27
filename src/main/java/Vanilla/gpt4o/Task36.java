package Vanilla.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static String readFileContents(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String testFile : testFiles) {
            System.out.println("Contents of " + testFile + ":");
            System.out.println(readFileContents(testFile));
        }
    }
}