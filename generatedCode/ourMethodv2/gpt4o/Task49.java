package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Task49 {
    private List<String> database;

    public Task49() {
        database = new ArrayList<>();
    }

    public boolean storeUserData(String userData) {
        if (validateInput(userData)) {
            database.add(userData);
            return true;
        }
        return false;
    }

    private boolean validateInput(String input) {
        String regex = "^[a-zA-Z0-9_ ]*$";
        return Pattern.matches(regex, input);
    }

    public List<String> getDatabase() {
        return new ArrayList<>(database);
    }

    public static void main(String[] args) {
        Task49 api = new Task49();
        System.out.println(api.storeUserData("User1")); // true
        System.out.println(api.storeUserData("User2")); // true
        System.out.println(api.storeUserData("User3")); // true
        System.out.println(api.storeUserData("Invalid/User")); // false
        System.out.println(api.storeUserData("User4")); // true
        System.out.println(api.getDatabase()); // [User1, User2, User3, User4]
    }
}