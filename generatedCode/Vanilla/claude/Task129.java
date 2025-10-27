package Vanilla.claude;

import java.io.*;
import java.net.*;

public class Task129 {
    public static String retrieveFile(String fileName, String serverUrl) {
        try {
            URL url = new URL(serverUrl + "/" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            if (conn.getResponseCode() != 200) {
                return "Error: File not found";
            }

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            return content.toString();
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String serverUrl = "http://example.com/files";
        
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "document.pdf",
            "image.jpg",
            "nonexistent.txt",
            "data.csv"
        };
        
        for(String file : testFiles) {
            System.out.println("Retrieving: " + file);
            System.out.println(retrieveFile(file, serverUrl));
            System.out.println("------------------------");
        }
    }
}
