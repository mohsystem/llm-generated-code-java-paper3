package Vanilla.llama31;
public class Task132 {
    public static void logSecurityEvent(String event) {
        System.out.println("Security Event: " + event);
    }

    public static void main(String[] args) {
        // Test cases
        logSecurityEvent("Alert from antivirus: Malware detected");
        logSecurityEvent("Firewall alert: Blocked network traffic from unknown host");
        logSecurityEvent("Failed login attempt");
        logSecurityEvent("Change in user privileges: Privilege escalation");
        logSecurityEvent("Connection from unknown IP");
    }
}