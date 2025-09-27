package ourMethod.gpt4o;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Task86 {
    public static void main(String[] args) {
        String[] urls = {
            "http://example.com/file1.exe",
            "http://example.com/file2.exe",
            "http://example.com/file3.exe",
            "http://example.com/file4.exe",
            "http://example.com/file5.exe"
        };
        for (String url : urls) {
            downloadAndExecute(url);
        }
    }

    public static void downloadAndExecute(String fileURL) {
        String fileName = "downloadedFile.exe";
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            Process process = Runtime.getRuntime().exec(fileName);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}