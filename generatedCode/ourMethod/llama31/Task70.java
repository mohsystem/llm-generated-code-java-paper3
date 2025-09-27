package ourMethod.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task70 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task70 <file_path>");
            return;
        }
        String filePath = args[0];
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z"); // Read the entire file
            String content = scanner.next();
            scanner.close();
            System.out.println(content);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}