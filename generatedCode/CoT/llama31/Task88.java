package CoT.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task88 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFile();
            System.out.println("Temporary File Path: " + filePath);
        }
    }

    public static String createTempFile() {
        try {
            File tempFile = File.createTempFile("temp", ".tmp");
            tempFile.deleteOnExit();

            // Generate a random string
            String randomString = generateRandomString(10);

            // Convert to Unicode (Java strings are already Unicode)
            String unicodeString = randomString;

            // Write the string to the file using UTF-8 encoding
            try (FileWriter writer = new FileWriter(tempFile, StandardCharsets.UTF_8)) {
                writer.write(unicodeString);
            }

            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            System.err.println("Error creating temporary file: " + e.getMessage());
            return null;
        }
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}