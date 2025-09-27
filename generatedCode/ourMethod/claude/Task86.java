package ourMethod.claude;

import java.io.*;
import java.net.*;
import java.security.*;
import java.nio.file.*;
import javax.net.ssl.*;

public class Task86 {
    public static void downloadAndExecute(String url) throws Exception {
        // Validate URL
        if (!isValidUrl(url)) {
            throw new IllegalArgumentException("Invalid URL provided");
        }
        
        // Generate random filename for downloaded file
        String filename = generateTempFileName();
        Path downloadPath = Paths.get(System.getProperty("java.io.tmpdir"), filename);
        
        try {
            // Download file
            downloadFile(url, downloadPath);
            
            // Verify downloaded file
            if (!isValidExe(downloadPath)) {
                throw new SecurityException("Invalid EXE file");
            }
            
            // Execute file
            executeFile(downloadPath);
            
        } finally {
            // Cleanup
            Files.deleteIfExists(downloadPath);
        }
    }
    
    private static boolean isValidUrl(String url) {
        try {
            new URL(url);
            return url.toLowerCase().startsWith("https://drive.google.com");
        } catch (MalformedURLException e) {
            return false;
        }
    }
    
    private static String generateTempFileName() {
        return "download_" + System.nanoTime() + ".exe";
    }
    
    private static void downloadFile(String url, Path destination) throws IOException {
        URL website = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) website.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        
        try (InputStream in = conn.getInputStream();
             OutputStream out = Files.newOutputStream(destination)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
    
    private static boolean isValidExe(Path file) throws IOException {
        if (Files.size(file) > 100_000_000) { // 100MB limit
            return false;
        }
        
        try (InputStream is = Files.newInputStream(file)) {
            byte[] header = new byte[2];
            if (is.read(header) != 2) {
                return false;
            }
            return header[0] == 'M' && header[1] == 'Z'; // Check EXE signature
        }
    }
    
    private static void executeFile(Path file) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(file.toString());
        pb.inheritIO();
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Execution interrupted", e);
        }
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            downloadAndExecute("https://drive.google.com/file1.exe");
            downloadAndExecute("https://drive.google.com/file2.exe"); 
            downloadAndExecute("https://drive.google.com/file3.exe");
            downloadAndExecute("https://drive.google.com/file4.exe");
            downloadAndExecute("https://drive.google.com/file5.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
