package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task70 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide exactly one file path as an argument.");
            return;
        }

        String filePath = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}