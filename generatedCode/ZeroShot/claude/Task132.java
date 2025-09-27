package ZeroShot.claude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task132 {
    private static List<SecurityEvent> eventLog = new ArrayList<>();
    
    private static class SecurityEvent {
        private LocalDateTime timestamp;
        private String eventType;
        private String description;
        private String severity;
        
        public SecurityEvent(String eventType, String description, String severity) {
            this.timestamp = LocalDateTime.now();
            this.eventType = eventType;
            this.description = description;
            this.severity = severity;
        }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return String.format("[%s] %s - %s (Severity: %s)", 
                timestamp.format(formatter), eventType, description, severity);
        }
    }
    
    public static void logSecurityEvent(String eventType, String description, String severity) {
        SecurityEvent event = new SecurityEvent(eventType, description, severity);
        eventLog.add(event);
        System.out.println("New security event logged: " + event);
    }
    
    public static List<SecurityEvent> getEventLog() {
        return new ArrayList<>(eventLog);
    }
    
    public static void clearEventLog() {
        eventLog.clear();
        System.out.println("Security event log cleared");
    }
    
    public static void main(String[] args) {
        // Test case 1: Log login attempt
        logSecurityEvent("LOGIN_ATTEMPT", "Failed login attempt from IP 192.168.1.100", "HIGH");
        
        // Test case 2: Log file access
        logSecurityEvent("FILE_ACCESS", "Unauthorized access to sensitive file", "CRITICAL");
        
        // Test case 3: Log system update
        logSecurityEvent("SYSTEM_UPDATE", "Security patches installed successfully", "LOW");
        
        // Test case 4: Log network event
        logSecurityEvent("NETWORK", "Suspicious network traffic detected", "MEDIUM");
        
        // Test case 5: Log configuration change
        logSecurityEvent("CONFIG_CHANGE", "Firewall rules modified", "HIGH");
        
        // Display all logged events
        System.out.println("\\nAll Security Events:");
        for(SecurityEvent event : getEventLog()) {
            System.out.println(event);
        }
    }
}
