package ZeroShot.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task132 {

    public static void logSecurityEvent(String eventType, String description) {
        String logMessage = String.format("%s - %s - %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), eventType, description);
        Path logFile = Paths.get("security_log.txt");
        try {
            Files.write(logFile, logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        logSecurityEvent("Login Attempt", "User 'admin' logged in successfully from IP 192.168.1.1");
        logSecurityEvent("File Access", "User 'guest' attempted to access restricted file '/etc/passwd'");
        logSecurityEvent("Network Connection", "Outbound connection to 8.8.8.8 on port 53");
        logSecurityEvent("System Event", "System restarted unexpectedly");
        logSecurityEvent("Logout", "User 'admin' logged out.");

    }
}