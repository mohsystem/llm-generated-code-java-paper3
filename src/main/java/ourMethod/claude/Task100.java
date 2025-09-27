package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class Task100 {
    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB limit
    private static final int MAX_LINE_LENGTH = 10000;
    
    public static void searchFile(String regexPattern, String fileName) throws Exception {
        // Validate inputs
        if (regexPattern == null || regexPattern.isEmpty() || fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Pattern and filename must not be null or empty");
        }
        
        // Compile pattern with timeout to prevent ReDoS
        Pattern pattern;
        try {
            pattern = Pattern.compile(regexPattern);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Invalid regex pattern: " + e.getMessage());
        }
        
        // Validate file
        Path path = Paths.get(fileName).normalize();
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        
        // Check file size
        if (Files.size(path) > MAX_FILE_SIZE) {
            throw new IOException("File too large: maximum size is " + MAX_FILE_SIZE + " bytes");
        }
        
        // Read and search file
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (line.length() > MAX_LINE_LENGTH) {
                    System.err.println("Warning: Line " + lineNum + " exceeds maximum length and will be truncated");
                    line = line.substring(0, MAX_LINE_LENGTH);
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Line " + lineNum + ": " + line);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.err.println("Usage: java Task100 <regex_pattern> <filename>");
                System.exit(1);
            }
            searchFile(args[0], args[1]);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
