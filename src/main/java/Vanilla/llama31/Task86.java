package Vanilla.llama31;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {
    public static void main(String[] args) {
        String[] urls = {
            "http://example.com/path/to/your/exe.exe",
            "http://example.com/path/to/your/exe2.exe",
            "http://example.com/path/to/your/exe3.exe",
            "http://example.com/path/to/your/exe4.exe",
            "http://example.com/path/to/your/exe5.exe"
        };

        for (String url : urls) {
            downloadAndExecute(url);
        }
    }

    public static void downloadAndExecute(String url) {
        try {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("downloaded.exe");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();

            Process process = Runtime.getRuntime().exec("downloaded.exe");
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}