package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task99 {
    public static void main(String[] args) {
        String[] filenames = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String filename : filenames) {
            processFile(filename);
        }
    }

    public static void processFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (Pattern.matches("^[0-9].*\\.$", line)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}