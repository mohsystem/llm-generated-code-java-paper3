package Vanilla.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Task132 {

    public static void logSecurityEvent(String eventType, String description) {
        String logEntry = String.format("%s - %s - %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), eventType, description);
        try {
            Files.write(Paths.get("security_log.txt"), logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        logSecurityEvent("Login Attempt", "User 'admin' logged in successfully.");
        logSecurityEvent("File Access", "User 'guest' attempted to access restricted file 'data.txt'.");
        logSecurityEvent("Network Connection", "Incoming connection from IP address 192.168.1.100.");
        logSecurityEvent("Logout", "User 'admin' logged out.");
        logSecurityEvent("System Shutdown", "System initiated shutdown.");

    }
}