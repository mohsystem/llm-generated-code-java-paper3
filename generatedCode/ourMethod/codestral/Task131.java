package ourMethod.codestral;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task131 {
    public static Object deserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Object.class);
    }

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("input.json")));
        Object obj = deserialize(json);
        System.out.println(obj);
    }
}