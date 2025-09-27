package ourMethod.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(fileName);
            if (!file.exists() || !file.canRead()) {
                throw new FileNotFoundException("File does not exist or cannot be read.");
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}