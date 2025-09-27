package Vanilla.codestral;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Task129 {
    public static void retrieveFile(String fileName, String url) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
        FileOutputStream out = new FileOutputStream(fileName);

        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            out.write(dataBuffer, 0, bytesRead);
        }

        out.close();
        in.close();
    }

    public static void main(String[] args) {
        try {
            retrieveFile("test.txt", "http://example.com/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}