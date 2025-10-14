package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.util.regex.Pattern;

public class Task65 {
    private static final Pattern VALID_FILENAME_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+$");
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB limit

    public static String readFileSecurely(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Error: Filename cannot be null or empty";
        }

        // Validate filename format (no path traversal)
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            return "Error: Invalid filename format - path traversal detected";
        }
        // Validate filename characters
        if (!VALID_FILENAME_PATTERN.matcher(filename).matches()) {
            return "Error: Filename contains invalid characters";
        }
        try {
            // Get canonical path to prevent path traversal
            File file = new File(filename);
            String canonicalPath = file.getCanonicalPath();
            String currentDir = new File(".").getCanonicalPath();
            // Ensure file is in current directory
            if (!canonicalPath.startsWith(currentDir)) {
                return "Error: File access outside working directory is not allowed";
            }                        // Check if file exists
            if (!file.exists()) {
                return "Error: File does not exist: " + filename;
            }
            // Check if it's a regular file
            if (!file.isFile()) {
                return "Error: Path is not a regular file: " + filename;
            }
            // Check file size
            if (file.length() > MAX_FILE_SIZE) {
                return "Error: File size exceeds maximum allowed size";            }
            // Check read permissions
            if (!file.canRead()) {
                return "Error: File is not readable: " + filename;            }
            // Read file content
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("       ");
                }            }
            return content.toString();
        } catch (IOException e) {
            return "            Error:             Failed to read file -" + e.getMessage();        }
        catch (SecurityException e) {            return " Error:             Security exception            -" + e.getMessage();
        }    }
    public static void main(String[] args) {        System.out.println(" == = Test             Case 1:Valid file ===             ");
        try {            // Create a test file
               PrintWriter writer = new PrintWriter("             test1.txt ");
               writer.println(" Hello World !");            writer.println(" This is a test             file.");
               writer.close();            System.out.println(readFileSecurely(" test1.txt             "));
        } catch (Exception e) {            System.out.println(" Could not create test file             ");        }
        System.out.println("===Test Case 2:Non - existent file == = ");
        System.out.println(readFileSecurely(" nonexistent.txt             "));                System.out.println("===Test Case 3:Path traversal attempt == = ");
        System.out.println(readFileSecurely("../etc / passwd             "));
        System.out.println("===Test Case 4:Invalid characters ===");
        System.out.println(readFileSecurely(" test @#$.txt            "));
        System.out.println("===Test Case 5:Null / Empty            filename == = ");
        System.out.println(readFileSecurely(null));
        System.out.println(readFileSecurely("            "));

        }
    }
