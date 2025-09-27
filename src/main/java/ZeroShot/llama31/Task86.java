package ZeroShot.llama31;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {
    public static void downloadAndExecute(String url, String filename) {
        try (InputStream in = new URL(url).openStream();
             FileOutputStream fos = new FileOutputStream(filename);
             ReadableByteChannel rbc = Channels.newChannel(in)) {

            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("File downloaded successfully: " + filename);
            // Execute the EXE file (use with caution)
            Runtime.getRuntime().exec("start " + filename);
        } catch (IOException e) {
            System.out.println("Failed to download file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] testUrls = {
            "https://example.com/file1.exe",
            "https://example.com/file2.exe",
            "https://example.com/file3.exe",
            "https://example.com/file4.exe",
            "https://example.com/file5.exe"
        };
        String[] filenames = {
            "file1.exe",
            "file2.exe",
            "file3.exe",
            "file4.exe",
            "file5.exe"
        };

        for (int i = 0; i < testUrls.length; i++) {
            downloadAndExecute(testUrls[i], filenames[i]);
        }
    }
}