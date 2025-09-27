package Vanilla.gpt4o;
// Simple representation, no actual API or database connection
import java.util.ArrayList;
import java.util.List;

class Task49 {
    private List<String> database;

    public Task49() {
        this.database = new ArrayList<>();
    }

    public void storeUserData(String userData) {
        database.add(userData);
        System.out.println("Data stored: " + userData);
    }

    public static void main(String[] args) {
        Task49 task = new Task49();
        task.storeUserData("User1");
        task.storeUserData("User2");
        task.storeUserData("User3");
        task.storeUserData("User4");
        task.storeUserData("User5");
    }
}