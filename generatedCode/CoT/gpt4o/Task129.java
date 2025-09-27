package CoT.gpt4o;
import java.io.*;
import java.net.*;

public class Task129 {
    public static String fetchFileFromServer(String serverUrl, String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(serverUrl + "/" + URLEncoder.encode(fileName, "UTF-8"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
                in.close();
            } else {
                return "File not found on server.";
            }
        } catch (Exception e) {
            return "Error fetching file: " + e.getMessage();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String serverUrl = "http://example.com/files";
        System.out.println(fetchFileFromServer(serverUrl, "testfile1.txt"));
        System.out.println(fetchFileFromServer(serverUrl, "testfile2.txt"));
        System.out.println(fetchFileFromServer(serverUrl, "testfile3.txt"));
        System.out.println(fetchFileFromServer(serverUrl, "testfile4.txt"));
        System.out.println(fetchFileFromServer(serverUrl, "testfile5.txt"));
    }
}