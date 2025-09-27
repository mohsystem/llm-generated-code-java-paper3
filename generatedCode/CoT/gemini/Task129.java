package CoT.gemini;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;


public class Task129 {

    public static void retrieveFile(String fileName, String serverUrl) throws IOException {
        if (fileName == null || fileName.isEmpty() || fileName.contains("..") || fileName.contains("/")) {
            throw new InvalidParameterException("Invalid file name.");
        }
        if (serverUrl == null || serverUrl.isEmpty()) {
            throw new InvalidParameterException("Invalid server URL.");
        }

        try {
            URL url = new URL(serverUrl + fileName);
            URLConnection connection = url.openConnection();
            InputStream input = new BufferedInputStream(connection.getInputStream());
            File outputFile = new File(fileName); // Save in current directory

            FileOutputStream output = new FileOutputStream(outputFile);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            input.close();
            output.close();

            System.out.println("File " + fileName + " downloaded successfully.");
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error retrieving file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            retrieveFile("test1.txt", "https://www.example.com/");
            retrieveFile("test2.txt", "https://www.example.com/");
            retrieveFile("test3.pdf", "https://www.example.com/");
            retrieveFile("test4.jpg", "https://www.example.com/");
            retrieveFile("test5.doc", "https://www.example.com/");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}