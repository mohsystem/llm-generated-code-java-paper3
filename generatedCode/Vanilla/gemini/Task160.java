package Vanilla.gemini;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Task160 {

    public static String makeHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return response.toString();

    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = scanner.nextLine();
        String response = makeHttpRequest(url);
        System.out.println(response);

        System.out.println(makeHttpRequest("https://www.example.com"));
        System.out.println(makeHttpRequest("https://www.google.com"));
        System.out.println(makeHttpRequest("https://www.bing.com"));
        System.out.println(makeHttpRequest("https://www.yahoo.com"));
        System.out.println(makeHttpRequest("https://www.amazon.com"));

        scanner.close();

    }

}