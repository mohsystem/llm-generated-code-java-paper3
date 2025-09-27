package Vanilla.codestral;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {
    public static void downloadAndExecute(String urlString) throws IOException {
        URL url = new URL(urlString);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("downloaded.exe");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        Runtime.getRuntime().exec("downloaded.exe");
    }

    public static void main(String[] args) throws IOException {
        downloadAndExecute("http://example.com/file.exe");
    }
}