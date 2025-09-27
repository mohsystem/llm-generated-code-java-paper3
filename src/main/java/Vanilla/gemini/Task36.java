package Vanilla.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task36 {

    public static void printFileContents(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
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