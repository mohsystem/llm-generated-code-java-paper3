package CoT.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task132 {
    private static final Logger logger = Logger.getLogger(Task132.class.getName());

    public static void main(String[] args) {
        try {
            // Set up logging
            FileHandler fileHandler = new FileHandler("security_log.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            // Test cases
            logEvent("Login attempt", "User1", "Success");
            logEvent("Login attempt", "User2", "Failure");
            logEvent("File access", "User1", "Success");
            logEvent("Network connection", "User3", "Success");
            logEvent("System access", "User4", "Failure");
        } catch (Exception e) {
            logger.severe("Error setting up logging: " + e.getMessage());
        }
    }

    public static void logEvent(String eventType, String user, String status) {
        String logMessage = String.format("%s by %s: %s", eventType, user, status);
        logger.info(logMessage);
        System.out.println(logMessage);
    }
}