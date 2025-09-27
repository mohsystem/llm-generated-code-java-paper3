package CoT.gemini;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task127 {

    public static void copyFile(String sourcePath, String destPath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             FileOutputStream outputStream = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error copying file: " + e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        try {
            copyFile("test1.txt", "temp/test1_copy.txt");
            copyFile("test2.txt", "temp/test2_copy.txt");
            copyFile("nonexistent.txt", "temp/nonexistent_copy.txt"); 
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
           File tempDir = new File("temp");
           if (!tempDir.exists()) {
             tempDir.mkdir();
           }
           copyFile("test3.txt", "temp/test3_copy.txt"); // test creating dest dir
           copyFile("", "temp/empty_copy.txt"); //Test for empty source path
        }
        catch (IOException e) {
           System.err.println(e.getMessage());
        }
    }
}