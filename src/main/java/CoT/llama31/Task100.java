package CoT.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task100 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task100 <regex_pattern> <file_name>");
            return;
        }

        String regexPattern = args[0];
        String fileName = args[1];

        try {
            Pattern pattern = Pattern.compile(regexPattern);
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println("Found match: " + matcher.group());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void testCases() {
        String[] args1 = {"\\d+", "test.txt"};
        main(args1);

        String[] args2 = {"[a-zA-Z]+", "test.txt"};
        main(args2);

        String[] args3 = {"\\w+", "test.txt"};
        main(args3);

        String[] args4 = {"\\d{4}-\\d{2}-\\d{2}", "test.txt"};
        main(args4);

        String[] args5 = {"[^a-zA-Z0-9]", "test.txt"};
        main(args5);
    }
}