package CoT.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithUnicode() {
        try {
            // Create temp file
            File tempFile = File.createTempFile("temp", ".txt");
            tempFile.deleteOnExit();
            
            // Generate random string
            String randomStr = generateRandomString(10);
            
            // Convert to unicode
            String unicodeStr = convertToUnicode(randomStr);
            
            // Write to file using UTF-8
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
                writer.write(unicodeStr);
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
        for(int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    private static String convertToUnicode(String input) {
        StringBuilder unicode = new StringBuilder();
        for (char c : input.toCharArray()) {
            unicode.append("\\\\u").append(String.format("%04x", (int) c));
        }
        return unicode.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ": " + createTempFileWithUnicode());
        }
    }
}
