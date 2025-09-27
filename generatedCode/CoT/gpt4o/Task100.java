package CoT.gpt4o;
import java.io.*;
import java.util.regex.*;

public class Task100 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task100 <regex> <file>");
            return;
        }

        String regex = args[0];
        String fileName = args[1];

        try {
            Pattern pattern = Pattern.compile(regex);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (PatternSyntaxException e) {
            System.err.println("Regex error: " + e.getMessage());
        }
    }
}