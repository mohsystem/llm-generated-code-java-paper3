package ZeroShot.gemini;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Task129 {

    public static void retrieveFile(String fileName) throws IOException {
        String serverUrl = "http://example.com/"; // Replace with your server URL
        String fullUrl = serverUrl + fileName;

        try {
            URL url = new URL(fullUrl);
            URLConnection connection = url.openConnection();
            
            // Security: Check file extension to prevent downloading executables.
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
            if (extension.equals("exe") || extension.equals("sh") || extension.equals("bat")) {
                throw new IOException("Downloading executable files is not allowed.");
            }

            Files.copy(connection.getInputStream(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File downloaded successfully: " + fileName);

        } catch (IOException e) {
            System.err.println("Error downloading file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            retrieveFile("test.txt");
            retrieveFile("image.jpg");
            retrieveFile("data.csv");
            retrieveFile("document.pdf");
            retrieveFile("malicious.exe"); // This should throw an exception
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        scanner.close();

    }
}