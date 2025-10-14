package Vanilla.openai;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(readFile("test1.txt"));
        System.out.println(readFile("test2.txt"));
        System.out.println(readFile("test3.txt"));
        System.out.println(readFile("test4.txt"));
        System.out.println(readFile("test5.txt"));
    }
}