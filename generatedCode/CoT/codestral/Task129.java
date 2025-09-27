package CoT.codestral;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Task129 {
    public static void retrieveFile(String fileName, String urlString) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
             FileOutputStream out = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[1024];
            int count = 0;

            while ((count = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, count);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while retrieving the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        retrieveFile("example.txt", "http://example.com/example.txt");
        retrieveFile("image.jpg", "http://example.com/image.jpg");
        retrieveFile("document.pdf", "http://example.com/document.pdf");
        retrieveFile("data.csv", "http://example.com/data.csv");
        retrieveFile("program.exe", "http://example.com/program.exe");
    }
}