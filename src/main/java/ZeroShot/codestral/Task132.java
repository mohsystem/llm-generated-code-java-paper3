package ZeroShot.codestral;
// Java
public class Task132 {
    public static void logEvent(String event) {
        System.out.println("Security Event: " + event);
        // Here you would add your monitoring and logging logic
    }

    public static void main(String[] args) {
        logEvent("User login attempt");
        logEvent("Unauthorized access attempt");
        // Add more test cases as needed
    }
}