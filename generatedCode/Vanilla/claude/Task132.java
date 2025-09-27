package Vanilla.claude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class SecurityEvent {
    private String eventType;
    private String description;
    private LocalDateTime timestamp;
    
    public SecurityEvent(String eventType, String description) {
        this.eventType = eventType;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s: %s", timestamp.format(formatter), eventType, description);
    }
}

public class Task132 {
    private List<SecurityEvent> eventLog;
    
    public Task132() {
        eventLog = new ArrayList<>();
    }
    
    public void logEvent(String eventType, String description) {
        SecurityEvent event = new SecurityEvent(eventType, description);
        eventLog.add(event);
        System.out.println("Logged: " + event);
    }
    
    public void displayLogs() {
        System.out.println("\\nSecurity Event Log:");
        for(SecurityEvent event : eventLog) {
            System.out.println(event);
        }
    }
    
    public static void main(String[] args) {
        Task132 monitor = new Task132();
        
        // Test Case 1: Login attempt
        monitor.logEvent("LOGIN_ATTEMPT", "User 'admin' logged in successfully");
        
        // Test Case 2: Failed login
        monitor.logEvent("LOGIN_FAILED", "Multiple failed attempts from IP 192.168.1.100");
        
        // Test Case 3: File access
        monitor.logEvent("FILE_ACCESS", "Sensitive file 'data.txt' accessed by user 'john'");
        
        // Test Case 4: Configuration change
        monitor.logEvent("CONFIG_CHANGE", "Firewall rules updated");
        
        // Test Case 5: System alert
        monitor.logEvent("SYSTEM_ALERT", "Unusual network activity detected");
        
        // Display all logs
        monitor.displayLogs();
    }
}
