package ourMethod.codestral;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Task129 {
    public static void main(String[] args) {
        String fileName = args[0]; // replace this with the actual file name provided by the user
        String urlString = "http://example.com/" + fileName; // replace this with the actual server address
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
             FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, lengthRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}