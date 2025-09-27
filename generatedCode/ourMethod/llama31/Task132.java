package ourMethod.llama31;
public class Task132 {
    public static void main(String[] args) {
        // Test cases
        logSecurityEvent("Alert from antivirus", "Malware detected");
        logSecurityEvent("Firewall alert", "Blocked network traffic");
        logSecurityEvent("Failed login", "Repeated failed logins");
        logSecurityEvent("Unknown host connection", "Connection from unknown IP");
        logSecurityEvent("Privilege escalation", "Change in user privileges");
    }

    public static void logSecurityEvent(String eventType, String eventDetails) {
        // Simulate logging to a file or database
        System.out.println("Security Event: " + eventType + " - " + eventDetails);
        // Here you can implement actual logging to a file, database, or other logging mechanism
    }
}