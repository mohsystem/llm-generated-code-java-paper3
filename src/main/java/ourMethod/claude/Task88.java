package ourMethod.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithUnicode() {
        try {
            // Create temporary file with delete on exit
            Path tempFile = Files.createTempFile("temp", ".txt");
            tempFile.toFile().deleteOnExit();
            
            // Generate random string
            String randomStr = generateRandomString(10);
            
            // Convert to Unicode 
            byte[] unicodeBytes = randomStr.getBytes(StandardCharsets.UTF_8);
            String unicodeStr = new String(unicodeBytes, StandardCharsets.UTF_8);
            
            // Write to file using UTF-8
            try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
                writer.write(unicodeStr);
            }
            
            return tempFile.toString();
            
        } catch (IOException e) {
            throw new RuntimeException("Error creating temporary file", e);
        }
    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicode();
            System.out.println("Created temp file: " + filePath);
            try {
                String content = Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
                System.out.println("File content: " + content);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
