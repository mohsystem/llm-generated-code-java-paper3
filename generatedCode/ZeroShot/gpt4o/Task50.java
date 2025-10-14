package ZeroShot.openai;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Task50 {

    public static String uploadFile(String filePath, String serverUrl) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return "File not found.";
            }

            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            try (OutputStream os = connection.getOutputStream();
                 FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "File uploaded successfully.";
            } else {
                return "Failed to upload file. Server responded with code: " + responseCode;
            }

        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(uploadFile("path/to/file1.txt", "http://example.com/upload"));
        System.out.println(uploadFile("path/to/file2.txt", "http://example.com/upload"));
        System.out.println(uploadFile("path/to/file3.txt", "http://example.com/upload"));
        System.out.println(uploadFile("path/to/file4.txt", "http://example.com/upload"));
        System.out.println(uploadFile("path/to/file5.txt", "http://example.com/upload"));
    }
}