package Vanilla.codestral;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task121 {
    public static void main(String[] args) {
        readFile("test.txt");
    }

    public static void readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}