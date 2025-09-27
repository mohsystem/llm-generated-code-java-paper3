package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a filename as a command line argument.");
            return;
        }
        String fileContent = readFile(args[0]);
        if (fileContent != null) {
            System.out.println(fileContent);
        }
    }
}