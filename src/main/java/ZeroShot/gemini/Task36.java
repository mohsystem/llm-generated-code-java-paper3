package ZeroShot.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task36 {

    public static void printFileContents(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        printFileContents("test1.txt");
        printFileContents("test2.txt");
        printFileContents("test3.txt");
        printFileContents("test4.txt");
        printFileContents("test5.txt");
    }
}