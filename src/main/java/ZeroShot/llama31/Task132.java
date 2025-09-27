package ZeroShot.llama31;
public class Task132 {
    public static void logSecurityEvent(String event) {
        System.out.println("Security Event: " + event);
    }

    public static void main(String[] args) {
        // Test cases
        logSecurityEvent("Alert from antivirus: Malware infection detected");
        logSecurityEvent("Firewall alert: Blocked network traffic from unknown host");
        logSecurityEvent("Failed login attempt: Multiple attempts from same IP");
        logSecurityEvent("Change in user privileges: Privilege escalation detected");
        logSecurityEvent("Use of new or unknown port: Potential security breach");
    }
}