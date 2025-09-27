package ourMethod.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

class Task88 {
    public static String createTempFileWithUnicodeString() throws IOException {
        Path tempFilePath = Files.createTempFile("unicode_", ".txt");
        File tempFile = tempFilePath.toFile();

        // Generate random string
        int stringLength = 10; 
        Random random = new Random();
        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            sb.append((char) (random.nextInt(Character.MAX_CODE_POINT)));
        }
        String randomString = sb.toString();


        Files.writeString(tempFilePath, randomString, StandardCharsets.UTF_8);

        return tempFilePath.toString();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String filePath = createTempFileWithUnicodeString();
            System.out.println("Test case " + (i + 1) + ": " + filePath);

             // Clean up temporary files after each test case
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}