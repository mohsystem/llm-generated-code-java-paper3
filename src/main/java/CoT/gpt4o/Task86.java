package CoT.gpt4o;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task86 {

    public static void downloadAndExecute(String fileUrl) throws IOException, InterruptedException {
        String fileName = "downloaded_program.exe";
        try (InputStream in = new URL(fileUrl).openStream();
             BufferedInputStream bis = new BufferedInputStream(in);
             FileOutputStream fis = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fis.write(buffer, 0, count);
            }
        }

        Process process = new ProcessBuilder(fileName).start();
        process.waitFor();
        Files.deleteIfExists(Paths.get(fileName));
    }

    public static void main(String[] args) {
        try {
            downloadAndExecute("http://example.com/file1.exe");
            downloadAndExecute("http://example.com/file2.exe");
            downloadAndExecute("http://example.com/file3.exe");
            downloadAndExecute("http://example.com/file4.exe");
            downloadAndExecute("http://example.com/file5.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}