package ZeroShot.gpt4o;
// Java code for a simple API endpoint using a local list as a mock database

import java.util.ArrayList;
import java.util.List;

public class Task49 {
    private static List<String> database = new ArrayList<>();

    public static String addUser(String userData) {
        if (userData == null || userData.isEmpty()) {
            return "Invalid user data.";
        }
        database.add(userData);
        return "User added successfully.";
    }

    public static void main(String[] args) {
        System.out.println(addUser("John Doe"));
        System.out.println(addUser("Jane Smith"));
        System.out.println(addUser(""));
        System.out.println(addUser(null));
        System.out.println(addUser("Alice Brown"));
    }
}