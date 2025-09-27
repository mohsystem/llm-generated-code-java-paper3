package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task36 {

    public static void printFileContents(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        printFileContents(filePath);
         System.out.print("Enter the file path: ");
        filePath = scanner.nextLine();
        printFileContents(filePath);
         System.out.print("Enter the file path: ");
        filePath = scanner.nextLine();
        printFileContents(filePath);
         System.out.print("Enter the file path: ");
        filePath = scanner.nextLine();
        printFileContents(filePath);
         System.out.print("Enter the file path: ");
        filePath = scanner.nextLine();
        printFileContents(filePath);

    }
}