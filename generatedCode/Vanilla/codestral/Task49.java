package Vanilla.codestral;
public class Task49 {
    public static String storeUserData(String userData) {
        // In a real application, you would store the userData in a database here
        return "User data received and stored: " + userData;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(storeUserData("John Doe, johndoe@example.com"));
        System.out.println(storeUserData("Jane Doe, janedoe@example.com"));
        // Add more test cases as needed
    }
}