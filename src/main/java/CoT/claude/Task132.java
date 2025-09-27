package CoT.claude;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task132 {
    private static final String LOG_FILE = "security_events.log";
    private List<String> eventBuffer;
    private static final int MAX_BUFFER_SIZE = 1000;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Task132() {
        this.eventBuffer = new ArrayList<>();
    }

    public synchronized void logEvent(String eventType, String description) {
        try {
            LocalDateTime timestamp = LocalDateTime.now();
            String logEntry = String.format("[%s] %s: %s", 
                timestamp.format(formatter),
                sanitizeInput(eventType),
                sanitizeInput(description)
            );
            
            // Add to buffer
            eventBuffer.add(logEntry);
            
            // Write to file when buffer reaches limit
            if (eventBuffer.size() >= MAX_BUFFER_SIZE) {
                flushBuffer();
            }
            
            // Print to console
            System.out.println(logEntry);
        } catch (Exception e) {
            System.err.println("Error logging event: " + e.getMessage());
        }
    }

    private String sanitizeInput(String input) {
        if (input == null) return "";
        return input.replaceAll("[^a-zA-Z0-9\\\\s-_.]", "");
    }

    private synchronized void flushBuffer() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            for (String entry : eventBuffer) {
                writer.write(entry);
                writer.newLine();
            }
            writer.flush();
            eventBuffer.clear();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Task132 logger = new Task132();
        
        // Test case 1: Login attempt
        logger.logEvent("LOGIN", "User admin attempted login from IP 192.168.1.1");
        
        // Test case 2: Failed authentication
        logger.logEvent("AUTH_FAIL", "Invalid credentials for user guest");
        
        // Test case 3: File access
        logger.logEvent("FILE_ACCESS", "User admin accessed sensitive_file.txt");
        
        // Test case 4: Configuration change
        logger.logEvent("CONFIG_CHANGE", "Firewall rules updated by system");
        
        // Test case 5: System alert
        logger.logEvent("ALERT", "Multiple failed login attempts detected");
        
        // Flush remaining entries
        logger.flushBuffer();
    }
}
