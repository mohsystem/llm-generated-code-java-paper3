package ourMethod.llama31;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task86 <URL>");
            return;
        }

        String urlStr = args[0];
        try {
            URL url = new URL(urlStr);
            downloadFile(url, "downloaded.exe");
            executeExe("downloaded.exe");
        } catch (IOException e) {
            System.out.println("Error downloading or executing file: " + e.getMessage());
        }
    }

    private static void downloadFile(URL url, String fileName) throws IOException {
        try (InputStream in = url.openStream(); FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(Channels.newChannel(in), 0, Long.MAX_VALUE);
        }
    }

    private static void executeExe(String fileName) {
        try {
            Process process = Runtime.getRuntime().exec(fileName);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error executing file: " + e.getMessage());
        }
    }
}