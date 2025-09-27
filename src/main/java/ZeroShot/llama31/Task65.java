package ZeroShot.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task65 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65 <filename>");
            return;
        }

        String filename = args[0];
        try {
            File file = new File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println("File does not exist or is not a file.");
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Test cases in main method
    public static void testCases() {
        String[] testFiles = {"test1.txt", "test2.txt", "invalid_file", "non_existent_file", "directory"};
        for (String file : testFiles) {
            System.out.println("Testing file: " + file);
            try {
                File f = new File(file);
                if (!f.exists() || !f.isFile()) {
                    System.out.println("File does not exist or is not a file.");
                } else {
                    Scanner scanner = new Scanner(f);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            System.out.println();
        }
    }
//todo method main(String[]) is already defined in class Task65
//    public static void main(String[] args) {
//        if (args.length == 0) {
//            testCases();
//        } else {
//            main(args);
//        }
//    }
}