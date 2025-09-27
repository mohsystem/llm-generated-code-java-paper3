package CoT.gemini;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.UUID;

public class Task88 {

    public static String createTempFileWithUnicodeString() throws IOException {
        // Create a temporary file with a random name
        File tempFile = Files.createTempFile(UUID.randomUUID().toString(), ".txt").toFile();

        // Generate a random string
        String randomString = generateRandomString(10); 

        // Convert the string to Unicode
        String unicodeString = randomString; // Java strings are inherently Unicode

        // Write the Unicode string to the file using UTF-8 encoding
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8)) {
            writer.write(unicodeString);
        }

        // Return the path of the temporary file
        return tempFile.getAbsolutePath();
    }

    private static String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }



    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicodeString();
            System.out.println("Temporary file path: " + filePath);
            // Clean up: Delete the temporary file (optional)
             File file = new File(filePath);
             file.delete();
        }
    }
}