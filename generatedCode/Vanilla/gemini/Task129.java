package Vanilla.gemini;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.FileOutputStream;

public class Task129 {
    public static void retrieveFile(String fileName) throws IOException {
        try {
            URL url = new URL("http://example.com/" + fileName); // Replace with your server URL
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            System.out.println("File downloaded successfully: " + fileName);


        } catch (IOException e) {
            System.err.println("Error downloading file: " + e.getMessage());
            throw e;
        }
    }


    public static void main(String[] args) {
        try {
            retrieveFile("file1.txt");
            retrieveFile("file2.pdf");
            retrieveFile("image.jpg");
            retrieveFile("data.csv");
            retrieveFile("nonexistent_file.txt"); // Test case for a non-existent file
        } catch (IOException e) {
            System.err.println("An error occurred during file retrieval.");
        }
    }
}