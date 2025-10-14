package Vanilla.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task129 {
    public static String fetchFileFromServer(String fileName) {
        try {
            String urlString = "http://yourserver.com/files/" + fileName;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(fetchFileFromServer("file1.txt"));
        System.out.println(fetchFileFromServer("file2.txt"));
        System.out.println(fetchFileFromServer("file3.txt"));
        System.out.println(fetchFileFromServer("file4.txt"));
        System.out.println(fetchFileFromServer("file5.txt"));
    }
}