package CoT.claude;

import java.io.*;
import java.net.*;
import java.security.*;
import java.nio.file.*;
import javax.net.ssl.*;

public class Task86 {
    public static boolean downloadAndExecute(String urlStr) {
        try {
            // Validate URL
            if (!urlStr.toLowerCase().endsWith(".exe")) {
                System.out.println("Security Error: Only .exe files are allowed");
                return false;
            }

            // Create secure URL connection
            URL url = new URL(urlStr);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Generate unique filename with timestamp
            String fileName = "download_" + System.currentTimeMillis() + ".exe";
            Path filePath = Paths.get(System.getProperty("java.io.tmpdir"), fileName);

            // Download with size limit (100MB)
            try (InputStream in = conn.getInputStream();
                 OutputStream out = Files.newOutputStream(filePath)) {
                
                byte[] buffer = new byte[8192];
                int bytesRead;
                long totalBytes = 0;
                long maxSize = 104857600; // 100MB

                while ((bytesRead = in.read(buffer)) != -1) {
                    if (totalBytes + bytesRead > maxSize) {
                        Files.deleteIfExists(filePath);
                        throw new SecurityException("File too large");
                    }
                    out.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                }
            }

            // Execute with security warning
            System.out.println("Security Warning: Executing downloaded file. Proceed with caution.");
            ProcessBuilder pb = new ProcessBuilder(filePath.toString());
            pb.start();

            // Clean up
            Files.deleteIfExists(filePath);
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://example.com/safe1.exe",
            "https://example.com/safe2.exe",
            "https://example.com/safe3.exe",
            "https://example.com/safe4.exe",
            "https://example.com/safe5.exe"
        };

        for (String url : testUrls) {
            System.out.println("Testing URL: " + url);
            downloadAndExecute(url);
            System.out.println("-------------------");
        }
    }
}
