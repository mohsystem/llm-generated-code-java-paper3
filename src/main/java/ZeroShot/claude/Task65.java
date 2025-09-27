package ZeroShot.claude;

import java.io.*;

public class Task65 {
    public static String readFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Invalid filename";
        }

        // Check file extension
        if (!filename.matches("^[\\\\w\\\\-. ]+\\\\.(txt|csv|dat)$")) {
            return "Invalid file format. Only txt, csv and dat files allowed";
        }

        File file = new File(filename);
        StringBuilder content = new StringBuilder();

        try {
            if (!file.exists()) {
                return "File does not exist";
            }

            if (!file.canRead()) {
                return "File cannot be accessed";
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\\n");
                }
            }
            return content.toString();

        } catch (SecurityException e) {
            return "Security error: " + e.getMessage();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test.txt",
            "invalid.exe",
            "",
            "nonexistent.txt",
            "../attempt_traversal.txt"
        };

        for (String filename : testFiles) {
            System.out.println("Testing file: " + filename);
            System.out.println(readFile(filename));
            System.out.println("-------------------");
        }
    }
}
