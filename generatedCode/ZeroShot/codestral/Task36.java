package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static void main(String[] args) {
        printFileContents("test.txt");
    }

    public static void printFileContents(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}