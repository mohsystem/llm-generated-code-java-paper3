package ZeroShot.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithUnicode() {
        try {
            // Create temp file
            File tempFile = File.createTempFile("unicode_", ".txt");
            tempFile.deleteOnExit();
            
            // Generate random string
            String randomStr = generateRandomString(10);
            
            // Convert to Unicode and write to file using UTF-8
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
                writer.write(randomStr);
            }
            
            return tempFile.getAbsolutePath();
            
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ": " + createTempFileWithUnicode());
        }
    }
}
