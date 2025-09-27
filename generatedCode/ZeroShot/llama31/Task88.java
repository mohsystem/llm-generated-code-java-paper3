package ZeroShot.llama31;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Task88 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicodeString();
            System.out.println("Temporary File Path: " + filePath);
        }
    }

    public static String createTempFileWithUnicodeString() throws IOException {
        // Generate a random string
        String randomString = generateRandomString(20);

        // Convert to Unicode (Java strings are already Unicode)
        String unicodeString = randomString;

        // Create a temporary file
        Path tempFile = Files.createTempFile("temp", ".txt");
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile.toFile()), "UTF-8"))) {
            out.write(unicodeString);
            out.flush();
        }

        return tempFile.toString();
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}