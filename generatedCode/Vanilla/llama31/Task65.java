package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task65 {
    public static boolean isValidFileName(String fileName) {
        String pattern = "^.*\\.(java|py|c|cpp|cs|js|html|css)$";
        return Pattern.matches(pattern, fileName);
    }

    public static String readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return content.toString();
        } catch (FileNotFoundException e) {
            return "File not found: " + fileName;
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task65 <filename>");
            return;
        }

        String fileName = args[0];
        if (!isValidFileName(fileName)) {
            System.out.println("Invalid file name format: " + fileName);
            return;
        }

        System.out.println(readFile(fileName));
    }
}