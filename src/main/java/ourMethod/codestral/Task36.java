package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static void main(String[] args) {
        printFileContents("input.txt");
    }

    public static void printFileContents(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}