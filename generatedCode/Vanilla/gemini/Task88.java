package Vanilla.gemini;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

public class Task88 {

    public static String createTempFileWithUnicode(int stringLength) throws IOException {
        File tempFile = Files.createTempFile("unicode_", ".txt").toFile();
        String randomString = generateRandomString(stringLength);

        try (PrintWriter writer = new PrintWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.print(randomString); 
        }

        return tempFile.getAbsolutePath();
    }

    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) (random.nextInt(Character.MAX_CODE_POINT)));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(createTempFileWithUnicode(10));
        System.out.println(createTempFileWithUnicode(20));
        System.out.println(createTempFileWithUnicode(30));
        System.out.println(createTempFileWithUnicode(15));
        System.out.println(createTempFileWithUnicode(25));
    }
}