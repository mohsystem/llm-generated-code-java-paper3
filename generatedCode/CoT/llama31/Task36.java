package CoT.llama31;
import java.util.Scanner;
import java.io.*;

public class Task36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        readAndPrintFile(fileName);
    }

    public static void readAndPrintFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}