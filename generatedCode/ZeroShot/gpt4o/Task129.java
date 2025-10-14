package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task129 {
    public static String retrieveFileFromServer(String fileName) {
        String serverUrl = "http://example.com/files/"; // Replace with actual server URL
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(serverUrl + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(retrieveFileFromServer("file1.txt"));
        System.out.println(retrieveFileFromServer("file2.txt"));
        System.out.println(retrieveFileFromServer("file3.txt"));
        System.out.println(retrieveFileFromServer("file4.txt"));
        System.out.println(retrieveFileFromServer("file5.txt"));
    }
}