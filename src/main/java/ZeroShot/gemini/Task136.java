package ZeroShot.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Task136 {
    private static final Map<String, String> users = new HashMap<>();

    public static boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        users.put("user1", "password123");
        users.put("user2", "securepass");
        users.put("admin", "adminpass");


        Scanner scanner = new Scanner(System.in);

        System.out.println(authenticate("user1", "password123")); //true
        System.out.println(authenticate("user1", "wrongpass")); //false
        System.out.println(authenticate("user3", "anypass")); //false
        System.out.println(authenticate("admin", "adminpass")); //true
        System.out.println(authenticate("user2", "securepass")); //true


    }
}