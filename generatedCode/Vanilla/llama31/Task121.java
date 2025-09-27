package Vanilla.llama31;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task121 {
    public static void main(String[] args) {
        // Test cases
        String[] sourceFiles = {"test1.txt", "test2.txt", "test3.txt"};
        String[] destinationFiles = {"uploaded_test1.txt", "uploaded_test2.txt", "uploaded_test3.txt"};

        for (int i = 0; i < sourceFiles.length; i++) {
            uploadFile(sourceFiles[i], destinationFiles[i]);
        }
    }

    public static void uploadFile(String source, String destination) {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("File uploaded from " + source + " to " + destination);
        } catch (IOException e) {
            System.err.println("Error uploading file: " + e.getMessage());
        }
    }
}