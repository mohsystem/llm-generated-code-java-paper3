package ourMethod.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Task88 {
    public static String createTempFile() throws IOException {
        File tempFile = File.createTempFile("temp", ".txt");
        tempFile.deleteOnExit();

        byte[] bytes = new byte[256];
        new Random().nextBytes(bytes);
        String randomString = new String(bytes, StandardCharsets.UTF_8);

        FileOutputStream outputStream = new FileOutputStream(tempFile);
        outputStream.write(randomString.getBytes(StandardCharsets.UTF_8));
        outputStream.close();

        return tempFile.getAbsolutePath();
    }

    public static void main(String[] args) {
        try {
            System.out.println(createTempFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}