package Vanilla.openai;
import java.io.*;
import java.net.*;

public class Task86 {
    public static void main(String[] args) {
        String[] testUrls = {
            "http://example.com/program1.exe",
            "http://example.com/program2.exe",
            "http://example.com/program3.exe",
            "http://example.com/program4.exe",
            "http://example.com/program5.exe"
        };
        
        for (String url : testUrls) {
            downloadAndExecute(url);
        }
    }

    public static void downloadAndExecute(String fileURL) {
        String fileName = "downloaded_program.exe";
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