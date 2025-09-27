package Vanilla.gpt4o;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task88 {
    public static String createTempFile() throws IOException {
        File tempFile = File.createTempFile("tempfile_", ".txt");
        String randomString = "RandomString" + Math.random();
        String unicodeString = new String(randomString.getBytes(), StandardCharsets.UTF_8);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
            writer.write(unicodeString);
        }
        return tempFile.getAbsolutePath();
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(createTempFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}