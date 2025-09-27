package CoT.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Task132 {

    public static void logSecurityEvent(String eventType, String description) {
        try {
            String logMessage = String.format("%s - %s - %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), eventType, description);
            Files.write(Paths.get("security_log.txt"), logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error logging event: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logSecurityEvent("Login Attempt", "User 'admin' logged in successfully.");
        logSecurityEvent("File Access", "User 'guest' attempted to access restricted file 'data.txt'.");
        logSecurityEvent("Network Connection", "Suspicious connection from IP address 192.168.1.100.");
        logSecurityEvent("System Alert", "High CPU usage detected.");
        logSecurityEvent("Logout", "User 'admin' logged out.");
    }
}