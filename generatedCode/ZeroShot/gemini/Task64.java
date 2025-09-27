package ZeroShot.gemini;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Task64 {

    public static JSONObject readJsonFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
            return new JSONObject(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
         try {
            JSONObject json1 = readJsonFromUrl("https://raw.githubusercontent.com/square/okhttp/master/okhttp/src/test/resources/ssl/certificate/cert.pem"); // Invalid JSON URL
            System.out.println(json1);

            JSONObject json2 = readJsonFromUrl("https://api.github.com/users/octocat");
            System.out.println(json2);

             JSONObject json3 = readJsonFromUrl("https://jsonplaceholder.typicode.com/todos/1");
             System.out.println(json3);

             JSONObject json4 = readJsonFromUrl("https://httpstat.us/200"); // Simulate a 200 response, may not be valid json
             System.out.println(json4);

             JSONObject json5 = readJsonFromUrl("https://httpstat.us/404"); // Simulate a 404 error
             System.out.println(json5);


         } catch (Exception e) {
             e.printStackTrace();
         }


    }

}