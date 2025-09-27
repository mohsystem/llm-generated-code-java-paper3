package ourMethod.gemini;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

public class Task129 {

    public static String retrieveFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "File name cannot be empty.";
        }
		
		String serverAddress = "http://example.com/files/"; // Replace with actual server address
		String filePath = serverAddress + fileName;

        try {
            URL url = new URL(filePath);
            URLConnection connection = url.openConnection();
            BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName); // Save with user-provided name
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            fileOutputStream.close();
            in.close();
            return "File retrieved successfully.";

        } catch (MalformedURLException e) {
            return "Invalid URL format: " + e.getMessage();
        } catch (IOException e) {
            return "Error retrieving file: " + e.getMessage();
        }
    }


    public static void main(String[] args) {
        String[] testCases = {"test1.txt", "report.pdf", "image.jpg", "archive.zip", "document.docx"};
        for (String testCase : testCases) {
            String result = retrieveFile(testCase);
            System.out.println("Test case: " + testCase + ", Result: " + result);
        }
    }
}