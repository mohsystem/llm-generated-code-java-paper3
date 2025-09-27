package CoT.gpt4o;
public class Task132 {

    public static void logEvent(String event) {
        // Log the security event
        System.out.println("Security Event Logged: " + event);
    }

    public static void main(String[] args) {
        // Test cases
        logEvent("User login attempt");
        logEvent("File access violation");
        logEvent("Unauthorized access");
        logEvent("System settings change");
        logEvent("Suspicious network activity");
    }
}