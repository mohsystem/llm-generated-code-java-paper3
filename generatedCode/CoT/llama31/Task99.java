package CoT.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task99 {
    public static void main(String[] args) {
        String[] testFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String file : testFiles) {
            System.out.println("Processing file: " + file);
            processFile(file);
        }
    }

    public static void processFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (Pattern.matches("^\\d+.*\\.$", line)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}