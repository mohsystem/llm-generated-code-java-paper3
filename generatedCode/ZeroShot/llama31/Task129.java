package ZeroShot.llama31;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task129 {
    public static void main(String[] args) {
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String fileName : fileNames) {
            retrieveFile(fileName);
        }
    }

    public static void retrieveFile(String fileName) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://example.com/" + fileName))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("File content: " + response.body());
            } else {
                System.out.println("Failed to retrieve file: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error retrieving file: " + e.getMessage());
        }
    }
}