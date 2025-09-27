package CoT.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Task50 {
    public static String uploadFile(InputStream fileInputStream, String fileName) throws IOException {
        File targetFile = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }

        fileOutputStream.close();
        fileInputStream.close();

        return "File uploaded successfully.";
    }

    public static void main(String[] args) throws IOException {
        // Test case: Replace "test.txt" with the path to your test file
        InputStream testFile = Files.newInputStream(new File("test.txt").toPath());
        System.out.println(uploadFile(testFile, "uploaded_test.txt"));
    }
}