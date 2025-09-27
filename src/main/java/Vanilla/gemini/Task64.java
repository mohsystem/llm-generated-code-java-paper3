package Vanilla.gemini;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Task64 {

    public static JSONObject readJsonFromUrl(String url) {
        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a URL as a command-line argument.");
            return;
        }
        String url = args[0];

         try {
            JSONObject json = readJsonFromUrl(url);
            if(json != null) {
                System.out.println(json.toString(2)); // Print formatted JSON
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}