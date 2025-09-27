package ZeroShot.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Task88 {

    public static String createTempFileWithUnicodeString() throws IOException {
        Path tempFile = Files.createTempFile("temp", ".txt");
        String randomString = generateRandomString(10); // Generate a random string of length 10
        String unicodeString = convertToUnicode(randomString);
        Files.writeString(tempFile, unicodeString, StandardCharsets.UTF_8);
        return tempFile.toString();
    }


    private static String generateRandomString(int length) {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static String convertToUnicode(String str) {
        StringBuilder unicode = new StringBuilder();
        for (char c : str.toCharArray()) {
            unicode.append(String.format("\\u%04x", (int) c));
        }
        return unicode.toString();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicodeString();
            System.out.println("Temporary file created: " + filePath);

            // Clean up temporary files (optional)
             File file = new File(filePath);
             file.deleteOnExit(); 
        }
    }
}