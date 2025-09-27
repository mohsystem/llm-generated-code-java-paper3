package ourMethod.gpt4o;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithRandomUnicode() throws IOException {
        Path tempFile = Files.createTempFile(null, ".txt");
        String randomString = generateRandomString(10);
        String unicodeString = convertToUnicode(randomString);
        
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.write(unicodeString);
        }
        
        return tempFile.toString();
    }
    
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (random.nextInt(26) + 'a'));
        }
        return builder.toString();
    }
    
    private static String convertToUnicode(String input) {
        StringBuilder unicodeString = new StringBuilder();
        for (char c : input.toCharArray()) {
            unicodeString.append("\\u").append(String.format("%04x", (int) c));
        }
        return unicodeString.toString();
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                String filePath = createTempFileWithRandomUnicode();
                System.out.println("Temporary file created at: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creating temporary file: " + e.getMessage());
        }
    }
}