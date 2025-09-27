package ZeroShot.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

public class Task88 {
    public static String createTemporaryFile() throws IOException {
        File tempFile = Files.createTempFile("temp", ".txt");
        String randomString = getRandomString(10);
        String unicodeString = stringToUnicode(randomString);
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(unicodeString.getBytes(StandardCharsets.UTF_8));
        fos.close();
        return tempFile.getAbsolutePath();
    }

    private static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static String stringToUnicode(String input) {
        StringBuilder unicode = new StringBuilder();
        for (char ch : input.toCharArray()) {
            unicode.append(String.format("\\u%04x", (int) ch));
        }
        return unicode.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(createTemporaryFile());
    }
}