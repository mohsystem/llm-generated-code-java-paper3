package ZeroShot.gpt4o;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Task86 {
    public static void main(String[] args) {
        Task86 task = new Task86();
        String[] testUrls = {
            "http://example.com/test1.exe",
            "http://example.com/test2.exe",
            "http://example.com/test3.exe",
            "http://example.com/test4.exe",
            "http://example.com/test5.exe"
        };

        for (String url : testUrls) {
            try {
                Path exePath = task.downloadExe(url);
                if (exePath != null) {
                    task.executeExe(exePath);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public Path downloadExe(String fileURL) throws IOException {
        URL url = new URL(fileURL);
        InputStream in = url.openStream();
        Path tempFile = Files.createTempFile("downloaded", ".exe");
        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
        in.close();
        return tempFile;
    }

    public void executeExe(Path exePath) {
        try {
            ProcessBuilder builder = new ProcessBuilder(exePath.toString());
            builder.start();
        } catch (IOException e) {
            System.out.println("Error executing EXE: " + e.getMessage());
        }
    }
}