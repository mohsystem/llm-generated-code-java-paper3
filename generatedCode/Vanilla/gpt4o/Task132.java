package Vanilla.openai;
public class Task132 {
    public static void logSecurityEvent(String event) {
        System.out.println("Security Event: " + event);
    }

    public static void main(String[] args) {
        logSecurityEvent("User login attempt");
        logSecurityEvent("Password change request");
        logSecurityEvent("Unauthorized access detected");
        logSecurityEvent("User logout");
        logSecurityEvent("Failed login attempt");
    }
}