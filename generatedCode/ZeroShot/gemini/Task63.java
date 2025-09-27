package ZeroShot.gemini;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Task63 {

    public static Object processRequest(String raw_data) throws UnsupportedEncodingException, JsonSyntaxException {
        byte[] decodedBytes = Base64.getDecoder().decode(raw_data);
        String decodedString = new String(decodedBytes, "UTF-8");
        Gson gson = new Gson();
        return gson.fromJson(decodedString, Object.class);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, JsonSyntaxException {
        String test1 = Base64.getEncoder().encodeToString("{\"test\": 1}".getBytes("UTF-8"));
        System.out.println(processRequest(test1));

        String test2 = Base64.getEncoder().encodeToString("{\"test\": \"string\"}".getBytes("UTF-8"));
        System.out.println(processRequest(test2));
        
        String test3 = Base64.getEncoder().encodeToString("[1, 2, 3]".getBytes("UTF-8"));
        System.out.println(processRequest(test3));

        String test4 = Base64.getEncoder().encodeToString("{\"nested\": {\"key\": \"value\"}}".getBytes("UTF-8"));
        System.out.println(processRequest(test4));

        String test5 = Base64.getEncoder().encodeToString("null".getBytes("UTF-8"));
        System.out.println(processRequest(test5));

    }
}