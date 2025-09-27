package CoT.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task136 {

    private static final Map<String, String> users = new HashMap<>();

    public static boolean authenticate(String username, String password) {
        if (!users.containsKey(username)) {
            return false; // User not found
        }
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Initialize some users (in real app, this would come from a database)
        users.put("john", "password123");
        users.put("jane", "securepass");
        users.put("admin", "adminpass");


        // Test cases
        System.out.println(authenticate("john", "password123")); //true
        System.out.println(authenticate("jane", "wrongpass"));   //false
        System.out.println(authenticate("peter", "pass123"));   //false
        System.out.println(authenticate("admin", "adminpass"));  //true
        System.out.println(authenticate("john", "wrongpassword"));//false

    }
}