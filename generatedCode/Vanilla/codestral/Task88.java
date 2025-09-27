package Vanilla.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task88 {
    public static String createTempFileWithUnicode() throws IOException {
        File tempFile = File.createTempFile("temp", ".txt");
        String randomString = generateRandomString(10);
        String unicodeString = new String(randomString.getBytes(), StandardCharsets.UTF_8);

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(unicodeString.getBytes(StandardCharsets.UTF_8));
        }

        return tempFile.getAbsolutePath();
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

    public static void main(String[] args) throws IOException {
        System.out.println(createTempFileWithUnicode());
    }
}