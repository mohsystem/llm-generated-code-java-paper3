package ZeroShot.codestral;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Task129 {
    public static void downloadFile(String fileName, String serverUrl) throws IOException {
        URL url = new URL(serverUrl + "/" + fileName);
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, count);
            }
        }
    }

    public static void main(String[] args) {
        try {
            downloadFile("test.txt", "http://example.com");
            // Add more test cases here
        } catch (IOException e) {
            System.out.println("An error occurred while downloading the file.");
            e.printStackTrace();
        }
    }
}