package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task36 {

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null; // Or throw an exception if you prefer
        }
        return content.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test case 1:");
        String fileContent1 = readFile("test1.txt");
        if (fileContent1 != null) {
            System.out.println(fileContent1);
        }

        System.out.println("Test case 2:");
        String fileContent2 = readFile("test2.txt");
        if (fileContent2 != null) {
            System.out.println(fileContent2);
        }


        System.out.println("Test case 3 - File not found:");
        String fileContent3 = readFile("nonexistent_file.txt");
        if (fileContent3 != null) {
            System.out.println(fileContent3);
        }


        System.out.println("Test case 4 - Empty file:");
        String fileContent4 = readFile("empty.txt"); // Create an empty file for this test
        if (fileContent4 != null) {
            System.out.println(fileContent4);
        }


        System.out.println("Test case 5:");
        String fileContent5 = readFile("test3.txt"); // Create a test3.txt with some content
        if (fileContent5 != null) {
            System.out.println(fileContent5);
        }

        scanner.close();
    }
}