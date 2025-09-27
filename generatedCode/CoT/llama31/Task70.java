package CoT.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task70 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the file path as a command line argument.");
            return;
        }
        String filePath = args[0];
        readAndPrintFileContent(filePath);
    }

    public static void readAndPrintFileContent(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Test cases
    public static void testCases() {
        readAndPrintFileContent("test1.txt");
        readAndPrintFileContent("test2.txt");
        readAndPrintFileContent("test3.txt");
        readAndPrintFileContent("test4.txt");
        readAndPrintFileContent("test5.txt");
    }
}