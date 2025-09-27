package CoT.llama31;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Task86 {
    public static void main(String[] args) {
        String[] urls = {
            "http://example.com/program.exe", // Replace with actual URLs
            "http://example.com/program2.exe",
            "http://example.com/program3.exe",
            "http://example.com/program4.exe",
            "http://example.com/program5.exe"
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

            // Execute the downloaded EXE file
            // Note: Executing EXE files can be dangerous and should be done with caution.
            // This example uses the Runtime.exec method which is generally discouraged due to security risks.
            // Consider using a more secure approach if possible.
            Process p = Runtime.getRuntime().exec("downloaded.exe");
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error downloading or executing the file: " + e.getMessage());
        }
    }
}