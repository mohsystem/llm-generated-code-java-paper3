package ourMethod.codestral;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task100 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Task100 <regex_pattern> <file_name>");
            System.exit(1);
        }

        String regexPattern = args[0];
        String fileName = args[1];
        Pattern pattern = Pattern.compile(regexPattern);

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            System.exit(1);
        }
    }
}