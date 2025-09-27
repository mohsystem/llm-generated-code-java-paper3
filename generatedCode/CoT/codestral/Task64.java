package CoT.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Task64 {
    public static JsonObject readJsonFromUrl(String url) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(reader, JsonObject.class);
        reader.close();
        return json;
    }

    public static void main(String[] args) {
        try {
            System.out.println(readJsonFromUrl(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}