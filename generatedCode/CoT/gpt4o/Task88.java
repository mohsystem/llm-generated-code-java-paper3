package CoT.openai;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

public class Task88 {

    public static String createTempFileWithUnicodeContent() throws IOException {
        String randomString = UUID.randomUUID().toString();
        String unicodeString = convertToUnicode(randomString);

        File tempFile = File.createTempFile("tempFile", ".txt");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.write(unicodeString);
        }

        return tempFile.getAbsolutePath();
    }

    private static String convertToUnicode(String input) {
        StringBuilder unicodeStringBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            unicodeStringBuilder.append("\\u").append(String.format("%04x", (int) c));
        }
        return unicodeStringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            System.out.println(createTempFileWithUnicodeContent());
        }
    }
}