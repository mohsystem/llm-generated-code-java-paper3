package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65 <filename>");
            return;
        }

        String fileName = args[0];
        if (!isValidFileName(fileName)) {
            System.out.println("Invalid filename.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean isValidFileName(String fileName) {
        // Add your filename validation logic here
        return true;
    }
}