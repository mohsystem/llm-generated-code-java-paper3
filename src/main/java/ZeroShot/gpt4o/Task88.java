package ZeroShot.gpt4o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task88 {

    public static String createTempFileWithUnicodeString() throws IOException {
        File tempFile = Files.createTempFile("tempfile", ".txt").toFile();
        String randomString = generateRandomString(10);
        String unicodeString = convertToUnicode(randomString);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(unicodeString.getBytes(StandardCharsets.UTF_8));
        }
        return tempFile.getAbsolutePath();
    }

    private static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            builder.append(characters.charAt(index));
        }
        return builder.toString();
    }

    private static String convertToUnicode(String str) {
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            unicode.append("\\u").append(String.format("%04X", (int) str.charAt(i)));
        }
        return unicode.toString();
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(createTempFileWithUnicodeString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}