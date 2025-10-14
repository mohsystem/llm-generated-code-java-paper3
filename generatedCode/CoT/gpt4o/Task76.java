package CoT.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Task76 {

    public static String getPageTitle(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            String contentStr = content.toString();
            int titleStart = contentStr.indexOf("<title>") + 7;
            int titleEnd = contentStr.indexOf("</title>");
            if (titleStart != -1 && titleEnd != -1) {
                return contentStr.substring(titleStart, titleEnd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String url : args) {
                String title = getPageTitle(url);
                System.out.println("URL: " + url + " Title: " + title);
            }
        } else {
            System.out.println("No URL provided.");
        }
    }
}