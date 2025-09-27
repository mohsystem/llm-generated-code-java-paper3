package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Task64 {
    public static JsonObject readJsonFromUrl(String url) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        JsonObject jsonObject = new Gson().fromJson(reader, JsonObject.class);
        reader.close();
        return jsonObject;
    }

    public static void main(String[] args) {
        try {
            System.out.println(readJsonFromUrl("http://example.com/file.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}