package ourMethod.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task132 {

    private static final String LOG_FILE = "security_events.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void logEvent(String eventType, String eventDetails) {
        LocalDateTime now = LocalDateTime.now();
        String logMessage = formatter.format(now) + " - " + eventType + ": " + eventDetails + System.lineSeparator();

        try {
            Files.write(Paths.get(LOG_FILE), logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


    public static List<String> monitorEvents(int numEvents) {
        List<String> events = new ArrayList<>();
        try {
            List<String> logLines = Files.readAllLines(Paths.get(LOG_FILE));
            int startIndex = Math.max(0, logLines.size() - numEvents);
            for (int i = startIndex; i < logLines.size(); i++) {
                events.add(logLines.get(i));
            }

        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }

        return events;
    }

    public static void main(String[] args) {

        logEvent("Login Attempt", "User 'admin' logged in from IP 192.168.1.1");
        logEvent("File Access", "User 'user1' accessed file '/etc/passwd'");
        logEvent("Network Connection", "Outbound connection to 10.0.0.1:80");
        logEvent("System Alert", "CPU usage exceeded 90%");
        logEvent("Logout", "User 'admin' logged out.");

        List<String> recentEvents = monitorEvents(3);
        for (String event : recentEvents) {
            System.out.println(event);
        }

        logEvent("Unauthorized Access Attempt", "Failed login attempt for user 'root'");
        logEvent("System Error", "Kernel panic");


        recentEvents = monitorEvents(2);
        for (String event : recentEvents) {
            System.out.println(event);
        }
    }
}