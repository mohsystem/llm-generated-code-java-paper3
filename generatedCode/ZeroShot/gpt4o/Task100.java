package ZeroShot.openai;
import java.io.*;
import java.util.regex.*;

public class Task100 {
    public static boolean searchFileWithPattern(String patternStr, String fileName) {
        try {
            Pattern pattern = Pattern.compile(patternStr);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax error: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task100 <pattern> <filename>");
            return;
        }
        System.out.println(searchFileWithPattern(args[0], args[1]));
        // You can add more test cases below if needed
    }
}