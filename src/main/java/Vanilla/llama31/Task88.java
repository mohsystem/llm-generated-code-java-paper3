package Vanilla.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task88 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUtf8Encoding();
            System.out.println("Temporary File Path: " + filePath);
        }
    }

    public static String createTempFileWithUtf8Encoding() {
        try {
            File tempFile = File.createTempFile("temp", ".txt");
            tempFile.deleteOnExit();

            String randomString = generateRandomString();
            try (FileWriter writer = new FileWriter(tempFile, StandardCharsets.UTF_8)) {
                writer.write(randomString);
            }

            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Error creating temporary file: " + e.getMessage());
            return null;
        }
    }

    public static String generateRandomString() {
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}