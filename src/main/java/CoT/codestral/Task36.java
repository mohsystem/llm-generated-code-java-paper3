package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static void main(String[] args) {
        readFile("test.txt");
    }

    public static void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}