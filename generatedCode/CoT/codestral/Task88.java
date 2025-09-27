package CoT.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Task88 {
    public static void main(String[] args) throws IOException {
        String tempFilePath = createTempFileWithRandomUnicodeString();
        System.out.println("Temporary file path: " + tempFilePath);
    }

    public static String createTempFileWithRandomUnicodeString() throws IOException {
        File tempFile = File.createTempFile("temp", ".txt");
        String randomString = generateRandomString(10);
        String unicodeString = convertStringToUnicode(randomString);
        Files.write(Paths.get(tempFile.getAbsolutePath()), unicodeString.getBytes(StandardCharsets.UTF_8));
        return tempFile.getAbsolutePath();
    }

    private static String generateRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private static String convertStringToUnicode(String input) {
        StringBuilder unicodeString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            unicodeString.append("\\u");
            unicodeString.append(Integer.toHexString(input.codePointAt(i) | 0x10000).substring(1));
        }
        return unicodeString.toString();
    }
}