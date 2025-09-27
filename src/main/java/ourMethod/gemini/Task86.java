package ourMethod.gemini;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Task86 {

    public static void downloadAndExecute(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream("downloaded.exe");
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

            in.close();
            fileOutputStream.close();


            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("downloaded.exe");


        } catch (IOException e) {
            throw new IOException("Error during download or execution", e);
        }
    }



    public static void main(String[] args) {
        // Test cases (replace with actual URLs)
        String[] testUrls = {
                "https://example.com/test1.exe", // Replace with actual URLs for testing.
                "https://example.com/test2.exe",
                "https://example.com/test3.exe",
                "https://example.com/test4.exe",
                "https://example.com/test5.exe"

        };

        for (String testUrl : testUrls) {
            try {
                System.out.println("Downloading and executing: " + testUrl);
                downloadAndExecute(testUrl);
                System.out.println("Execution completed.");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }
}