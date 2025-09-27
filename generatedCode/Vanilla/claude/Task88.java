package Vanilla.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithUnicode() {
        try {
            // Create temporary file
            File tempFile = File.createTempFile("unicode_", ".txt");
            
            // Generate random string
            String randomStr = generateRandomString(10);
            
            // Convert to Unicode
            String unicodeStr = convertToUnicode(randomStr);
            
            // Write to file using UTF-8
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
                writer.write(unicodeStr);
            }
            
            return tempFile.getAbsolutePath();
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    private static String convertToUnicode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(String.format("\\\\u%04x", (int) c));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicode();
            System.out.println("Test case " + (i+1) + ": Temp file created at: " + filePath);
        }
    }
}
