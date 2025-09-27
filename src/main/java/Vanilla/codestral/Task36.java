package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt"; // replace with the path to your file
        printFileContents(filePath);
    }

    public static void printFileContents(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}