package ZeroShot.gemini;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {

    public static void downloadAndExecute(String urlString) throws IOException, InterruptedException {
        // Downloading the EXE
        URL url = new URL(urlString);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("downloaded.exe");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();

        // Executing the EXE (High risk - ensure proper sanitization and validation in a real-world application)
        Process process = new ProcessBuilder("downloaded.exe").start();
        process.waitFor(); 
    }


    public static void main(String[] args) {
        // This is for demonstration purposes only and should not be used with untrusted URLs
        // In real applications, extensive validation and security checks are necessary
        try {
            // Replace with actual URLs for testing - these examples won't work as they are not real EXE URLs
            downloadAndExecute("https://example.com/file1.exe");  // Example 1 - replace with a valid URL
            downloadAndExecute("https://example.com/file2.exe");  // Example 2
            downloadAndExecute("https://example.com/file3.exe");  // Example 3
            downloadAndExecute("https://example.com/file4.exe");  // Example 4
            downloadAndExecute("https://example.com/file5.exe");  // Example 5
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}