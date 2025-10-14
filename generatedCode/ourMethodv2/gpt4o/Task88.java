package ourMethodv2.gpt4o;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

public class Task88 {

    public static String createTempFileWithUnicode() throws IOException {
        File tempFile = File.createTempFile("tempfile_", ".txt");
        String randomString = generateRandomString();
        String unicodeString = convertToUnicode(randomString);

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile.toPath(), StandardCharsets.UTF_8)) {
            writer.write(unicodeString);
        }

        return tempFile.getAbsolutePath();
    }

    private static String generateRandomString() {
        int length = 10;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    private static String convertToUnicode(String input) {
        StringBuilder unicode = new StringBuilder();
        for (char c : input.toCharArray()) {
            unicode.append(String.format("\\u%04x", (int) c));
        }
        return unicode.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Temp file path: " + createTempFileWithUnicode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}