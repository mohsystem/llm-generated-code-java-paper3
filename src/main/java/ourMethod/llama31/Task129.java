package ourMethod.llama31;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Task129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        scanner.close();

        try {
            URL url = new URL("https://example.com/" + fileName);
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
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("File not found or error: " + responseCode);
            }
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}