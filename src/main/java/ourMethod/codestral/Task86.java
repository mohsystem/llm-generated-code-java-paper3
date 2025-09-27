package ourMethod.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task86 {
    public static void main(String[] args) {
        try {
            String url = "https://example.com/path/to/file.exe";
            downloadAndExecute(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadAndExecute(String urlString) throws IOException {
        URL url = new URL(urlString);
        String fileName = url.getFile();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }

        ProcessBuilder pb = new ProcessBuilder(fileName);
        pb.inheritIO();
        pb.start();

        Files.deleteIfExists(Paths.get(fileName));
    }
}