package Vanilla.claude;

import java.io.*;
import java.net.*;

public class Task86 {
    public static void downloadAndExecute(String url) {
        try {
            // Extract filename from URL
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            
            // Download file
            URL downloadUrl = new URL(url);
            URLConnection conn = downloadUrl.openConnection();
            InputStream in = conn.getInputStream();
            FileOutputStream out = new FileOutputStream(fileName);
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();

            // Execute file
            Process process = Runtime.getRuntime().exec(fileName);
            process.waitFor();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test cases - Note: Using dummy URLs for demonstration
        String[] testUrls = {
            "http://example.com/program1.exe",
            "http://example.com/program2.exe",
            "http://example.com/program3.exe",
            "http://example.com/program4.exe",
            "http://example.com/program5.exe"
        };
        
        for(String url : testUrls) {
            System.out.println("Testing URL: " + url);
            downloadAndExecute(url);
        }
    }
}
