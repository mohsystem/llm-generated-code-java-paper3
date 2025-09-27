package CoT.llama31;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Task129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to retrieve:");
        String fileName = scanner.nextLine();
        retrieveFile(fileName);
    }

    public static void retrieveFile(String fileName) {
        try {
            URL url = new URL("http://example.com/" + fileName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = connection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(fileName);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("File retrieved successfully.");
            } else {
                System.out.println("Failed to retrieve file. Response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving file: " + e.getMessage());
        }
    }
}